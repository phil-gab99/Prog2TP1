import java.util.ArrayList;
import java.util.HashMap;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1 2020-11-12
*
* The class Base
**/

public class Base {

    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static HashMap<String, Integer> emailMapping = new HashMap <String, Integer>();

    /*
    * The method addAccount adds any new user to the array list
    *
    * @param a Account attached to some user
    **/

    public static void addAccount(Account a) {

        accounts.add(a);
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

            emailMapping.replace(lastName + firstName, emailMapping.get(lastName + firstName) + 1);
            return emailMapping.get(lastName + firstName);
        } else {

            emailMapping.put(lastName + firstName, 1);
            return 1;
        }
    }
}