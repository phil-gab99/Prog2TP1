package store;

/**
* @author Philippe Gabriel
* @version 1.2.6 2020-11-12
*
* The class Client gives a definition of client-type accounts
***/

public class Client extends Account {

    /**
    * The constructor method Client serves to create a client-type account
    *
    * @param lastName String indicating client's last name
    * @param firstName String indicating client's first name
    * @param birth String indicating client's date of birth
    ***/

    public Client(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth);
    }

    /**
    * This constructor method Client serves to create a copy of an already
    * existing client-type account in order to lead some comparisons
    *
    * @param lastName String indicating client's last name
    * @param firstName String indicating client's first name
    * @param birth String indicating client's date of birth
    * @param email String indicating client's email
    * @param balance Integer indicating client's current balance
    ***/

    public Client(String lastName, String firstName, String birth,
        String email, int balance) {

        super(lastName, firstName, birth, email, balance);
    }
}