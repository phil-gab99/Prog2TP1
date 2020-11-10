package inventory;

/**
* @author Philippe Gabriel
* @version 1.0.1 2020-11-12
*
* The class Product contains the basic fields common to the various product
* types
***/

public class Product {

    private String manager; //String representing manager's last name

    /**
    * The constructor method Product serves to assign the common existing
    * traits with regards to the different product types
    *
    * @param manager String representing the manager's last name indicating the
    * manager responsible for including a given product in the store's
    * inventory
    ***/

    public Product(String manager) {

        this.manager = manager;
    }

    /**
    * The getter method getManager grants access to the manager who added the
    * current product
    *
    * @return manager String indicating manager
    ***/

    public String getManager() {

        return manager;
    }
}