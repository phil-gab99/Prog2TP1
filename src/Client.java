/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The class Client
**/

public class Client extends Account implements AddBalance {

    public Client(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth, 0);
    }
}