import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;  // need this import for the DocumentListener

//the clients enter their login details and then continue further
public class Login implements ActionListener, DocumentListener{

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 500;
    private final int LEFT_MARGIN = 100;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_Y = 150;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;

    private JFrame frame;
    private JTextField userNameField;
    private JTextField passwordField;
    private JButton okButton;
    private JButton cancelButton;
    private JButton createAccountButton;

    public Login() {
        frame = new JFrame();

        // Instructions on the labels
        JLabel instructions1 = new JLabel("Enter your user name:");
        instructions1.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions1);
        JLabel instructions2 = new JLabel("Enter your password:");
        instructions2.setBounds(LEFT_MARGIN, TOP_MARGIN*6, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions2);
        JLabel instructions3 = new JLabel("--OR--");
        instructions3.setBounds(LEFT_MARGIN+100, TOP_MARGIN*12,TEXT_WIDTH*2, TEXT_HEIGHT*2);
        frame.add(instructions3);

        // Input text fields
        userNameField = new JTextField();
        userNameField.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        userNameField.getDocument().addDocumentListener(this);
        frame.add(userNameField);
        passwordField = new JTextField();
        passwordField.setBounds(LEFT_MARGIN, (TOP_MARGIN + TEXT_HEIGHT)*3, TEXT_WIDTH, TEXT_HEIGHT);
        passwordField.getDocument().addDocumentListener(this);
        frame.add(passwordField);

        // ok button
        okButton = new JButton("OK");
        okButton.setBounds(LEFT_MARGIN, BUTTON_Y+50, BUTTON_WIDTH, BUTTON_HEIGHT);
        okButton.addActionListener(this);
        okButton.setEnabled(false);
        frame.add(okButton);
        //cancel button
        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(LEFT_MARGIN+120, BUTTON_Y+50, BUTTON_WIDTH, BUTTON_HEIGHT);
        cancelButton.addActionListener(this);
        cancelButton.setEnabled(false);
        frame.add(cancelButton);
        // create account button
        createAccountButton = new JButton("Create a new Account");
        createAccountButton.setBounds(LEFT_MARGIN, BUTTON_Y+130,BUTTON_WIDTH+120, BUTTON_HEIGHT);
        createAccountButton.addActionListener(this);
        createAccountButton.setEnabled(true);
        frame.add(createAccountButton);

        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            String userName = userNameField.getText();
            System.out.println("Welcome, " + userName);
        }
        if(e.getActionCommand().equals("CANCEL")){
            //clears all the text on the screen
            userNameField.setText("");
            passwordField.setText("");
        } else{
            System.out.println("This creates a new account");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // triggers when the style of the text changes
        System.out.println("change!");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove!");
        //disables ok button if length of password is<8 or username is<4
        if(userNameField.getText().length()<4 || passwordField.getText().length()<8 ) {
            okButton.setEnabled(false);
        }
        //disables cancel button if there is no text anywhere
        if(userNameField.getText().equals("") && passwordField.getText().equals("") ) {
            cancelButton.setEnabled(false);
        }
    }
    char ch ;
    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert!");
        boolean passwordLength= false;
        boolean passwordCase = false;
        //enables ok button if length of password is>7 and username is>3
        if(passwordField.getText().length()>7 && userNameField.getText().length()>3){
            passwordLength= true;
        }
        //this is supposed to check for upper and lower case letters
        boolean upperCase = false;
        boolean lowerCase = false;
        for(int i=0 ; i<passwordField.getText().length(); i++){
            ch= passwordField.getText().charAt(i);
            if(Character.isUpperCase(ch)){
                upperCase= true;
                }
            if(Character.isLowerCase(ch)){
                lowerCase= true;
                }
            }
            if(upperCase && lowerCase){
                passwordCase=true;
            }else{
                System.out.println("Use of UPPER and lower case letters");
            }
            if(passwordLength && passwordCase){
                okButton.setEnabled(true);
            }

        //enables cancel button if there is any test on the screen
        cancelButton.setEnabled(true);
        }
    private boolean isValid(String password) {
        //checks if password is valid
        if (password.length()>7 && userNameField.getText().length()>3 ){
            okButton.setEnabled(true);
        }
        return false;
    }
    }
   //TO DO:
//after login they get 2 options:-
//placing an order
//OR tracking an order

