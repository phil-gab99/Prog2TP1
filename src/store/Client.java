package store;

import actions.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.2.4 2020-11-12
*
* The class Client gives a definition of client-type accounts
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