package mvc;
import java.awt.event.*;

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