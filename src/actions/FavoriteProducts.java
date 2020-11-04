package actions;

import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0.1 2020-11-12
*
* The interface FavoriteProducts offers the necessary methods for managing a
* user's favorite products' list
**/

public interface FavoriteProducts {

    /*
    * The methods addFavorite and removeFavorite adds or removes a product
    * to the user's favorite product list
    *
    * @param p Product to be added to the user's favorite products list
    **/

    void addFavorite(Product p);
    void removeFavorite(Product p);
}