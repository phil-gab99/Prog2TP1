package store;

import java.util.ArrayList;
import inventory.*;
import actions.*;

public class UserFavProducts implements FavoriteProducts {

    private Account user;
    private ArrayList<Product> favorites;

    public UserFavProducts(Account user) {

        this.user = user;
        this.favorites = new ArrayList<Product>();

        Base.addUserFav(this);
    }

    public Account getUser() {
        return user;
    }

    public ArrayList<Product> getFavorites() {
        return favorites;
    }

    public boolean hasFave(Product p) {

        return favorites.contains(p);
    }

    public void addFavorite(Product p) {
        favorites.add(p);
    }

    public void removeFavorite(Product p) {
        favorites.remove(p);
    }
}