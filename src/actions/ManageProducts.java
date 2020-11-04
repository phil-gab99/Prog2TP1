package actions;

import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The interface ManageProducts offers the necessary methods for managing the
* store's available inventory
**/

public interface ManageProducts {

    //Consider changing them to default if has simple enough behaviour
    void addProduct(Product p);
    void removeProduct(Product p);
}