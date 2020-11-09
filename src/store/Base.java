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
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    //The products array list holds the available products decided by managers
    private static ArrayList<Product> products = new ArrayList<Product>();

    private static ArrayList<UserFavProducts> userFav = new ArrayList<UserFavProducts>();

    //The emailMapping hashmap keeps track of the number of instances for which
        //users with the same first and last name have been recorded
    private static HashMap<String, Integer> emailMapping = new HashMap <String,
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
    * The method addAccountFav pairs a user with his list of favorite products
    *
    * @param u The user paired with his list of products
    **/

    public static void addAccountFav(UserFavProducts u) {

        userFav.add(u);
    }

    /*
    * The method deleteAccount deletes a user from the accounts list
    *
    * @param a Account attached to some user
    **/

    public static void deleteAccount(Account a) {

        accounts.remove(a);
    }

    public static boolean containsAccount(Account a) {

        boolean sameAccount = false;

        for (Account e : accounts) {
            if (e.toString().equals(a.toString())) {
                sameAccount = true;
                break;
            }
        }

        return sameAccount;
    }

    public static ArrayList<Product> getProducts() {

        return products;
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
    * The method containsProduct checks for a product's presence from the
    * products list and returns the product
    *
    * @param p String implemention of product
    **/

    public static Product containsProduct(String p) {

        for (Product e : products) {
            if (e.toString().equals(p)) {
                return e;
            }
        }

        return null;
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

    /*
    * The method userFromEmail determines the identity of a user based on their
    * known email
    *
    * @param email String representing the user's email
    **/

    public static Account userFromEmail(String email) {

        for (Account a : accounts) {

            if (a.getEmail().equals(email)) {
                return a;
            }
        }
        return null;
    }

    /*
    * The method getAccountsLetter retrieves the different accounts that start
    * with a given letter in their string implementation
    *
    * @param l String consisting of a single character
    * @return matchAccounts Array List of accounts that match the given String
    **/

    public static String[] getAccountsLetter(String l) {

        String[] data = new String[accounts.size()];
        int i = 0;

        for (Account a : accounts) {

            if (a.getLastName().substring(0,1).equals(l)) {

                data[i++] = a.toString();
            }
        }

        return data;
    }
}