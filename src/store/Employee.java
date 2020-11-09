package store;

import actions.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.2.6 2020-11-12
*
* The class Employee gives a definition of employee-type accounts
**/

public class Employee extends Account {

    /*
    * The Employee constructor gives the specific details for creating an
    * employee account
    **/

    public Employee(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth);
    }

    public Employee(String lastName, String firstName, String birth,
        String email, int balance) {

        super(lastName, firstName, birth, email, balance);
    }
}