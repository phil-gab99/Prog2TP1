package mvc;

import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Arrays;
import java.util.List;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import inventory.Food;
import inventory.Furniture;
import store.*;

/**
* @author Philippe Gabriel
* @version 1.25.11 2020-11-12
*
* The class StoreModel gives the details of the actions to be ensued upon
* triggering action events
***/

class StoreModel {

    //View allowing control of the user interface elements
    private StoreView view;
    private DefaultListModel<String> model; //List model of JLists

    /**
    * The constructor method StoreModel allows the link between the model
    * and view classes for graphical interface interactions
    *
    * @param view StoreView granting access to methods configuring graphical
    * elements
    ***/

    public StoreModel(StoreView view) {

        this.view = view;
    }

    /**
    * The method generateInterface creates a frame with a list of user
    * requested data separate from the main frame to display
    *
    * @param data String array to be displayed
    ***/

    public void generateInterface(String[] data) {

        cancel(); //The dialog initiating this action is first closed
        view.makeResultsFrame();

        //The model accesses the listResults model
        model = (DefaultListModel<String>) view.listResults.getModel();

        //Elements are added to the list
        for (String e : data) {

            if (e != null) {

                model.addElement(e);
            } else {

                break;
            }
        }
    }

    /**
    * The method formatLetters restricts the input within the caller textfield
    * to only be letters
    *
    * @param e KeyEvent holding information on the key that was typed
    ***/

    public void formatLetters(KeyEvent e) {

        char c = e.getKeyChar();

        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {

            e.consume();
        }
    }

    /**
    * The method formatNumbers restricts the input within the caller textfield
    * to only be numbers
    *
    * @param e KeyEvent holding information on the key that was typed
    ***/

    public void formatNumbers(KeyEvent e) {

        char c = e.getKeyChar();

        if ((c < '0') || (c > '9')) {

            e.consume();
        }
    }

    /**
    * The method formatMixed restricts the input within the caller textfield
    * to only be letters and numbers
    *
    * @param e KeyEvent holding information on the key that was typed
    ***/

