package mvc;

import java.util.Arrays;
import java.util.List;
import java.util.ConcurrentModificationException;
import store.*;

class StoreModel {

    private StoreView view;

    public StoreModel(StoreView view) {

        this.view = view;
    }

    public void addAccount() {
        System.out.println("Work in progress");
    }

    public void deleteAccount() {

        try {

            String[] users = new String[view.list.getSelectedValuesList().size()];
            view.list.getSelectedValuesList().toArray(users);

            for (String user : users) {
                String userEmail = user.split(" - ")[3];
                System.out.println(Arrays.toString(Base.accounts.toArray()));
                Base.deleteAccount(userEmail);
                System.out.println(Arrays.toString(Base.accounts.toArray()));
            }
        } catch(NullPointerException e) {
            System.err.println("Please select a user to delete");
        } catch(ConcurrentModificationException e) {

        }

        // System.out.println(Arrays.toString(Base.accounts.toArray()));
    }
}