package mvc;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.15.2 2020-11-12
*
* The class StoreView indicates how the first main window of the application is
* configured
**/

public class StoreView extends JFrame {

    private static final int FRAME_WIDTH = 800; //Default frame width
    private static final int FRAME_HEIGHT = 450; //Default frame height

    private JList<String> list; //List that will hold each account

    //The different buttons for specific tasks
    // private JButton addAccount;
    // private JButton removeAccount;
    // private JButton advancedSearch;
    // private JButton favoriteProducts;
    // private JButton addBalance;
    // private JButton deductBalance;
    // private JButton productsList;

    public StoreView() {

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension d = screen.getScreenSize();
        setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);

        //Note: Might need some changes later for size
        String[] data = new String[Base.accounts.size()];

        //Loading each account into the String array
        for (int i = 0; i < data.length; i++) {

            data[i] = Base.accounts.get(i).toString();
        }

        list = new JList<String>(data);

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(list);
        JLabel header = new JLabel("Last Name  |  First Name  |  Date of Birth"
        + "  |  Email  |  Balance  |  Position", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.insets = new Insets(5, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 3;

        gridbag.setConstraints(scrollpane, c);
        add(scrollpane);

        c.insets = new Insets(5, 100, 5, 100);
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridheight = 1;
        makeButton("Add Account", gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("Remove Account", gridbag, c);

        c.weightx = 0.0;
        c.gridheight = 3;
        makeButton("Advanced Search", gridbag, c);

        c.weightx = 1.0;
        c.gridheight = 1;
        c.gridwidth = GridBagConstraints.RELATIVE;
        makeButton("Add Balance", gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("Deduct Balance", gridbag, c);

        c.gridwidth = GridBagConstraints.RELATIVE;
        makeButton("View User Favorite Products", gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("View Available Products", gridbag, c);

        // makeButton("Button1", gridbag, c);
        // makeButton("Button2", gridbag, c);
        // makeButton("Button3", gridbag, c);
        //
        // c.gridwidth = GridBagConstraints.REMAINDER; //end row
        // makeButton("Button4", gridbag, c);
        //
        // c.weightx = 0.0;                //reset to the default
        // makeButton("Button5", gridbag, c); //another row
        //
        // c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
        // makeButton("Button6", gridbag, c);
        //
        // c.gridwidth = GridBagConstraints.REMAINDER; //end row
        // makeButton("Button7", gridbag, c);
        //
        // c.gridwidth = 1;                //reset to the default
        // c.gridheight = 2;
        // c.weighty = 1.0;
        // makeButton("Button8", gridbag, c);
        //
        // c.weighty = 0.0;                //reset to the default
        // c.gridwidth = GridBagConstraints.REMAINDER; //end row
        // c.gridheight = 1;               //reset to the default
        // makeButton("Button9", gridbag, c);
        // makeButton("Button10", gridbag, c);

        // c.insets = new Insets(50, 10, 0, 10);




        // c.gridwidth = 1;
        // c.gridheight = 5;
        // c.weightx = 1.0;
        // makeButton("Add an account", gridbag, c);

        // addAccount = new JButton("Add an account");
        // removeAccount = new JButton("Remove account");
        // advancedSearch = new JButton("Advanced Search");
        // favoriteProducts = new JButton("Favorite Products");
        // addBalance = new JButton("Add to Balance");
        // deductBalance = new JButton("Deduct from Balance");
        // productsList = new JButton("List of available products");

        // add(addAccount);
        // add(removeAccount);
        // add(advancedSearch);
        // add(favoriteProducts);
        // add(addBalance);
        // add(deductBalance);
        // add(productsList);
    }

    public void makeButton(String name, GridBagLayout gridbag,
    GridBagConstraints c) {

        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        add(button);
    }

    /*
    * The main method instantiates the main application window
    **/

    public static void main(String[] args) {

        StoreView gui = new StoreView();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setTitle("My first Java list :)");
    }
}