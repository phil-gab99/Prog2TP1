package mvc;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;
import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.25.11 2020-11-12
*
* The class StoreModel gives the details of the actions to be ensued upon
* triggering action events
**/

class StoreModel {

    private StoreView view;

    public StoreModel(StoreView view) {

        this.view = view;
    }

    public void addAccount() {

        //Need to add full implementation of account adding (dialogbox)
        Client c1 = new Client("Ayoub", "Souleiman", "01/02/1999");
        Client c2 = new Client("Ayoub", "Souleiman", "01/02/1999");
        Client c3 = new Client("Ayoub", "Souleiman", "01/02/1999");
        DefaultListModel<String> model = (DefaultListModel<String>) view.list.getModel();

        model.add(0,c1.toString());
        model.add(1,c2.toString());
        model.add(2,c3.toString());
    }

    public void deleteAccount() {

        try {

            String[] users = new String[view.list.getSelectedValuesList().size()];
            view.list.getSelectedValuesList().toArray(users);

            if (users.length == 0) {
                System.err.println("Please select a user to delete");
                return;
            }

            DefaultListModel<String> model = (DefaultListModel<String>) view.list.getModel();
            int[] selectedIndices = view.list.getSelectedIndices();

            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                model.remove(i);
            }

            for (String user : users) {

                String userEmail = user.split(" - ")[3];
                Base.deleteAccount(userEmail);
            }
        } catch(ConcurrentModificationException e) {

        }

        // System.out.println(Arrays.toString(Base.accounts.toArray()));
    }
}