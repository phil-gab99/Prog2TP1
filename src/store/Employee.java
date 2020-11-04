package store;

import actions.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1 2020-11-12
*
* The class Employee
**/

public class Employee extends Account {

    public Employee(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth, 1);
    }
}