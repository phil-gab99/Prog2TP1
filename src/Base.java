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

    private ArrayList<Account> accounts;
    private HashMap<String, Integer> emailMapping;

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
    **/

    public static int emailExist(String lastName, String firstName) {

        if (emailMapping.containsKey(lastName + firstName)) {

            emailMapping.replace(lastName + firstName, emailMapping.get(lastName + firstName) + 1);
            return emailMapping.get(lastName + firstName)
        } else {

            emailMapping.put(lastName + firstName, 1);
            return 1;
        }
    }
}