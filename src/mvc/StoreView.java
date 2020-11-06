package mvc;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import store.*;

public class StoreView extends JFrame {

    private static final int FRAME_WIDTH = 1440;
    private static final int FRAME_HEIGHT = 900;

    private JList<String> list;

    private JButton addAccount;
    private JButton removeAccount;
    private JButton advancedSearch;
    private JButton favoriteProducts;
    private JButton addBalance;
    private JButton deductBalance;
    private JButton productsList;

    public StoreView() {

        setLayout(new FlowLayout());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        String[] data = new String[Base.accounts.size()];

        for (int i = 0; i < data.length; i++) {

            data[i] = Base.accounts.get(i).toString();
        }

        list = new JList<String>(data);
        JScrollPane scrollpane = new JScrollPane(list);
        JLabel header = new JLabel("Last Name  |  First Name  |  Date of Birth"
        + "  |  Email  |  Balance  |  Position", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);
        scrollpane.setPreferredSize(new Dimension(getWidth() - 100, getHeight() - 200));
        add(scrollpane);

        addAccount = new JButton("Add an account");
        removeAccount = new JButton("Remove account");
        advancedSearch = new JButton("Advanced Search");
        favoriteProducts = new JButton("Favorite Products");
        addBalance = new JButton("Add to Balance");
        deductBalance = new JButton("Deduct from Balance");
        productsList = new JButton("List of available products");

        add(addAccount);
        add(removeAccount);
        add(advancedSearch);
        add(favoriteProducts);
        add(addBalance);
        add(deductBalance);
        add(productsList);
    }

    public static void main(String[] args) {

        StoreView gui = new StoreView();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setTitle("My first Java list");
    }
}