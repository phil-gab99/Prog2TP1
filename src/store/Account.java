package store;

import javax.swing.*;
import inventory.Product;
import mvc.StoreView;

/**
* @author Philippe Gabriel
* @version 1.11.11 2020-11-12
*
* The class Account contains the basic fields and methods common to the various
* account types as well as useful accessor methods
***/

public abstract class Account {

    private String lastName;  //String indicating individual's last name
    private String firstName; //String indicating individual's first name
    private String birth;     //String indicating individual's date of birth
    private String email;     //String indicating individual's email
    private int balance;      //Integer indicating individual's balance

    /**
    * The constructor method Account serves to assign the common existing
    * traits with regards to the different account types
    *
    * @param lastName String indicating the individual's last name
    * @param firstName String indicating the individual's first name
    * @param birth String indicating the individual's date of birth following
    * the format: dd/mm/yyyy
    ***/

    public Account(String lastName, String firstName, String birth) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.email = generateEmail();

        //The created account is registered in the temporary database
        Base.addAccount(this);

        //A list of favorite products is paired with this account
        new UserFavProducts(this);
    }

    /**
    * This constructor method Account serves to create a copy of an already
    * existing account in order to lead some comparisons
    *
    * @param lastName String indicating the individual's last name
    * @param firstName String indicating the individual's first name
    * @param birth String indicating the individual's date of birth following
    * the format: dd/mm/yyyy
    * @param email String indicating the individual's email
    * @param balance Integer indicating the individual's balance
    ***/

    public Account(String lastName, String firstName, String birth,
    String email, int balance) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.email = email;
        this.balance = balance;
    }

    /**
    * The method generateEmail creates an email associated with the
    * corresponding account. This method ensures that no duplicate emails are
    * generated and follows a general format of : lastNamefirstName@magasin.ca
    *
    * @return validEmail String representing the email associated with a user
    ***/

    public String generateEmail() {

        //This acquired count will serve to distiguish emails if users with
        //similar last and first names have been registered
        int count = Base.emailExist(lastName, firstName);

        String validEmail = lastName + firstName + count + "@magasin.ca";

        return validEmail;
    }

    /**
    * The getter method getLastName grants access to the account's last name
    *
    * @return lastName The account's last name
    ***/

    public String getLastName() {

        return lastName;
    }

    /**
    * The getter method getLastName grants access to the account's first name
    *
    * @return firstName The account's first name
    ***/

    public String getFirstName() {

        return firstName;
    }

    /**
    * The getter method getBirth grants access to the account's date of birth
    *
    * @return birth The account's date of birth
    ***/

    public String getBirth() {

        return birth;
    }

    /**
    * The getter method getEmail grants access to the account's email
    *
    * @return email The account's email
    ***/

    public String getEmail() {

        return email;
    }

    /**
    * The getter method getBalance grants access to the account's balance
    *
    * @return balance The account's balance
    ***/

    public int getBalance() {

        return balance;
    }

    /**
    * The method toString converts the account's information into its String
    * implementation that will be displayed to the user
    *
    * @return String representing the String implementation
    ***/

    public String toString() {

        return lastName + "_" + firstName + "_" + birth + "_" + email +
        "_" + balance + "_" + getClass().getSimpleName();
    }

    /**
    * The method addBalance adds a given amount to the account's balance
    *
    * @param amount Integer to be added to the balance
    ***/

    public void addBalance(int amount) {

        balance += amount;
    }

    /**
    * The method deductBalance deducts a given amount fromt the account's
    * balance
    *
    * @param amount Integer to be deducted from the balance
    ***/

    public void deductBalance(int amount) {

        if (isClient()) {

            StoreView.msgBox("Action not allowed for client-type accounts.",
            "Account Rights", JOptionPane.ERROR_MESSAGE);
        } else {

            balance -= amount;
        }
    }

    /**
    * The method removeProduct checks whether the action was undertaken from a
    * valid account before initiating the change in the temporary database
    *
    * @param p Product requested to be removed from the temporary database
    ***/

    public void removeProduct(Product p) {

        if (isManager()) {

            Base.removeProduct(p);
        } else {

            StoreView.msgBox("Action allowed only for manager-type accounts.",
            "Account Rights", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
    * The method isClient checks for whether the current account is a
    * client-type account
    *
    * @return Boolean indicating whether the account is client-type or not
    ***/

    public boolean isClient() {

        return this instanceof Client;
    }

    /**
    * The method isManager checks for whether the current account is a
    * manager-type account
    *
    * @return Boolean indicating whether the account is manager-type or not
    ***/

    public boolean isManager() {

        return this instanceof Manager;
    }
}