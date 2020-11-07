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

            if (users.length == 0) {
                System.err.println("Please select a user to delete");
                return;
            }

            for (String user : users) {

                String userEmail = user.split(" - ")[3];
                Base.deleteAccount(userEmail);
            }
        } catch(ConcurrentModificationException e) {
            System.out.println("Exception caught");
        }

        System.out.println(Arrays.toString(Base.accounts.toArray()));
    }
}