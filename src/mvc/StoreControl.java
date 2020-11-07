package mvc;
import java.awt.event.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.2.1 2020-11-12
*
* The class StoreControl is responsible for generating the events upon having
* a source object trigger its assigned listener
**/

class StoreControl {

    private StoreModel model;

    public StoreControl(StoreModel model) {

        this.model = model;
    }

    public class AddAccount implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.addAccount();
        }
    }

    public class DeleteAccount implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.deleteAccount();
        }
    }
}