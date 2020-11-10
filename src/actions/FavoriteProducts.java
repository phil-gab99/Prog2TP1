package actions;

import inventory.Product;

/**
* @author Philippe Gabriel
* @version 1.0.2 2020-11-12
*
* The interface FavoriteProducts offers the necessary methods for managing a
* user's favorite products' list
***/

public interface FavoriteProducts {

    /**
    * The methods addFavorite and removeFavorite adds or removes a product
    * to the user's favorite product list
    *
    * @param p Product to be added/removed
    ***/

    void addFavorite(Product p);
    void removeFavorite(Product p);
}