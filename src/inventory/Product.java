package inventory;

import store.Manager;

/**
* @author Philippe Gabriel
* @version 1.0.1 2020-11-12
*
* The class Product contains the basic fields common to the various product
* types
***/

public class Product {

    private Manager manager; //Manager who added this product

    /**
    * The constructor method Product serves to assign the common existing
    * traits with regards to the different product types
    *
    * @param manager Manager responsible for adding the product
    ***/

    public Product(Manager manager) {

        this.manager = manager;
    }

    public Manager getManager() {

        return manager;
    }

    /**
    * The getter method getManager grants access to the manager who added the
    * current product
    *
    * @return manager String indicating manager
    ***/

    public String getManagerLast() {

        return manager.getLastName();
    }
}