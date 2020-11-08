package mvc;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.30.16 2020-11-12
*
* The class StoreView indicates how the first main window of the application is
* configured
**/

public class StoreView extends JFrame {

    private static final int FRAME_WIDTH = 800; //Default frame width
    private static final int FRAME_HEIGHT = 450; //Default frame height
    private static final Toolkit screen = Toolkit.getDefaultToolkit();
    private static final Dimension d = screen.getScreenSize();

    private StoreModel model;
    private StoreControl control;

    //Array list of components holding user input details upon element creation
    protected ArrayList<JTextField> details;
    //Account on which some action needs to be done
    protected Account accountOperation;
    protected ButtonGroup group;  //Radio button group
    protected JList<String> list; //List that will hold each account
    protected JDialog dialog;     //Dialog used for various user input contexts


    public StoreView() {

        model = new StoreModel(this);
        control = new StoreControl(model);

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        centerComponent(this);

        list = new JList<String>();
        list.setModel(new DefaultListModel<String>());

        //Creating and configuring the scrollpane and list header
        JScrollPane scrollpane = new JScrollPane(list);
        JLabel header = new JLabel("Last Name_First Name_Date of Birth_"
        + "Email_ Balance_Position", JLabel.LEFT);
        header.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scrollpane.setColumnHeaderView(header);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.insets = new Insets(5, 20, 5, 20);
        c.gridwidth = GridBagConstraints.REMAINDER;

        gridbag.setConstraints(scrollpane, c);
        add(scrollpane);

        //Configuring button placements
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
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(this, "View Favorite Products", gridbag, c, 6);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(this, "View Available Products", gridbag, c, 7);
    }

    /*
    * The makeButton method creates a button to implement onto the interface
    * and assigns it a specific listener
    *
    * @param parent Container that will hold the button
    * @param name String indicating button label
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * details on where the button is to be added
    * @param listenType Integer indicating which type of listener to assign to
    * the given button
    **/

    public void makeButton(Container parent, String name, GridBagLayout gridbag,
        GridBagConstraints c, int listenType) {

        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);

        switch (listenType) {
            case 1: button.addActionListener(control.new AddAccount()); break;
            case 2: button.addActionListener(control.new DeleteAccount()); break;
            case 3: button.addActionListener(control.new AdvSearch()); break;
            case 4: button.addActionListener(control.new AddBalance()); break;
            case 5: button.addActionListener(control.new DeductBalance()); break;
            // case 6: button.addActionListener(StoreControl.new AddAccount()); break
            // case 7: button.addActionListener(StoreControl.new AddAccount()); break
            case 8: button.addActionListener(control.new OkAccount()); break;
            case 9: button.addActionListener(control.new OkAddBalance()); break;
            case 10: button.addActionListener(control.new OkDeductBalance()); break;
            case 20: button.addActionListener(control.new Cancel()); break;
            default: System.out.println("Lolilou");
        }

