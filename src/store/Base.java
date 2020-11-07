package store;

import java.util.ArrayList;
import java.util.HashMap;
import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.20.14 2020-11-12
*
* The class Base is responsible for holding information with regards to the
* different accounts created or products enlisted as well as providing some
* useful generic methods to manage the data
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
    * The method deleteAccount deletes any new user based on their given unique
    * email
    *
    * @param email Account's email used to identify desired user
    **/

    public static void deleteAccount(String email) {

        for (Account a : accounts) {

            if (a.getEmail().equals(email)) {
                accounts.remove(a);
                break;
            }
        }
    }

    /*
    * The method addProduct adds a new product to the products list and avoids
    * adding duplicate items in the products list
    *
    * @param p Product to add
    **/

    public static void addProduct(Product p) {

        if (productAvailable(p)) {

            System.out.println("Product already available!");
        } else {

            products.add(p);
        }
    }

    /*
    * The method removeProduct removes a product fromt the products list
    *
    * @param p Product to remove
    **/

    public static void removeProduct(Product p) {

        if (productAvailable(p)) {

            products.remove(p);
        } else {

            System.out.println("No such product enlisted!");
        }
    }

    /*
    * The method productAvailable checks if a given product is present within
    * the list or not
    *
    * @param p Product of interest
    * @return Boolean indicating if product is available or not
    **/

    public static boolean productAvailable(Product p) {

        return products.contains(p);
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

        String user = lastName + firstName;

        if (emailMapping.containsKey(user)) {

            emailMapping.replace(user, emailMapping.get(user) + 1);
            return emailMapping.get(user);
        } else {

            emailMapping.put(user, 1);
            return 1;
        }
    }
}