package mvc;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import store.*;

public class StoreView extends JFrame {

    private JList<String> list;

    private JButton addAcount;
    private JButton removeAccount;
    private JButton advancedSearch;
    private JButton favoriteProducts;
    private JButton addBalance;
    private JButton deductBalance;
    private JButton productsList;

    public StoreView() {

        setLayout(new FlowLayout());

        String[] data = new String[Base.accounts.size()];

        // data[0] = "Last Name    First Name    Birth    Email    Balance";

        for (int i = 0; i < data.length; i++) {

            data[i] = Base.accounts.get(i).toString();
        }

        list = new JList<String>(data);
        JScrollPane scrollpane = new JScrollPane(list);
        JLabel header = new JLabel("Last Name | First Name | Date of Birth | Email | Balance", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);
        scrollpane.setPreferredSize(new Dimension(1000, 500));
        add(scrollpane);
    }

    public static void main(String[] args) {

        Client c1 = new Client("Phil", "Dish", "00/00/9999");
        Client c2 = new Client("Phil", "Dish", "30/00/9999");
        Manager m1 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m2 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m3 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m4 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m5 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m6 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m7 = new Manager("Phil", "Dish", "00/02/9999");
        Manager m8 = new Manager("Phil", "Dish", "00/02/9999");

        StoreView gui = new StoreView();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1024,768);
        gui.setVisible(true);
        gui.setTitle("My first Java list");
    }
}