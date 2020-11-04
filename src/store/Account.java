package store;

import java.util.ArrayList;
import actions.*;
import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.11.11 2020-11-12
*
* The class Account contains the basic fields and methods common to the various
* account types as well as useful accessor methods
**/

//todo : Give program specification
//todo : Begin

public abstract class Account implements ManageBalance, FavoriteProducts,
    ManageProducts {

    private int balance;  //Balance associated with the account
    private String email; //Email to be generated for the different accounts

    private String lastName;
    private String firstName;
    private String birth;
    private ArrayList<Product> favorites;

    /*
    * The Account constructor serves to assign the common existing traits
    * with regards to the different account types
    *
    * @param lastName String indicating individual's last name
    * @param firstName String indicating individual's first name
    * @param birth String indicating individual's date of birth following the
    * format: dd/mm/yyyy
    **/

    public Account(String lastName, String firstName, String birth) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.favorites = new ArrayList<Product>();

        this.email = generateEmail();

        Base.addAccount(this);
    }

    /*
    * The generateEmail method creates an email associated with the
    * corresponding account. This method ensures that no duplicate emails are
    * generated and follows a general format of : lastNamefirstName@magasin.ca
    *
    * @return validEmail String representing the email associated with a user
    **/

    public String generateEmail() {

        int count = Base.emailExist(lastName, firstName);

        return lastName + firstName + count + "@magasin.ca";
    }

    /*
    * The getter method getBalance gives access to a user's balance
    *
    * @return balance The user's balance
    **/

    public int getBalance() {
        return balance;
    }

    /*
    * The getter method getEmail gives access to a user's email
    *
    * @return email The user's email
    **/

    public String getEmail() {
        return email;
    }

    /*
    * The getter method getLastName gives access to a user's last name
    *
    * @return lastName The user's last name
    **/

    public String getLastName() {
        return lastName;
    }

    /*
    * The getter method getLastName gives access to a user's first name
    *
    * @return firstName The user's first name
    **/

    public String getFirstName() {
        return firstName;
    }

    /*
    * The addBalance method was implemented from the ManageBalance interface
    * and is an available action for all account types
    **/

    public void addBalance(int amount) {

        balance += amount;
    }

    /*
    * The deductBalance method was implemented from the ManageBalance interface
    * and is not an available action for Client-type accounts
    **/

    public void deductBalance(int amount) {

        if (this instanceof Client) {

            System.out.println("Action not allowed for client-type accounts");
        } else {

            balance -= amount;
        }
    }

    /*
    * The addFavorite method was implemented from the FavoriteProducts
    * interface and is an available action for all account types
    **/

    public void addFavorite(Product p) {
        /*
        if (productAvailable(p)) {
            favorites.add(p);
        }
        */

    }

    /*
    * The removeFavorite method was implemented from the FavoriteProducts
    * interface and is an available action for all account types
    **/

    public void removeFavorite(Product p) {

        favorites.remove(p);
    }

    /*
    * The addProduct method was implemented from the ManageProducts interface
    * and is an available action for manager-type accounts
    **/

    public void addProduct(Product p) {

        if (this instanceof Manager) {
            System.out.println("Work in progress");
        } else {

            System.out.println("Action allowed only for manager-type accounts");
        }
    }

    /*
    * The removeProduct method was implemented from the ManageProducts
    * interface and is an available action for manager-type accounts
    **/

    public void removeProduct(Product p) {

        if (this instanceof Manager) {
            System.out.println("Work in progress");
        } else {

            System.out.println("Action allowed only for manager-type accounts");
        }
    }
}