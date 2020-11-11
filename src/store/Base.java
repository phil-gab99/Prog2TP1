package store;

import java.util.ArrayList;
import java.util.HashMap;
import inventory.Product;

/**
* @author Philippe Gabriel
* @version 1.20.14 2020-11-12
*
* The class Base is responsible for holding information with regards to the
* different accounts created or products enlisted as well as providing some
* useful generic methods to manage the data. It acts as a temporary database
* while the application is open.
***/

public class Base {

    //ArrayList holding all the created accounts
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    //ArrayList holding all the enlisted products
    private static ArrayList<Product> products = new ArrayList<Product>();

    //ArrayList holding every account paired with its favorite products list
    private static ArrayList<UserFavProducts> userFav =
    new ArrayList<UserFavProducts>();

    //HashMap holding the number of instances a same last name and first name
    //have occured while accounts were created
    private static HashMap<String, Integer> emailMapping =
    new HashMap <String, Integer>();

    /**
    * The method emailExist checks for whether an email for a given account
    * exists and updates the hashmap responsible for mapping the emails
    *
    * @param lastName String representing the user's last name
    * @param firstName String representing the user's last name
    * @return Integer indicating how many times an account with the given last
    * and first name exists within the temporary database
    ***/

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

    /**
    * The method addAccount adds any newly created accounts to the list of
    * accounts
    *
    * @param a Account to be added
    ***/

    public static void addAccount(Account a) {

        accounts.add(a);
    }

    /**
    * The method deleteAccount deletes an account from the list of accounts
    *
    * @param a Account to be deleted
    ***/

    public static void deleteAccount(Account a) {

        accounts.remove(a);
    }

    /**
    * The method containsAccount checks whether a given account already exists
    * within the database or not
    *
    * @param a Dummy Account created for the sole purpose of comparison
    * @return sameAccount Boolean indicating whether the account exists or not
    ***/

    public static boolean containsAccount(Account a) {

        boolean sameAccount = false;

        //The list implementation of the accounts is compared
        for (Account e : accounts) {

            if (e.toString().equals(a.toString())) {
                
                sameAccount = true;
                break;
            }
        }

        return sameAccount;
    }

    /**
    * The method userFromEmail determines the identity of a user based on their
    * known email since every email is unique to a user
    *
    * @param email String representing the user's email
    ***/

    public static Account userFromEmail(String email) {

        for (Account a : accounts) {

            if (a.getEmail().equals(email)) {

                return a;
            }
        }

        return null;
    }

    /**
    * The method getAccountsLetter retrieves the different accounts that start
    * with a given letter in their string implementation
    *
    * @param l String consisting of a single character
    * @return data String array of accounts that match the given String
    ***/

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

    /**
    * The method addProduct enlists a new product to the products list
    *
    * @param p Product to add
    ***/

    public static void addProduct(Product p) {

        products.add(p);
    }

    /**
    * The method removeProduct removes a product from the products list
    *
    * @param p Product to remove
    ***/

    public static void removeProduct(Product p) {

        products.remove(p);
    }

    /**
    * The method containsProduct checks if a given product is present within
    * the list or not
    *
    * @param product String implementation of product of interest
    * @return sameProduct Boolean indicating if product is available or not
    ***/

    public static boolean containsProduct(String product) {

        boolean sameProduct = false;

        for (Product p : products) {

            if (p.toString().equalsIgnoreCase(product)) {

                sameProduct = true;
                break;
            }
        }

        return sameProduct;
    }

    /**
    * The method productFromString checks for a product's presence from the
    * products list and returns the product
    *
    * @param product String implemention of product of interest
    * @return p Product of interest or null if the product is not present
    ***/

    public static Product productFromString(String product) {

        for (Product p : products) {

            if (p.toString().equalsIgnoreCase(product)) {

                return p;
            }
        }

        return null;
    }

    /**
    * The getter method getProducts grants access to every enlisted product in
    * a present session of the application
    *
    * @return products ArrayList of all enlisted products
    ***/

    public static ArrayList<Product> getProducts() {

        return products;
    }

    /**
    * The method addUserFav adds every created account paired with his list of
    * favorite products
    *
    * @param u The paired account paired
    ***/

    public static void addUserFav(UserFavProducts u) {

        userFav.add(u);
    }

    /**
    * The method getAccountFave finds the paired list of favorite products for
    * a given account
    *
    * @param a Account of interest
    * @return fave UserFavProducts indicating the account and list pair of
    * interest
    ***/

    public static UserFavProducts getAccountFave(Account a) {

        for (UserFavProducts fave : userFav) {

            if (fave.getUser() == a) {
                return fave;
            }
        }

        return null;
    }

    /**
    * The method getFavProducts grants access to the given user's favorite
    * product if present within the temporary database
    *
    * @param a Account of interest
    * @return Array List of the account's favorite products
    ***/

    public static ArrayList<Product> getFavProducts(Account a) {

        for (UserFavProducts e : userFav) {

            if (e.getUser() == a) {
                return e.getFavorites();
            }
        }

        return null;
    }
}