package store;

import java.util.ArrayList;
import actions.FavoriteProducts;
import inventory.Product;

/**
* @author Philippe Gabriel
* @version 1.5.3 2020-11-12
*
* The UserFavProducts pairs each created account with a list comprised of their
* favorite products
***/

public class UserFavProducts implements FavoriteProducts {

    private Account user;                 //Account to pair with a list
    private ArrayList<Product> favorites; //Array List of favorite products

    /**
    * The constructor method UserFavProducts pairs each created account with an
    * initially empty list of favorite products
    *
    * @param user Account to pair with a list
    ***/

    public UserFavProducts(Account user) {

        this.user = user;
        this.favorites = new ArrayList<Product>();

        //The created pair is registered in the temporary database
        Base.addUserFav(this);
    }

    /**
    * The getter method getUser grants access to the account of the current
    * instance
    *
    * @return user Account of the current instance
    ***/

    public Account getUser() {

        return user;
    }

    /**
    * The getter method getFavorites grants access to the list of favorite
    * products of the current instance
    *
    * @return favorites Array List of favorite products of the current instance
    ***/

    public ArrayList<Product> getFavorites() {

        return favorites;
    }

    /**
    * The method hasFave checks for whether a given product is present within
    * the associated account's list of favorite products
    *
    * @param p Product for which it is desired to check
    * @return Boolean indicating whether the product is present or not
    ***/

    public boolean hasFave(Product p) {

        return favorites.contains(p);
    }

    /**
    * The method addFavorite adds a product to the associated account's list of
    * favorite products
    *
    * @param p Product that needs to be added
    ***/

    public void addFavorite(Product p) {

        favorites.add(p);
    }

    /**
    * The method removeFavorite removes a product off of the associated
    * account's list of favorite products
    *
    * @param p Product that needs to be removed
    ***/

    public void removeFavorite(Product p) {

        favorites.remove(p);
    }
}