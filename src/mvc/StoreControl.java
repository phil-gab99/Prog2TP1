package mvc;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
* @author Philippe Gabriel
* @version 1.2.1 2020-11-12
*
* The class StoreControl is responsible for controlling where events triggered
* by the user lead to the various possible actions
***/

class StoreControl {

    //Model granting access to the many actions in response to user events
    private StoreModel model;

    /**
    * The constructor method StoreControl allows the link between the control
    * and model classes for event handling
    *
    * @param model StoreModel granting access to methods triggered by events
    ***/

    public StoreControl(StoreModel model) {

        this.model = model;
    }

    /**
    * The class KeyLetters handles events triggered upon typing a character in
    * a textfield this class listens to and restricts the allowed characters
    ***/

    public class KeyLetters extends KeyAdapter {

        private int textLength; //Integer indicating maximum length of text

        /**
        * The constructor method KeyLetters retrieves the passed maximum length
        * of a text for the parent textfield
        *
        * @param textLength Integer indicating maximum length of text
        ***/

        public KeyLetters(int textLength) {

            this.textLength = textLength;
        }

        /**
        * The method keyTyped is triggered upon typing a key from the textfield
        * the current instance is listening to
        *
        * @param e KeyEvent holding information on the key that was typed
        ***/

        public void keyTyped(KeyEvent e) {

            model.formatLetters(e); //Method restricting text to letters only

            //Method restricting text length according to passed length
            if (textLength > 0) { //If length 0 was passed, length is unlimited

                model.maxColumns(e, textLength);
            }
        }
    }

    /**
    * The class KeyNumbers handles events triggered upon typing a character in
    * a textfield this class listens to and restricts the allowed characters
    ***/

    public class KeyNumbers extends KeyAdapter {

        private int textLength; //Integer indicating maximum length of text

        /**
        * The constructor method KeyNumbers retrieves the passed maximum length
        * of a text for the parent textfield
        *
        * @param textLength Integer indicating maximum length of text
        ***/

        public KeyNumbers(int textLength) {

            this.textLength = textLength;
        }

        /**
        * The method keyTyped is triggered upon typing a key from the textfield
        * the current instance is listening to
        *
        * @param e KeyEvent holding information on the key that was typed
        ***/

        public void keyTyped(KeyEvent e) {

            model.formatNumber(e); //Method restricting text to numbers only

            //Method restricting text length according to passed length
            if (textLength > 0) { //If length 0 was passed, length is unlimited

                model.maxColumns(e, textLength);
            }
        }
    }

    /**
    * The class KeyMixed handles events triggered upon typing a character in
    * a textfield this class listens to and restricts the allowed characters
    ***/

    public class KeyMixed extends KeyAdapter {

        private int textLength; //Integer indicating maximum length of text

        /**
        * The constructor method KeyNumbers retrieves the passed maximum length
        * of a text for the parent textfield
        *
        * @param textLength Integer indicating maximum length of text
        ***/

        public KeyMixed(int textLength) {

            this.textLength = textLength;
        }

        /**
        * The method keyTyped is triggered upon typing a key from the textfield
        * the current instance is listening to
        *
        * @param e KeyEvent holding information on the key that was typed
        ***/

        public void keyTyped(KeyEvent e) {

            //Method restricting text to numbers and letters
            model.formatMixed(e);

            //Method restricting text length according to passed length
            if (textLength > 0) {

                model.maxColumns(e, textLength);
            }
        }
    }

    /**
    * The class ProductFields handles events triggered upon modifying a radio
    * button selection when one wishes to create a new product
    ***/

    public class ProductFields implements ChangeListener {

        /**
        * The method stateChanged is triggered upon modifying the state of the
        * affected radio button group of interest
        *
        * @param e ChangeEvent holding information on tracked radio buttons
        ***/

        public void stateChanged(ChangeEvent e) {

            model.productFields(); //Method controlling fillable fields
        }
    }

    /**
    * The class AddAccount handles the event triggered upon pressing the Add
    * Account button this class listens to
    ***/

    public class AddAccount implements ActionListener {

        /**
        * The method actionPerformed is triggered upon pressing the button
        * the current instance is listening to
        *
        * @param e ActionEvent holding information on the press of the button
        ***/

        public void actionPerformed(ActionEvent e) {

            model.addAccount(); //Method calling dialog to add an account
        }
    }

    /**
    * The class DeleteAccount handles the event triggered upon pressing the
    * Delete Account button this class listens to
    ***/

    public class DeleteAccount implements ActionListener {

        /**
        * The method actionPerformed is triggered upon pressing the button
        * the current instance is listening to
        *
        * @param e ActionEvent holding information on the press of the button
        ***/

        public void actionPerformed(ActionEvent e) {

            model.deleteAccount(); //Method undertaking deletion of account(s)
        }
    }

    /**
    * The class AdvSearch handles the event triggered upon pressing the
    * Advanced Search button this class listens to
    ***/

    public class AdvSearch implements ActionListener {

        /**
        * The method actionPerformed is triggered upon pressing the button
        * the current instance is listening to
        *
        * @param e ActionEvent holding information on the press of the button
        ***/

        public void actionPerformed(ActionEvent e) {

            model.advSearch(); //Method calling dialog for advanced searches
        }
    }

    /**
    * The class AddBalance handles the event triggered upon pressing the Add
    * Balance button this class listens to
    ***/

    public class AddBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.addBalance();
        }
    }

    public class DeductBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.deductBalance();
        }
    }

    public class FavProducts implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.favProducts();
        }
    }

    public class AvProducts implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.avProducts();
        }
    }

    public class OkAccount implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okAccount();
        }
    }

    public class OkAddBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okAddBalance();
        }
    }

    public class OkDeductBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okDeductBalance();
        }
    }

    public class AdvSearchSingle implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.advSearchSingle();
        }
    }

    public class AdvSearchMultiple implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.advSearchMultiple();
        }
    }

    public class AddProduct implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.addProduct();
        }
    }

    public class RemoveProduct implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.removeProduct();
        }
    }

    public class OkProduct implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okProduct();
        }
    }

    public class AddFave implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.addFave();
        }
    }

    public class RemoveFave implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.removeFave();
        }
    }

    public class AddAvtoFav implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.addAvtoFav();
        }
    }

    public class Cancel implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.cancel();
        }
    }
}