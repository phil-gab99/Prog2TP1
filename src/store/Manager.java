package store;

/**
* @author Philippe Gabriel
* @version 1.2.6 2020-11-12
*
* The class Manager gives a definition of manager-type accounts
***/

public class Manager extends Account {

    /**
    * The constructor method Manager serves to create a manager-type account
    *
    * @param lastName String indicating manager's last name
    * @param firstName String indicating manager's first name
    * @param birth String indicating manager's date of birth
    ***/

    public Manager(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth);
    }

    /**
    * This constructor method Manager serves to create a copy of an already
    * existing manager-type account in order to lead some comparisons
    *
    * @param lastName String indicating manager's last name
    * @param firstName String indicating manager's first name
    * @param birth String indicating manager's date of birth
    * @param email String indicating manager's email
    * @param balance Integer indicating manager's current balance
    ***/

    public Manager(String lastName, String firstName, String birth,
        String email, int balance) {

        super(lastName, firstName, birth, email, balance);
    }
}