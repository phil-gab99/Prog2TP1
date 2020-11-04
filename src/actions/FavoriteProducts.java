package actions;

import inventory.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The interface FavoriteProducts
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