        parent.add(button);
    }

    /*
    * The makeLabel method creates a label to implement onto the interface
    *
    * @param parent Container that will hold the label
    * @param name String indicating label content
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * details on where the label is to be added
    * @param aligment Float constant indicating the text alignment within label
    **/

    public void makeLabel(Container parent, String name, GridBagLayout gridbag,
        GridBagConstraints c, int alignment) {

        JLabel label = new JLabel(name, alignment);
        gridbag.setConstraints(label, c);

        parent.add(label);
    }

    /*
    * The makeTextField method creates a textfield to implement onto the
    * interface and assigns it a specific listener
    *
    * @param parent Container that will hold the textfield
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * details on where the textfield is to be added
    * @param columns Integer dictating textfield width
    **/

    public void makeTextField(Container parent, GridBagLayout gridbag,
        GridBagConstraints c, int columns, int listenType) {

        JTextField textfield = new JTextField(columns);
        gridbag.setConstraints(textfield, c);

        switch (listenType) {
            case 1: textfield.addKeyListener(control.new KeyLetters(columns)); break;
            case 2: textfield.addKeyListener(control.new KeyNumbers(columns)); break;
        }

        details.add(textfield);
        parent.add(textfield);
    }

    /*
    * The makeRadioButton method creates a radio button to implement onto the
    * interface
    *
    * @param parent Container that will hold the radio button
    * @param group ButtonGroup assembling radio buttons together
    * @param label String labelling the radio button
    * @param gridbag GridBagLayout with parent layout details
    * @param c GridBagConstraints indicating the specific constraints and
    * details on where the radio button is to be added
    **/

    public void makeRadioButton(Container parent, ButtonGroup group,
        String label, GridBagLayout gridbag, GridBagConstraints c) {

        JRadioButton radio = new JRadioButton(label);
        gridbag.setConstraints(radio, c);

        group.add(radio);
        parent.add(radio);
    }

    /*
    * The method accountDialog generates a dialog box with options for the user
    * to select for creating an account
    *
    * @param title String indicating dialog box title
    **/

    public void accountDialog(String title) {

        dialog = new JDialog(this, title, true);
        group = new ButtonGroup();
        details = new ArrayList<JTextField>();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        dialog.setSize(FRAME_WIDTH/2, FRAME_HEIGHT/2);
        centerComponent(dialog);
        dialog.setLayout(gridbag);

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
        c.gridwidth = 6;
        c.insets = new Insets(5, 5, 5, 0);
        makeTextField(dialog, gridbag, c, 2, 2);
        c.insets = new Insets(5, 0, 5, 0);
        c.gridwidth = 1;
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.gridwidth = 6;
        makeTextField(dialog, gridbag, c, 2, 2);
        c.gridwidth = 1;
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 0, 5, 20);
        makeTextField(dialog, gridbag, c, 4, 2);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Position: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 7;
        c.insets = new Insets(5, 5, 5, 0);
        makeRadioButton(dialog, group, "Client", gridbag, c);
        c.insets = new Insets(5, 0, 5, 0);
        makeRadioButton(dialog, group, "Employee", gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 0, 5, 20);
        makeRadioButton(dialog, group, "Manager", gridbag, c);

        c.gridwidth = 11;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(dialog, "OK", gridbag, c, 8);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /*
    * The method advSearchDialog generates a dialog box with options for the
    * user to search for specific users of the list
    *
    * @param title String indicating dialog box title
    **/

    public void advSearchDialog(String title) {

        dialog = new JDialog(this, title, true);
        group = new ButtonGroup();
        details = new ArrayList<JTextField>();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        dialog.setSize(FRAME_WIDTH/2, FRAME_HEIGHT);
        centerComponent(dialog);
        dialog.setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 20, 5, 20);
        makeLabel(dialog, "Single User Search*", gridbag, c, SwingConstants.CENTER);

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
        c.gridwidth = 6;
        c.insets = new Insets(5, 5, 5, 0);
        makeTextField(dialog, gridbag, c, 2, 2);
        c.insets = new Insets(5, 0, 5, 0);
        c.gridwidth = 1;
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.gridwidth = 6;
        makeTextField(dialog, gridbag, c, 2, 2);
        c.gridwidth = 1;
        makeLabel(dialog, "/", gridbag, c, SwingConstants.CENTER);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 0, 5, 20);
        makeTextField(dialog, gridbag, c, 4, 2);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Position: ", gridbag, c, SwingConstants.LEFT);
        c.gridwidth = 7;
        c.insets = new Insets(5, 5, 5, 0);
        makeRadioButton(dialog, group, "Client", gridbag, c);
        c.insets = new Insets(5, 0, 5, 0);
        makeRadioButton(dialog, group, "Employee", gridbag, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 0, 5, 20);
        makeRadioButton(dialog, group, "Manager", gridbag, c);

        c.insets = new Insets(5, 20, 5, 20);
        makeLabel(dialog, "*Note: Fill out at least one field to begin a search.",
        gridbag, c, SwingConstants.LEFT);

        makeLabel(dialog, "________________________________________________",
        gridbag, c, SwingConstants.CENTER);

        makeLabel(dialog, "Multiple User Search", gridbag, c, SwingConstants.CENTER);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 0);
        makeLabel(dialog, "Last name first letter: ", gridbag, c, SwingConstants.LEFT);
        c.insets = new Insets(5, 5, 5, 0);
        makeTextField(dialog, gridbag, c, 1, 1);

        dialog.setVisible(true);
    }

    /*
    * The method addBalanceDialog generates a dialog box with options for the
    * user to indicate the amount to add unto the selected account's balance
    *
    * @param title String indicating dialog box title
    * @param a Account for which balance needs to be modified
    **/

    public void addBalanceDialog(String title, Account a) {

        accountOperation = a;
        dialog = new JDialog(this, title, true);
        details = new ArrayList<JTextField>();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        dialog.setSize(FRAME_WIDTH/2, FRAME_HEIGHT/2);
        centerComponent(dialog);
        dialog.setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "Amount: ", gridbag, c, SwingConstants.RIGHT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(dialog, "OK", gridbag, c, 9);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /*
    * The method deductBalanceDialog generates a dialog box with options for
    * the user to indicate the amount to deduct from the selected account's
    * balance
    *
    * @param title String indicating dialog box title
    * @param a Account for which balance needs to be modified
    **/

    public void deductBalanceDialog(String title, Account a) {

        accountOperation = a;
        dialog = new JDialog(this, title, true);
        details = new ArrayList<JTextField>();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        dialog.setSize(FRAME_WIDTH/2, FRAME_HEIGHT/2);
        centerComponent(dialog);
        dialog.setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeLabel(dialog, "Amount: ", gridbag, c, SwingConstants.RIGHT);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeTextField(dialog, gridbag, c, 0, 2);

        c.gridwidth = 1;
        c.insets = new Insets(5, 20, 5, 5);
        makeButton(dialog, "OK", gridbag, c, 10);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 20);
        makeButton(dialog, "Cancel", gridbag, c, 20);

        dialog.setVisible(true);
    }

    /*
    * The method centerComponent centers a given component with respect to
    * their screen dimensions
    *
    * @param c Component to be centered
    **/

    public void centerComponent(Component c) {
        c.setLocation((d.width - c.getWidth()) / 2, (d.height - c.getHeight()) / 2);
    }

    /*
    * The method msgBox creates a dialog informative pane to the user with
    * the given message as information
    *
    * @param message String holding information to display
    * @param title String indicating dialog box title
    * @param messageType Integer indicating the type of message to display
    **/

    public static void msgBox(String message, String title, int messageType) {

        JOptionPane.showMessageDialog(null, message, title, messageType);
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