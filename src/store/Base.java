package store;

import java.util.ArrayList;
import java.util.HashMap;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.3.5 2020-11-12
*
* The class Base
**/

public class Base {

    //The accounts array list holds all the different users' information
    public static ArrayList<Account> accounts = new ArrayList<Account>();

    //The products array list holds the available products decided by managers
    public static ArrayList<Product> products = new ArrayList<Product>();

    //The emailMapping hashmap keeps track of the number of instances for which
        //users with the same first and last name have been recorded
    public static HashMap<String, Integer> emailMapping = new HashMap <String,
        Integer>();

    /*
    * The method addAccount adds any new user to the accounts list
    *
    * @param a Account attached to some user
    **/

    public static void addAccount(Account a) {

        accounts.add(a);
    }

    /*
    * The method addProduct adds a new product to the products list
    *
    * @param p Product to add
    **/

    public static void addProduct(Product p) {
        System.out.println("Work in progress");
    }

    /*
    * The method removeProduct removes a product fromt the products list
    *
    * @param p Product to remove
    **/

    public static void removeProduct(Product p) {
        System.out.println("Work in progress");
    }

    /*
    * The method emailExist checks for whether an email for a given user exists
    * and updates the hashmap responsible for mapping the emails
    *
    * @param lastName String representing the user's last name
    * @param firstName String representing the user's last name
    * @return digits Integer indicating the instance number on how many times
    * a user with the given last and first name exists
    **/

    public static int emailExist(String lastName, String firstName) {

        if (emailMapping.containsKey(lastName + firstName)) {

            emailMapping.replace(lastName + firstName, emailMapping.get(
                lastName + firstName) + 1);
            return emailMapping.get(lastName + firstName);
        } else {

            emailMapping.put(lastName + firstName, 1);
            return 1;
        }
    }
}