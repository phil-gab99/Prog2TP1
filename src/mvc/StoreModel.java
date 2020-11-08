package mvc;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.ConcurrentModificationException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.25.11 2020-11-12
*
* The class StoreModel gives the details of the actions to be ensued upon
* triggering action events
**/

class StoreModel {

    private StoreView view;
    private DefaultListModel<String> model;

    public StoreModel(StoreView view) {

        this.view = view;
    }

    public void format(KeyEvent e, char lb, char ub) {

        char c = e.getKeyChar();

        if (((c < lb) || (c > ub))) {
            e.consume();
        }
    }

    public String getRadioButtonText(ButtonGroup group) {

        for (Enumeration buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    /*
    * The method addAccount handles the event of adding an account with the
    * included details specified
    **/

    public void addAccount() {

        view.accountDialog("Add Account");
    }

    public void deleteAccount() {

        try {

            String[] users = new String[view.list.getSelectedValuesList().size()];
            view.list.getSelectedValuesList().toArray(users);

            if (users.length == 0) {
                view.msgBox("Please select a user to delete.",
                "No User Selected", JOptionPane.ERROR_MESSAGE);
                return;
            }

            model = (DefaultListModel<String>) view.list.getModel();
            int[] selectedIndices = view.list.getSelectedIndices();

            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.remove(selectedIndices[i]);
            }

            for (String user : users) {

                String userEmail = user.split(" - ")[3];
                Base.deleteAccount(Base.userFromEmail(userEmail));
            }
        } catch(ConcurrentModificationException e) {
            //do nothing
        }
    }

    public void addBalance() {

        String[] users = new String[view.list.getSelectedValuesList().size()];
        view.list.getSelectedValuesList().toArray(users);

        if (users.length == 0) {
            view.msgBox("Please select a user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (users.length > 1) {
            view.msgBox("Please select a single user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            String userEmail = users[0].split(" - ")[3];
            view.addBalanceDialog("Add Balance", Base.userFromEmail(userEmail));
        }
    }

    public void okAccount() {

        String lastName;
        String firstName;

        try {
            lastName = view.details.get(0).getText().substring(0,1).toUpperCase()
            + view.details.get(0).getText().substring(1);
            firstName = view.details.get(1).getText().substring(0,1).toUpperCase()
            + view.details.get(1).getText().substring(1);
        } catch(StringIndexOutOfBoundsException e) {
            view.msgBox("Please enter a last name and a first name for the user.",
            "No Names Entered", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int day;
        int month;
        int year;

        try {

            day = Integer.parseInt(view.details.get(2).getText());

            if (day > 31) {

                view.msgBox("Please enter a valid birth day.",
                "Day Out Of Range", JOptionPane.ERROR_MESSAGE);
                return;
            }

            month = Integer.parseInt(view.details.get(3).getText());

            if (month > 12) {

                view.msgBox("Please enter a valid birth month.",
                "Month Out Of Range", JOptionPane.ERROR_MESSAGE);
                return;
            }

            year = Integer.parseInt(view.details.get(4).getText());
        } catch(NumberFormatException e) {
            view.msgBox("Please enter an input for the user's birth date.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }


        String birth = day + "/" + month + "/" + year;

        String position = getRadioButtonText(view.group);

        Account a;

        if (position == "Client") {
            a = new Client(lastName, firstName, birth);
        } else if (position == "Employee") {
            a = new Employee(lastName, firstName, birth);
        } else if (position == "Manager") {
            a = new Manager(lastName, firstName, birth);
        } else {
            view.msgBox("Please select a position for this user.",
            "No Position Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model = (DefaultListModel<String>) view.list.getModel();
        model.addElement(a.toString());
        cancel();
    }

    public void okAddBalance() {

        int amount;

        try {
            amount = Integer.parseInt(view.details.get(0).getText());
        } catch(NumberFormatException e) {
            view.msgBox("Please enter an amount.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        view.accountOperation.addBalance(amount);

        model = (DefaultListModel<String>) view.list.getModel();
        model.set(view.list.getSelectedIndex(),view.accountOperation.toString());
        cancel();
    }

    public void cancel() {
        view.dialog.dispose();
    }
}