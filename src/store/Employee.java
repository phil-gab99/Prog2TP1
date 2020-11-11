package store;

/**
* @author Philippe Gabriel
* @version 1.2.6 2020-11-12
*
* The class Employee gives a definition of employee-type accounts
***/

public class Employee extends Account {

    /**
    * The constructor method Employee serves to create an employee-type account
    *
    * @param lastName String indicating employee's last name
    * @param firstName String indicating employee's first name
    * @param birth String indicating employee's date of birth
    ***/

    public Employee(String lastName, String firstName, String birth) {
        
        super(lastName, firstName, birth);
    }

    /**
    * This constructor method Employee serves to create a copy of an already
    * existing employee-type account in order to lead some comparisons
    *
    * @param lastName String indicating employee's last name
    * @param firstName String indicating employee's first name
    * @param birth String indicating employee's date of birth
    * @param email String indicating employee's email
    * @param balance Integer indicating employee's current balance
    ***/

    public Employee(String lastName, String firstName, String birth,
        String email, int balance) {

        super(lastName, firstName, birth, email, balance);
    }
}