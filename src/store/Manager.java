package store;

import actions.*;
import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.2.10 2020-11-12
*
* The class Manager gives a definition of manager-type accounts
**/

public class Manager extends Account {

    /*
    * The Manager constructor gives the specific details for creating a
    * manager account
    **/

    public Manager(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth);
    }

    public Manager(String lastName, String firstName, String birth,
        String email, int balance) {

        super(lastName, firstName, birth, email, balance);
    }
}