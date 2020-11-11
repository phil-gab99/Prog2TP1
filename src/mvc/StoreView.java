package mvc;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import inventory.*;
import store.*;

/**
* @author Philippe Gabriel
* @version 1.30.16 2020-11-12
*
* The class StoreView indicates how the first main window of the application is
* configured and offers plenty of methods for graphical elements
***/

public class StoreView extends JFrame {

    private static final int FRAME_WIDTH = 800;  //Default frame width
    private static final int FRAME_HEIGHT = 450; //Default frame height

    //Acquiring screen details and dimensions
    private static final Toolkit screen = Toolkit.getDefaultToolkit();
    private static final Dimension d = screen.getScreenSize();

    private StoreModel model;     //Model used for handling events triggered
    private StoreControl control; //Control directing where certain events lead

    //Array list of textfields holding user input details upon element creation
    ArrayList<JTextField> details;
    Account accountOperation;    //Account on which an action needs to be done
    ButtonGroup group;           //Radio button group
    JDialog dialog;              //Dialog used for various user input contexts
    JFrame guiResults;           //Frame holding user advanced search results
    JFrame guiProducts;          //Frame holding available products
    JFrame guiFavorite;          //Frame holding account favorite products
    JList<String> listAccounts;  //List for displaying each account
    JList<String> listResults;   //List for search results
    JList<String> listProducts;  //List for available products
    JList<String> listFavorite;  //List for account favorite products

    /**
    * The constructor method StoreView generates the main frame of the
    * application and holds the list of registered accounts and other useful
    * buttons
    ***/

