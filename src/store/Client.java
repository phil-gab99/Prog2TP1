package store;

import actions.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.2.2 2020-11-12
*
* The class Client
**/

public class Client extends Account {

    /*
    * The Client constructor gives the specific details for creating a client
    * account
    **/

    public Client(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth, 0);
    }
}