package store;

import java.util.ArrayList;
import inventory.*;

public class UserFavProducts {

    private Account user;
    private ArrayList<Product> favorites;

    public UserFavProducts(Account user) {

        this.user = user;
        this.favorites = new ArrayList<Product>();

        Base.addAccountFav(this);
    }

    public void getUser() {
        user.toString();
    }

    public ArrayList<Product> getFavorites() {
        return favorites;
    }
}