    public StoreView() {

        //The model and control are instantiated
        model = new StoreModel(this);
        control = new StoreControl(model);

        //Configuring frame layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centerComponent(this, 0);

        //Instantiating list of accounts
        listAccounts = new JList<String>();
        listAccounts.setModel(new DefaultListModel<String>());

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(listAccounts);
        JLabel header = new JLabel("Last Name_First Name_Date of Birth_"
        + "Email_ Balance_Position", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        //Layout properties configuration
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(5, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Applying constraints before displaying
        gridbag.setConstraints(scrollpane, c);
        add(scrollpane);

        //Configuring button locations
        c.weighty = 0.0;
        c.insets = new Insets(5, 20, 5, 5);
        c.gridwidth = GridBagConstraints.RELATIVE;
        makeButton(this, "Add Account", gridbag, c, 1);
        c.insets = new Insets(5, 5, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton(this, "Delete Account", gridbag, c, 2);

        c.insets = new Insets(5, 20, 5, 20);
        makeButton(this, "Advanced Search", gridbag, c, 3);

        c.gridwidth = GridBagConstraints.RELATIVE;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(this, "Add Balance", gridbag, c, 4);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(this, "Deduct Balance", gridbag, c, 5);

        c.gridwidth = GridBagConstraints.RELATIVE;
        c.insets = new Insets(5, 20, 20, 5);
        makeButton(this, "View Favorite Products", gridbag, c, 6);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeButton(this, "View Available Products", gridbag, c, 7);

        setTitle("Magasin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
    * The makeButton method creates a button to implement onto the interface
    * and assigns it a specific listener
    *
    * @param parent Container that will hold the button
    * @param name String indicating button label
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * location details
    * @param listenType Integer indicating which type of listener to assign to
    * the given button
    ***/

    public void makeButton(Container parent, String name,
    GridBagLayout gridbag, GridBagConstraints c, int listenType) {

        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);

        switch (listenType) {
            case 1:
                button.addActionListener(control.new AddAccount());
                break;
            case 2:
                button.addActionListener(control.new DeleteAccount());
                break;
            case 3:
                button.addActionListener(control.new AdvSearch());
                break;
            case 4:
                button.addActionListener(control.new AddBalance());
                break;
            case 5:
                button.addActionListener(control.new DeductBalance());
                break;
            case 6:
                button.addActionListener(control.new FavProducts());
                break;
            case 7:
                button.addActionListener(control.new AvProducts());
                break;
            case 8:
                button.addActionListener(control.new OkAccount());
                break;
            case 9:
                button.addActionListener(control.new OkAddBalance());
                break;
            case 10:
                button.addActionListener(control.new OkDeductBalance());
                break;
            case 11:
                button.addActionListener(control.new AdvSearchSingle());
                break;
            case 12:
                button.addActionListener(control.new AdvSearchMultiple());
                break;
            case 13:
                button.addActionListener(control.new AddProduct());
                break;
            case 14:
                button.addActionListener(control.new RemoveProduct());
                break;
            case 15:
                button.addActionListener(control.new OkProduct());
                break;
            case 16:
                button.addActionListener(control.new AddFave());
                break;
            case 17:
                button.addActionListener(control.new RemoveFave());
                break;
            case 18:
                button.addActionListener(control.new AddAvtoFav());
                break;
            case 20:
                button.addActionListener(control.new Cancel());
                break;
            default: System.out.println("Lolilou");
        }

        parent.add(button);
    }

    /**
    * The makeLabel method creates a label to implement onto the interface
    *
    * @param parent Container that will hold the label
    * @param name String indicating label content
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * location details
    * @param aligment Integer indicating the text alignment within label
    ***/

    public void makeLabel(Container parent, String name, GridBagLayout gridbag,
    GridBagConstraints c, int alignment) {

        JLabel label = new JLabel(name, alignment);
        gridbag.setConstraints(label, c);

        parent.add(label);
    }

    /**
    * The makeTextField method creates a textfield to implement onto the
    * interface and assigns it a specific listener
    *
    * @param parent Container that will hold the textfield
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * location details
    * @param columns Integer dictating textfield width
    ***/

    public void makeTextField(Container parent, GridBagLayout gridbag,
    GridBagConstraints c, int columns, int listenType) {

        JTextField textfield = new JTextField(columns);
        gridbag.setConstraints(textfield, c);

        switch (listenType) {
            case 1:
                textfield.addKeyListener(control.new KeyLetters(columns));
                break;
            case 2:
                textfield.addKeyListener(control.new KeyNumbers(columns));
                break;
            case 3:
                textfield.addKeyListener(control.new KeyMixed(columns));
                break;
        }

        //Input required fields kept in details array list for later retrieval
        details.add(textfield);

        parent.add(textfield);
    }

    /**
    * The makeRadioButton method creates a radio button to implement onto the
    * interface
    *
    * @param parent Container that will hold the radio button
    * @param group ButtonGroup assembling radio buttons together
    * @param label String labelling the radio button
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * details on where the radio button is to be added
    * @param listenType Integer representing listener for this component
    ***/

    public void makeRadioButton(Container parent, ButtonGroup group,
    String label, GridBagLayout gridbag, GridBagConstraints c,
    int listenType) {

        JRadioButton radio = new JRadioButton(label);
        gridbag.setConstraints(radio, c);

        switch (listenType) {
            case 1: radio.addChangeListener(control.new ProductFields());
        }

        group.add(radio);
        parent.add(radio);
    }

    /**
    * The method makeResultsFrame generates the frame displaying the user's
    * search results
    ***/

    public void makeResultsFrame() {

        //Instantiating frame
        guiResults = new JFrame("Search Results");

        //Configuring frame layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        guiResults.setLayout(gridbag);
        guiResults.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centerComponent(guiResults, 50);

        //Instantiating list of results
        listResults = new JList<String>();
        listResults.setModel(new DefaultListModel<String>());

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(listResults);
        JLabel header = new JLabel("Last Name_First Name_Date of Birth_"
        + "Email_ Balance_Position", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        //Layout properties configuration
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(20, 20, 20, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Applying constraints before displaying
        gridbag.setConstraints(scrollpane, c);
        guiResults.add(scrollpane);

        guiResults.setVisible(true);
    }

    /**
    * The method makeViewProductsFrame generates the frame displaying the
    * available products and other relevant buttons to it
    ***/

    public void makeViewProductsFrame(Account user) {

        //Reference of the account under which the products are viewed is kept
        accountOperation = user;

        //Instantiating frame
        guiProducts = new JFrame("Available Products");

        //Configuring frame layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        guiProducts.setLayout(gridbag);
        guiProducts.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centerComponent(guiProducts, 50);

        //Acquiring products for displaying
        ArrayList<Product> avProducts = Base.getProducts();
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (Product p : avProducts) {

            listModel.addElement(p.toString());
        }

        //Instantiating list of products
        listProducts = new JList<String>();
        listProducts.setModel(listModel);

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(listProducts);
        JLabel header = new JLabel("Manager Name_Property1_Property2_..._Product Type",
        JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        //Layout properties configuration
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(20, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Applying constraints before displaying
        gridbag.setConstraints(scrollpane, c);
        guiProducts.add(scrollpane);

        //Configuring button locations
        c.weighty = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.insets = new Insets(5, 20, 20, 5);
        makeButton(guiProducts, "Add Product", gridbag, c, 13);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeButton(guiProducts, "Remove Product", gridbag, c, 14);

        guiProducts.setVisible(true);
    }

    /**
    * The method makeFavProductsFrame generates the frame displaying the
    * account's favorite products and other relevant buttons to it
    ***/

    public void makeFavProductsFrame(Account user) {

        //Account of interest's reference is kept for later use
        accountOperation = user;

        //Instantiating frame
        guiFavorite = new JFrame(user.getLastName() + " " + user.getFirstName()
        + "\'s favorite products");

        //Configuring frame layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        guiFavorite.setLayout(gridbag);
        guiFavorite.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centerComponent(guiFavorite, 50);

        //Displaying account's current favorite product list
        ArrayList<Product> favProducts = Base.getFavProducts(user);
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (Product p : favProducts) {

            listModel.addElement(p.toString());
        }

        //Instantiating list of favorite products
        listFavorite = new JList<String>();
        listFavorite.setModel(listModel);

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(listFavorite);
        JLabel header = new JLabel("Manager Name_Property1_Property2_..._Product Type",
        JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        //Layout properties configuration
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(20, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Applying constraints before displaying
        gridbag.setConstraints(scrollpane, c);
        guiFavorite.add(scrollpane);

        //Configuring button locations
        c.weighty = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.insets = new Insets(5, 20, 20, 5);
        makeButton(guiFavorite, "Add Product", gridbag, c, 16);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeButton(guiFavorite, "Remove Product", gridbag, c, 17);

        guiFavorite.setVisible(true);
    }

    /**
    * The method makeAvToFavFrame generates the frame displaying the list of
    * products available from which the user can choose his desired favorite
    * products
    ***/

    public void makeAvToFavFrame(UserFavProducts u) {

        //Prevent user from re-opening the same window
        try {

            if (guiProducts.isVisible()) {

                msgBox("The products list is already visible.",
                "Products List Visible", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch(NullPointerException e) {
            //Do nothing
        }

        //Instantiating frame
        guiProducts = new JFrame("Available Products");

        //Configuring frame layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        guiProducts.setLayout(gridbag);
        guiProducts.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centerComponent(guiProducts, 100);

        //Displaying only the products not present within favorite list
        ArrayList<Product> avProducts = Base.getProducts();
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (Product p : avProducts) {

            if (!(u.hasFave(p))) {

                listModel.addElement(p.toString());
            }
        }

        //Instantiating list of available products
        listProducts = new JList<String>();
        listProducts.setModel(listModel);

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(listProducts);
        JLabel header = new JLabel("Manager Name_Property1_Property2_..._Product Type",
        JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        //Layout properties configuration
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(20, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Applying constraints before displaying
        gridbag.setConstraints(scrollpane, c);
        guiProducts.add(scrollpane);

        //Configuring button locations
        c.weighty = 0.0;
        c.insets = new Insets(5, 20, 20, 20);
        makeButton(guiProducts, "Add", gridbag, c, 18);

        guiProducts.setVisible(true);
    }

    /**
    * The method accountDialog generates a dialog box with options for the user
    * to select for creating an account
    ***/

    public void accountDialog() {

        //Instantiating dialog, radio button group and details list
        dialog = new JDialog(this, "Add Account", true);
        group = new ButtonGroup();
        details = new ArrayList<JTextField>();

        //Configuring dialog layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        dialog.setSize(FRAME_WIDTH/2, FRAME_HEIGHT/2);
        dialog.setLayout(gridbag);
        centerComponent(dialog, 0);

        //Configuring button, label and textfield locations
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "Last Name: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "First Name: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Date of birth: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 3;
        c.insets = new Insets(5, 5, 5, 5);
        makeTextField(dialog, gridbag, c, 2, 2);
        c.gridwidth = 1;
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.gridwidth = 3;
        makeTextField(dialog, gridbag, c, 2, 2);
        c.gridwidth = 1;
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 4, 2);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeLabel(dialog, "(dd/mm/yyyy)", gridbag, c, SwingConstants.LEFT);

        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Position: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 7;
        c.insets = new Insets(5, 5, 5, 0);
        makeRadioButton(dialog, group, "Client", gridbag, c, 0);
        c.insets = new Insets(5, 0, 5, 0);
        makeRadioButton(dialog, group, "Employee", gridbag, c, 0);
        c.insets = new Insets(5, 0, 5, 20);
        makeRadioButton(dialog, group, "Manager", gridbag, c, 0);

        c.gridy = 5;
        c.ipady = 10;
        c.gridwidth = 8;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(dialog, "OK", gridbag, c, 8);
        c.insets = new Insets(5, 5, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /**
    * The method advSearchDialog generates a dialog box with options for the
    * user to search for specific users of the list
    ***/

    public void advSearchDialog() {

        //Instantiating dialog, radio button group and details list
        dialog = new JDialog(this, "Advanced Search", true);
        group = new ButtonGroup();
        details = new ArrayList<JTextField>();

        //Configuring dialog layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        dialog.setSize(FRAME_WIDTH - 320, FRAME_HEIGHT);
        dialog.setLayout(gridbag);
        centerComponent(dialog, 0);

        //Configuring button, label and textfield locations
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(20, 20, 5, 20);
        makeLabel(dialog, "Single User Search*", gridbag, c, SwingConstants.CENTER);

        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "Last Name: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1);

        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "First Name: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1);

        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Date of birth: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        makeTextField(dialog, gridbag, c, 2, 2);
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        makeTextField(dialog, gridbag, c, 2, 2);
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 4, 2);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeLabel(dialog, "(dd/mm/yyyy)", gridbag, c, SwingConstants.LEFT);

        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Email: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 5;
        c.insets = new Insets(5, 5, 5, 0);
        makeTextField(dialog, gridbag, c, 0, 3);
        c.insets = new Insets(5, 0, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;
        makeLabel(dialog, "@magasin.ca", gridbag, c, SwingConstants.CENTER);

        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Balance: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 5;
        c.insets = new Insets(5, 5, 5, 0);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.gridy = 7;
        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Position: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 2;
        c.insets = new Insets(5, 0, 5, 0);
        makeRadioButton(dialog, group, "Client", gridbag, c, 0);
        makeRadioButton(dialog, group, "Employee", gridbag, c, 0);
        makeRadioButton(dialog, group, "Manager", gridbag, c, 0);

        c.gridy = 8;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 20, 5, 20);
        makeLabel(dialog, "*Note: All fields must be filled to undertake search.",
        gridbag, c, SwingConstants.LEFT);

        c.gridy = 9;
        makeLabel(dialog, "________________________________________________",
        gridbag, c, SwingConstants.CENTER);

        c.gridy = 10;
        makeLabel(dialog, "Multiple User Search", gridbag, c, SwingConstants.CENTER);

        c.gridy = 11;
        c.gridwidth = 5;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Last name first letter: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 0);
        makeTextField(dialog, gridbag, c, 1, 1);

        c.gridy = 12;
        c.ipady = 10;
        c.gridwidth = 6;
        c.insets = new Insets(5, 20, 20, 5);
        makeButton(dialog, "Single Search", gridbag, c, 11);
        c.insets = new Insets(5, 5, 20, 5);
        makeButton(dialog, "Multiple Search", gridbag, c, 12);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /**
    * The method addBalanceDialog generates a dialog box with options for the
    * user to indicate the amount to add unto the selected account's balance
    *
    * @param a Account for which balance adding is needed
    ***/

    public void addBalanceDialog(Account a) {

        //Account of interest's reference is kept for later use
        accountOperation = a;

        //Instantiating dialog and details list
        dialog = new JDialog(this, "Add Balance", true);
        details = new ArrayList<JTextField>();

        //Configuring dialog layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        dialog.setSize(FRAME_WIDTH/3, FRAME_HEIGHT/3);
        dialog.setLayout(gridbag);
        centerComponent(dialog, 0);

        //Configuring button, label and textfield locations
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "Amount: ", gridbag, c, SwingConstants.CENTER);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.ipady = 10;
        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(dialog, "OK", gridbag, c, 9);
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /**
    * The method deductBalanceDialog generates a dialog box with options for
    * the user to indicate the amount to deduct from the selected account's
    * balance
    *
    * @param a Account for which balance deducting is needed
    ***/

    public void deductBalanceDialog(Account a) {

        //Account of interest's reference is kept for later use
        accountOperation = a;

        //Instantiating dialog and details list
        dialog = new JDialog(this, "Deduct Balance", true);
        details = new ArrayList<JTextField>();

        //Configuring dialog layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        dialog.setSize(FRAME_WIDTH/3, FRAME_HEIGHT/3);
        dialog.setLayout(gridbag);
        centerComponent(dialog, 0);

        //Configuring button, label and textfield locations
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "Amount: ", gridbag, c, SwingConstants.RIGHT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.ipady = 10;
        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(dialog, "OK", gridbag, c, 10);
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /**
    * The method addProductDialog generates a dialog box with options for
    * the user to fill out fields for adding products
    *
    * @param a Account which initiated the action
    ***/

    public void addProductDialog() {

        //Instantiating dialog, radio button group and details list
        dialog = new JDialog(this, "Add Product", true);
        group = new ButtonGroup();
        details = new ArrayList<JTextField>();

        //Configuring dialog layout, size and location
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        dialog.setSize(FRAME_WIDTH - 320, FRAME_HEIGHT);
        dialog.setLayout(gridbag);
        centerComponent(dialog, 50);

        //Configuring button, label and textfield locations
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridx = 1;
        c.gridwidth = 1;
        c.insets = new Insets(20, 20, 5, 5);
        makeRadioButton(dialog, group, "Food", gridbag, c, 1);

        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(5, 5, 5, 5);
        makeLabel(dialog, "Name: ", gridbag, c, SwingConstants.LEFT);
        c.gridx = 3;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1);

        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        makeLabel(dialog, "Color: ", gridbag, c, SwingConstants.LEFT);
        c.gridx = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1); //To be changed to a button to open JColorChooser

        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 20, 5);
        makeLabel(dialog, "Weight: ", gridbag, c, SwingConstants.LEFT);
        c.gridx = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.gridx = 1;
        c.gridy = 5;
        makeLabel(dialog, "________________________________________________",
        gridbag, c, SwingConstants.CENTER);

        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 6;
        c.insets = new Insets(20, 20, 5, 5);
        makeRadioButton(dialog, group, "Furniture", gridbag, c, 1);

        c.gridx = 2;
        c.gridy = 7;
        c.insets = new Insets(5, 5, 5, 5);
        makeLabel(dialog, "Type: ", gridbag, c, SwingConstants.LEFT);
        c.gridx = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 1);

        c.gridx = 2;
        c.gridy = 8;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 5, 5);
        makeLabel(dialog, "Price: ", gridbag, c, SwingConstants.LEFT);
        c.gridx = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.gridx = 2;
        c.gridy = 9;
        c.gridwidth = 1;
        c.insets = new Insets(5, 5, 20, 5);
        makeLabel(dialog, "Height: ", gridbag, c, SwingConstants.LEFT);
        c.gridx = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.gridx = 1;
        c.gridy = 10;
        c.ipady = 10;
        c.gridwidth = 2;
        c.insets = new Insets(5, 20, 20, 5);
        makeButton(dialog, "OK", gridbag, c, 15);
        c.gridx = 3;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 20, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /**
    * The method centerComponent centers a given component with a given offset
    * with respect to the screen dimensions
    *
    * @param c Component to be centered
    * @param offset Integer indicating offset from center
    ***/

    public void centerComponent(Component c, int offset) {

        c.setLocation((d.width - c.getWidth()) / 2 - offset,
        (d.height - c.getHeight()) / 2 - offset);
    }

    /**
    * The method msgBox creates an informative pane to the user with
    * the given message as information
    *
    * @param message String holding information to display
    * @param title String indicating pane title
    * @param messageType Integer indicating the type of message to display
    ***/

    public static void msgBox(String message, String title, int messageType) {

        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    /**
    * The method run initiates the program
    ***/

    public static void run() {

        StoreView gui = new StoreView();
    }
}