    public void formatMixed(KeyEvent e) {

        char c = e.getKeyChar();

        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')
        && (c < '0' || c > '9')) {

            e.consume();
        }
    }

    /**
    * The method maxColumns restricts the length of the input within the caller
    * textfield to be by the specified length
    *
    * @param e KeyEvent holding information on the key that was typed
    * @param textLength Integer indicating maximum length
    ***/

    public void maxColumns(KeyEvent e, int textLength) {

        JTextField textfield = (JTextField) e.getComponent();

        if (textfield.getText().length() >= textLength) {

            e.consume();
        }
    }

    /**
    * The method getRadioButtonText provides the string label attached to the
    * selected radio button from within a given group of radio buttons
    *
    * @group ButtonGroup of radio buttons of interest
    * @return String indicating the radio button label
    ***/

    public String getRadioButtonText(ButtonGroup group) {

        //The elements of the group are cycled through
        for (Enumeration buttons = group.getElements();
        buttons.hasMoreElements();) {

            AbstractButton button = (AbstractButton) buttons.nextElement();

            if (button.isSelected()) {

                return button.getText();
            }
        }

        return null;
    }

    /**
    * The method ProductFields manages the products fillable traits with
    * respect to the user's selection
    ***/

    public void productFields() {

        try {

            if (getRadioButtonText(view.group).equals("Food")) {

                //The food product traits are available for modification

                for (int i = 0; i < 3; i++) {
                    view.details.get(i).setEnabled(true);
                }

                for (int i = 3; i < view.details.size(); i++) {
                    view.details.get(i).setEnabled(false);
                    view.details.get(i).setText("");
                }
            } else if (getRadioButtonText(view.group).equals("Furniture")) {

                //The furniture product traits are available for modification

                for (int i = 0; i < 3; i++) {
                    view.details.get(i).setEnabled(false);
                    view.details.get(i).setText("");
                }

                for (int i = 3; i < view.details.size(); i++) {
                    view.details.get(i).setEnabled(true);
                }
            }
        } catch(NullPointerException e) {

            //do nothing
        }
    }

    /**
    * The method addAccount generates the dialog for details on account adding
    ***/

    public void addAccount() {

        view.accountDialog();
    }

    /**
    * The method deleteAccount deletes account(s) from the graphical list and
    * from the temporary database
    ***/

    public void deleteAccount() {

        try {

            //Acquiring list model in string array format of selected users
            String[] users
            = new String[view.listAccounts.getSelectedValuesList().size()];
            view.listAccounts.getSelectedValuesList().toArray(users);

            //At least one user needs to be selected
            if (users.length == 0) {
                StoreView.msgBox("Please select a user to delete.",
                "No User Selected", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Acquiring list model selected indices
            model = (DefaultListModel<String>) view.listAccounts.getModel();
            int[] selectedIndices = view.listAccounts.getSelectedIndices();

            //Removing element(s) from graphical list
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.remove(selectedIndices[i]);
            }

            //Removing element(s) from temporary database
            for (String user : users) {

                String userEmail = user.split("_")[3];
                Base.deleteAccount(Base.userFromEmail(userEmail));
            }
        } catch(ConcurrentModificationException e) {
            //Do nothing
        }
    }

    /**
    * The method advSearch generates the dialog for leading an advanced search
    ***/

    public void advSearch() {

        view.advSearchDialog();
    }

    /**
    * The method addBalance generates the dialog for adding balance
    ***/

    public void addBalance() {

        //Acquiring list model in string array format
        String[] users =
        new String[view.listAccounts.getSelectedValuesList().size()];
        view.listAccounts.getSelectedValuesList().toArray(users);

        //A single user must be selected for this operation
        if (users.length == 0) {

            StoreView.msgBox("Please select a user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (users.length > 1) {

            StoreView.msgBox("Please select a single user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Account user = Base.userFromEmail(users[0].split("_")[3]);
            view.addBalanceDialog(user);
        }
    }

    /**
    * The method deductBalance generates the dialog for deducting balance
    ***/

    public void deductBalance() {

        //Acquiring list model in string array format
        String[] users =
        new String[view.listAccounts.getSelectedValuesList().size()];
        view.listAccounts.getSelectedValuesList().toArray(users);

        //A single user must be selected for this operation
        if (users.length == 0) {

            StoreView.msgBox("Please select a user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (users.length > 1) {

            StoreView.msgBox("Please select a single user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Account user = Base.userFromEmail(users[0].split("_")[3]);
            view.deductBalanceDialog(user);
        }
    }

    /**
    * The method favProducts generates the frame for displaying a selected
    * user's list of favorite products
    ***/

    public void favProducts() {

        //Acquiring list model in String array format
        String[] users =
        new String[view.listAccounts.getSelectedValuesList().size()];
        view.listAccounts.getSelectedValuesList().toArray(users);

        //A single user must be selected for this operation
        if (users.length == 0) {

            StoreView.msgBox("Please select a user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (users.length > 1) {

            StoreView.msgBox("Please select a single user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Account user = Base.userFromEmail(users[0].split("_")[3]);
            view.makeFavProductsFrame(user);
        }
    }

    /**
    * The method avProducts generates the frame for displaying the store
    * available products under a given user
    ***/

    public void avProducts() {

        //Acquiring list model in String array format
        String[] users =
        new String[view.listAccounts.getSelectedValuesList().size()];
        view.listAccounts.getSelectedValuesList().toArray(users);

        //A single user must be selected for this operation
        if (users.length == 0) {

            StoreView.msgBox("Please select a user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (users.length > 1) {

            StoreView.msgBox("Please select a single user.",
            "No User Selected", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Account user = Base.userFromEmail(users[0].split("_")[3]);
            view.makeViewProductsFrame(user);
        }
    }

    /**
    * The method okAccount retrieves the different user input in the available
    * fields to create an account by displaying it in the graphical list and
    * adding it to the temporary database
    ***/

    public void okAccount() {

        String lastName;
        String firstName;

        //Testing whether name fields were filled or not
        try {

            lastName = view.details.get(0).getText().substring(0,1).
            toUpperCase()
            + view.details.get(0).getText().substring(1).toLowerCase();

            firstName = view.details.get(1).getText().substring(0,1).
            toUpperCase()
            + view.details.get(1).getText().substring(1).toLowerCase();
        } catch(StringIndexOutOfBoundsException e) {

            StoreView.msgBox(
            "Please enter a last name and a first name for the user.",
            "No Names Entered", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int day;
        int month;
        int year;

        //Testing whether number fields were filled or not
        try {

            day = Integer.parseInt(view.details.get(2).getText());

            if (day > 30) {   //Input day cannot exceed 30

                StoreView.msgBox("Please enter a valid birth day.",
                "Day Out Of Range", JOptionPane.ERROR_MESSAGE);
                return;
            }

            month = Integer.parseInt(view.details.get(3).getText());

            if (month > 12) { //Input month cannot exceed 12

                StoreView.msgBox("Please enter a valid birth month.",
                "Month Out Of Range", JOptionPane.ERROR_MESSAGE);
                return;
            }

            year = Integer.parseInt(view.details.get(4).getText());
        } catch(NumberFormatException e) {

            StoreView.msgBox(
            "Please enter an input for the user's birth date.", "No Input",
            JOptionPane.ERROR_MESSAGE);
            return;
        }


        String birth = day + "/" + month + "/" + year;

        String position = getRadioButtonText(view.group);

        Account newAccount;

        //Creating account based on position selection
        if (position == "Client") {

            newAccount = new Client(lastName, firstName, birth);
        } else if (position == "Employee") {

            newAccount = new Employee(lastName, firstName, birth);
        } else if (position == "Manager") {

            newAccount = new Manager(lastName, firstName, birth);
        } else {

            StoreView.msgBox("Please select a position for this user.",
            "No Position Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Acquiring list model to add the newly created account
        model = (DefaultListModel<String>) view.listAccounts.getModel();
        model.addElement(newAccount.toString());

        cancel();
    }

    /**
    * The method okAddBalance issues the balance adding for the selected user
    ***/

    public void okAddBalance() {

        int amount;

        //Testing whether field was filled or not
        try {

            amount = Integer.parseInt(view.details.get(0).getText());
        } catch(NumberFormatException e) {

            StoreView.msgBox("Please enter an amount.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //The change is first undertaken in the temporary database
        view.accountOperation.addBalance(amount);

        //Acquiring list model to update the change on the graphical list
        model = (DefaultListModel<String>) view.listAccounts.getModel();
        model.set(view.listAccounts.getSelectedIndex(),
        view.accountOperation.toString());

        cancel();
    }

    /**
    * The method okDeductBalance issues the balance deducting for the selected
    * user
    ***/

    public void okDeductBalance() {

        int amount;

        //Testing whether field was filled or not
        try {

            amount = Integer.parseInt(view.details.get(0).getText());
        } catch(NumberFormatException e) {

            StoreView.msgBox("Please enter an amount.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //The change is first undertaken in the temporary database
        view.accountOperation.deductBalance(amount);

        //Acquiring list model to update the change on the graphical list
        model = (DefaultListModel<String>) view.listAccounts.getModel();
        model.set(view.listAccounts.getSelectedIndex(),
        view.accountOperation.toString());

        cancel();
    }

    /**
    * The method advSearchSingle undertakes the single user search based on the
    * filled out fields from the user
    ***/

    public void advSearchSingle() {

        String lastName;
        String firstName;
        String email;

        //Testing whether string fields were filled or not
        try {

            lastName = view.details.get(0).getText().substring(0,1).
            toUpperCase()
            + view.details.get(0).getText().substring(1).toLowerCase();

            firstName = view.details.get(1).getText().substring(0,1).
            toUpperCase()
            + view.details.get(1).getText().substring(1).toLowerCase();

            email = view.details.get(5).getText() + "@magasin.ca";
        } catch(StringIndexOutOfBoundsException e) {

            StoreView.msgBox("Please fill out every field.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int day = 0;
        int month = 0;
        int year = 0;

        String birth;

        int balance;

        //Testing whether integer fields were filled or not
        try {

            day = Integer.parseInt(view.details.get(2).getText());

            if (day > 30) {   //Input day cannot exceed 30

                StoreView.msgBox("Please enter a valid birth day.",
                "Day Out Of Range", JOptionPane.ERROR_MESSAGE);
                return;
            }

            month = Integer.parseInt(view.details.get(3).getText());

            if (month > 12) { //Input month cannot exceed 30

                StoreView.msgBox("Please enter a valid birth month.",
                "Month Out Of Range", JOptionPane.ERROR_MESSAGE);
                return;
            }

            year = Integer.parseInt(view.details.get(4).getText());

            birth = day + "/" + month + "/" + year;

            balance = Integer.parseInt(view.details.get(6).getText());
        } catch(NumberFormatException e) {

            StoreView.msgBox("Please fill out every field.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String position = getRadioButtonText(view.group);

        Account dummy;

        //Dummy account created for comparison with list of registered accounts
        if (position == "Client") {

            dummy = new Client(lastName, firstName, birth, email, balance);
        } else if (position == "Employee") {

            dummy = new Employee(lastName, firstName, birth, email, balance);
        } else if (position == "Manager") {

            dummy = new Manager(lastName, firstName, birth, email, balance);
        } else {

            StoreView.msgBox("Please fill out every field.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //String array holding string implemented account
        String[] data = {dummy.toString()};

        if (Base.containsAccount(dummy)) {

            generateInterface(data);
        } else {

            StoreView.msgBox("The specified user does not exist.",
            "No Such User", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /**
    * The method advSearchMultiple undertakes the multiple user search based on
    * the filled field from the user
    ***/

    public void advSearchMultiple() {

        //Retrieving the filled field
        String letter = view.details.get(7).getText().toUpperCase();

        //Testing whether field was filled or not
        if (letter.equals("")) {

            StoreView.msgBox("Please fill out the required field.",
            "No Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //String array holding desired implemented accounts
        String[] data = Base.getAccountsLetter(letter);

        if (data.length != 0) {

            generateInterface(data);
        } else {

            StoreView.msgBox(
            "There are no users whose last name match given letter.",
            "No Such Users", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /**
    * The method addProduct generates the dialog for adding products
    ***/

    public void addProduct() {

        //Account issuing the action must have manager rights
        if (view.accountOperation.isManager()) {

            view.addProductDialog();
        } else {

            StoreView.msgBox("Action allowed only for manager-type accounts.",
            "Account Rights", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
    * The method removeProduct removes the selected product from the graphical
    * list and from the temporary database
    ***/

    public void removeProduct() {

        try {

            //Acquiring string array of selected products
            String[] productsList =
            new String[view.listProducts.getSelectedValuesList().size()];
            view.listProducts.getSelectedValuesList().toArray(productsList);

            //At least one product needs to be selected
            if (productsList.length == 0) {

                StoreView.msgBox("Please select a product to delete.",
                "No Product Selected", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Acquiring products list model to allow removal of products
            model = (DefaultListModel<String>) view.listProducts.getModel();
            int[] selectedIndices = view.listProducts.getSelectedIndices();

            //Product removed from graphical interface
            for (int i = selectedIndices.length - 1; i >= 0; i--) {

                if (view.accountOperation.isManager()) {

                    model.remove(selectedIndices[i]);
                }
            }

            //Product removed from temporary database
            for (String product : productsList) {

                view.accountOperation.removeProduct(
                Base.productFromString(product));
            }
        } catch(ConcurrentModificationException e) {
            //Do nothing
        }
    }

    /**
    * The method okProduct adds to the list of available products the newly
    * defined product in the graphical list and in the temporary database
    ***/

    public void okProduct() {

        try {

            //Acquiring products list model
            model = (DefaultListModel<String>) view.listProducts.getModel();

            if (getRadioButtonText(view.group).equals("Food")) {

                //Food product properties
                String name = view.details.get(0).getText();
                String color = view.details.get(1).getText();
                int weight = Integer.parseInt(view.details.get(2).getText());

                //Fields must be filled
                if (name.equals("") || color.equals("")) {

                    StoreView.msgBox("Please enter valid inputs.",
                    "Invalid Inputs", JOptionPane.ERROR_MESSAGE);
                }

                //Element added to graphical list and temporary database
                if (!(Base.containsProduct(view.accountOperation.getLastName()
                + "_" + name + "_" + color + "_" + weight + "_" + "Food"))) {

                    model.addElement((new Food(view.accountOperation.
                    getLastName(), name, color, weight)).toString());
                } else {

                    StoreView.msgBox("This product has already been enlisted under this manager.",
                    "Product Already Available", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (getRadioButtonText(view.group).equals("Furniture")) {

                //Furniture product properties
                String type = view.details.get(3).getText();
                int price = Integer.parseInt(view.details.get(4).getText());
                int height = Integer.parseInt(view.details.get(5).getText());

                //Fields must be filled
                if (type.equals("")) {

                    StoreView.msgBox("Please enter valid inputs.",
                    "Invalid Inputs", JOptionPane.ERROR_MESSAGE);
                }

                //Element added to graphical list and temporary database


                if (!(Base.containsProduct(view.accountOperation.getLastName()
                + "_" + type + "_" + price + "_" + height + "_"
                + "Furniture"))) {

                    model.addElement((new Furniture(view.accountOperation.
                    getLastName(), type, price, height)).toString());
                } else {

                    StoreView.msgBox("This product has already been enlisted under this manager.",
                    "Product Already Available", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            cancel();
        } catch(NumberFormatException e) {

            StoreView.msgBox("Please enter valid inputs.",
            "Invalid Inputs", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException e) {

            StoreView.msgBox("Please select a product type.",
            "No selection", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
    * The method addFave generates the frame of available products from which
    * the selected account can add favorite products
    ***/

    public void addFave() {

        //Retrieving the account's paired list of favorite products
        UserFavProducts fave = Base.getAccountFave(view.accountOperation);
        view.makeAvToFavFrame(fave);
    }

    /**
    * The method removeFave undertakes the action of removing a product from
    * the account's favorite products list from the graphical list and from the
    * temporary database
    ***/

    public void removeFave() {

        try {

            //Acquiring list model in string array format of selected products
            String[] faveList =
            new String[view.listFavorite.getSelectedValuesList().size()];
            view.listFavorite.getSelectedValuesList().toArray(faveList);

            //At least one product must be selected
            if (faveList.length == 0) {

                StoreView.msgBox("Please select a product to delete.",
                "No Product Selected", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Retrieving account's paired favorite products list
            UserFavProducts accountFave =
            Base.getAccountFave(view.accountOperation);

            //Products are removed from the temporary database
            for (String fave : faveList) {

                accountFave.removeFavorite(Base.productFromString(fave));
            }

            //Acquiring list model in string array format of favorite products
            model = (DefaultListModel<String>) view.listFavorite.getModel();
            int[] selectedIndices = view.listFavorite.getSelectedIndices();

            //Products are removed from the graphical list
            for (int i = selectedIndices.length - 1; i >= 0; i--) {

                model.remove(selectedIndices[i]);
            }
        } catch(ConcurrentModificationException e) {
            //Do nothing
        }
    }

    /**
    * The method addAvtoFav transfers from the list of available products the
    * selected product to the list of favorite products of the concerned
    * account
    ***/

    public void addAvtoFav() {

        try {

            //Acquiring list model in string array format of selected products
            String[] avList =
            new String[view.listProducts.getSelectedValuesList().size()];
            view.listProducts.getSelectedValuesList().toArray(avList);

            //At least one product must be selected
            if (avList.length == 0) {

                StoreView.msgBox("Please select a product to add.",
                "No Product Selected", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Retrieving the account's paired list of favorite products
            UserFavProducts fave = Base.getAccountFave(view.accountOperation);

            //Products added to account's list
            for (String f : avList) {

                fave.addFavorite(Base.productFromString(f));
            }

            //Acquiring list models of available products and account's
            //favorite product list
            DefaultListModel<String> modelFav =
            (DefaultListModel<String>) view.listFavorite.getModel();

            model = (DefaultListModel<String>) view.listProducts.getModel();
            int[] selectedIndices = view.listProducts.getSelectedIndices();

            //Products are transferred from one list to the other
            for (int i = selectedIndices.length - 1; i >= 0; i--) {

                model.remove(selectedIndices[i]);
                modelFav.addElement(avList[i]);
            }
        } catch(ConcurrentModificationException e) {
            //Do nothing
        }
    }

    /**
    * The method cancel closes the dialog from which the caller button is
    * located
    ***/

    public void cancel() {

        view.dialog.dispose();
    }
}