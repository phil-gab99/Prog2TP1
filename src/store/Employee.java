package store;

import actions.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1 2020-11-12
*
* The class Employee
**/

public class Employee extends Account implements AddBalance, DeductBalance {

    public Employee(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth, 1);
    }

    /*
    * The addBalance method was implemented from the AddBalance interface
    **/

    public void addBalance(int amount) {
        this.setBalance(this.getBalance() + amount);
    }

    /*
    * The deductBalance method was implemented from the DeductBalance interface
    **/

    public void deductBalance(int amount) {
        this.setBalance(this.getBalance() - amount);
    }
}