package mvc;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import store.*;

public class StoreView extends JFrame {

    private JList<String> list;

    public StoreView() {

        setLayout(new FlowLayout());

        String[] data = new String[Base.accounts.size()];

        for (int i = 0; i < data.length; i++) {

            data[i] = Base.accounts.get(i).toString();
        }

        list = new JList<String>(data);

        add(list);
    }

    public static void main(String[] args) {

        Client c1 = new Client("Phil", "Dish", "12345");
        Client c2 = new Client("Phil", "Dish", "123456");
        Manager m1 = new Manager("Phil", "Dish", "123456");

        StoreView gui = new StoreView();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1024,768);
        gui.setVisible(true);
        gui.setTitle("My first Java list");
    }
}