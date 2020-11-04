package store;

import actions.*;
import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1 2020-11-12
*
* The class Manager
**/

public class Manager extends Account {

    public Manager(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth, 2);
    }
}