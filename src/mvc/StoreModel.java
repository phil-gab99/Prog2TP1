package mvc;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.ConcurrentModificationException;
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

    public StoreModel(StoreView view) {

        this.view = view;
    }

    /*
    * The method addAccount handles the event of adding an account with the
    * included details specified
    **/

    public void addAccount() {

        DefaultListModel<String> model = (DefaultListModel<String>) view.list.getModel();
        // Client c1 = new Client("Ayoub", "Souleiman", "00/00/0000");

        view.accountDialog("Add Account");
        // model.add(0,c1.toString());
    }

    public void deleteAccount() {

        try {

            String[] users = new String[view.list.getSelectedValuesList().size()];
            view.list.getSelectedValuesList().toArray(users);

            if (users.length == 0) {
                System.out.println("I am here");
                view.msgBox("Please select a user to delete.",
                    "No User Selected", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultListModel<String> model = (DefaultListModel<String>) view.list.getModel();
            int[] selectedIndices = view.list.getSelectedIndices();

            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.remove(i);
            }

            for (String user : users) {

                String userEmail = user.split(" - ")[3];
                Base.deleteAccount(userEmail);
            }
        } catch(ConcurrentModificationException e) {

        }
    }
}