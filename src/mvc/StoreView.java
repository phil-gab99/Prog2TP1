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

    private StoreModel model;
    private StoreControl control;

    public JList<String> list; //List that will hold each account

    public StoreView() {

        model = new StoreModel(this);
        control = new StoreControl(model);

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
        JLabel header = new JLabel("Last Name - First Name - Date of Birth"
        + " - Email - Balance - Position", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.insets = new Insets(5, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 3;

        gridbag.setConstraints(scrollpane, c);
        add(scrollpane);

        //Configuring button placements
        c.insets = new Insets(5, 100, 5, 100);
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridheight = 1;
        makeButton("Add Account", gridbag, c, 1);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("Delete Account", gridbag, c, 2);

        c.weightx = 0.0;
        c.gridheight = 3;
        makeButton("Advanced Search", gridbag, c, 3);

        c.weightx = 1.0;
        c.gridheight = 1;
        c.gridwidth = GridBagConstraints.RELATIVE;
        makeButton("Add Balance", gridbag, c, 4);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("Deduct Balance", gridbag, c, 5);

        c.gridwidth = GridBagConstraints.RELATIVE;
        makeButton("View Favorite Products", gridbag, c, 6);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("View Available Products", gridbag, c, 7);
    }

    public void makeButton(String name, GridBagLayout gridbag,
        GridBagConstraints c, int listenType) {

        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);

        switch (listenType) {
            case 1: button.addActionListener(control.new AddAccount()); break;
            case 2: button.addActionListener(control.new DeleteAccount()); break;
            // case 3: button.addActionListener(StoreControl.new AddAccount()); break
            // case 4: button.addActionListener(StoreControl.new AddAccount()); break
            // case 5: button.addActionListener(StoreControl.new AddAccount()); break
            // case 6: button.addActionListener(StoreControl.new AddAccount()); break
            // case 7: button.addActionListener(StoreControl.new AddAccount()); break
            default: System.out.println("Lolilou");
        }


        add(button);
    }

    /*
    * The main method instantiates the main application window
    **/

    public static void main(String[] args) {

        Client c1 = new Client("Ayoub", "Souleiman", "01/02/1999");
        Client c2 = new Client("Ayoub", "Souleiman", "01/02/1999");
        Client c3 = new Client("Ayoub", "Souleiman", "01/02/1999");

        StoreView gui = new StoreView();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setTitle("My first Java list :)");
    }
}