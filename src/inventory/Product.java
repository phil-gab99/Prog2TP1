package inventory;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0.1 2020-11-12
*
* The class Product contains the basic fields common to the various product
* types
**/

public class Product {

    private String manager;

    /*
    * The Product constructor serves to assign the common existing traits
    * with regards to the different product types
    *
    * @param manager String representing the manager's first name
    * and last name indicating the manager responsible for including a
    * given product in the store inventory.
    **/

    public Product(String manager) {

        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public String toString() {
        return "Le directeur est : " + manager;
    }
}