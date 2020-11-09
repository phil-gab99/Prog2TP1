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

        private int textLength;

        public KeyLetters(int textLength) {

            this.textLength = textLength;
        }

        public void keyTyped(KeyEvent e) {

            model.formatLetters(e);

            if (textLength > 0) {
                model.maxColumns(e, textLength);
            }
        }
    }

    public class KeyNumbers extends KeyAdapter {

        private int textLength;

        public KeyNumbers(int textLength) {

            this.textLength = textLength;
        }

        public void keyTyped(KeyEvent e) {

            model.formatNumber(e);

            if (textLength > 0) {
                model.maxColumns(e, textLength);
            }
        }
    }

    public class KeyMixed extends KeyAdapter {

        private int textLength;

        public KeyMixed(int textLength) {

            this.textLength = textLength;
        }

        public void keyTyped(KeyEvent e) {

            model.formatMixed(e);

            if (textLength > 0) {
                model.maxColumns(e, textLength);
            }
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

    public class AdvSearch implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.advSearch();
        }
    }

    public class AddBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.addBalance();
        }
    }

    public class DeductBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.deductBalance();
        }
    }

    public class OkAccount implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okAccount();
        }
    }

    public class OkAddBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okAddBalance();
        }
    }

    public class OkDeductBalance implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.okDeductBalance();
        }
    }

    public class AdvSearchSingle implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.advSearchSingle();
        }
    }

    public class AdvSearchMultiple implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.advSearchSingle();
        }
    }

    public class Cancel implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.cancel();
        }
    }
}