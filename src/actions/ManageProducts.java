package actions;

import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1.0 2020-11-12
*
* The interface ManageProducts offers the necessary methods for managing the
* store's available inventory
**/

public interface ManageProducts {

    /*
    * The methods removeProduct removes a product from the product list
    *
    * @param p Product to be added/removed
    **/

    void addProduct(Product p);
    void removeProduct(Product p);
}