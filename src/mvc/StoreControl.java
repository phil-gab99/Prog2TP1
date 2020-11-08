package mvc;

import java.awt.event.*;
import javax.swing.*;

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

    public class KeyLetters extends KeyAdapter {

        public void keyTyped(KeyEvent e) {
            model.format(e, 'A', 'z');
        }
    }

    public class KeyNumbers extends KeyAdapter {

        public void keyTyped(KeyEvent e) {
            model.format(e, '0', '9');
        }
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

    public class OkAccount implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okAccount();
        }
    }

    public class Cancel implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.cancel();
        }
    }
}