import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
public class MagazinePaper extends OrderPlacing {
    private final int rate = 550 ;

    public int calculate(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter quantity ");
        int qty;
        qty= in.nextInt();
        int cost = rate*qty ;

        return cost;
       // return value then put into j label

    }

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 500;
    private final int LEFT_MARGIN = 160;
    private final int TOP_MARGIN = 20;
    private final int BUTTON_X = 50;
    private final int BUTTON_Y = 50;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 40;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;

    private JFrame frame;
    private JButton GSM1button;
    private JButton GSM2button;
    private JButton okButton;
    private JTextField sizeField;
    private JTextField quantityField;
    public MagazinePaper() {

        frame = new JFrame();

        // Instructions on the labels
        JLabel instructions1 = new JLabel("Choose a GSM");
        instructions1.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions1);
        JLabel instructions2 = new JLabel("Enter Size(in mm)");
        instructions2.setBounds(LEFT_MARGIN-10, TOP_MARGIN*4 + BUTTON_HEIGHT*2, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions2);
        JLabel instructions3 = new JLabel("Enter Quantity(tonnes)");
        instructions3.setBounds(LEFT_MARGIN-30, TOP_MARGIN*7 + BUTTON_HEIGHT*4, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions3);
        JLabel instructions4 = new JLabel("[500-1500]");
        instructions4.setBounds(LEFT_MARGIN+BUTTON_HEIGHT, TOP_MARGIN*5 + BUTTON_Y*2, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions4);
        JLabel instructions5 = new JLabel("[15t-25t/vsl]");
        instructions5.setBounds(LEFT_MARGIN+BUTTON_HEIGHT, TOP_MARGIN*7 + BUTTON_Y*4, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions5);

        // Step1:- choose GSM  a)90 GSM  b)80 GSM
        // GSM1 button
        GSM1button = new JButton("90 GSM");
        GSM1button.setBounds(BUTTON_X,BUTTON_Y,BUTTON_WIDTH,BUTTON_HEIGHT);
        GSM1button.addActionListener(this);
        GSM1button.setEnabled(true);
        frame.add(GSM1button);
        // GSM2 button
        GSM2button = new JButton("80 GSM");
        GSM2button.setBounds(BUTTON_WIDTH*2 +BUTTON_X,BUTTON_Y,BUTTON_WIDTH,BUTTON_HEIGHT);
        GSM2button.addActionListener(this);
        GSM2button.setEnabled(true);
        frame.add(GSM2button);

        // Step2:- Enter Size (in mm)
        //text field for entering size
        sizeField = new JTextField();
        sizeField.setBounds(BUTTON_X, TOP_MARGIN*5 + BUTTON_Y*2, (TEXT_WIDTH+BUTTON_WIDTH)/2, TEXT_HEIGHT);
        frame.add(sizeField);


        // Step3:- Choose Quantity (in Tonnes)
        //text field for entering quantity
        quantityField = new JTextField();
        quantityField.setBounds(BUTTON_X, TOP_MARGIN*7 + BUTTON_Y*4, (TEXT_WIDTH+BUTTON_WIDTH)/2, TEXT_HEIGHT);
        frame.add(quantityField);
        // other frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

        //Step4:- ok button
        //click ok
        okButton = new JButton("OK");
        okButton.setBounds(LEFT_MARGIN, TOP_MARGIN*15 + BUTTON_Y*2, BUTTON_WIDTH+10, BUTTON_HEIGHT+10);
        okButton.setEnabled(false);
        okButton.addActionListener(this);
        frame.add(okButton);

        // It Calculates Rate (550$/tonne)
        // Finally you click on button called "Place An Order"
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("90 GSM")) {
            GSM1button.setEnabled(false);
        }
        if (e.getActionCommand().equals("80 GSM")) {
            GSM2button.setEnabled(false);

        }
        if (e.getActionCommand().equals("OK")) {

            if(!GSM1button.isEnabled()){
                System.out.println("Chosen GSM: 90 GSM");
            }
            else if(!GSM2button.isEnabled()){
                System.out.println("Chosen GSM: 80 GSM");
            }else{
                System.out.println("You must choose a GSM");
            }
            String sizeInput = sizeField.getText();
            System.out.println("Chosen Size: " + sizeInput+ "mm");
            String quantityInput = quantityField.getText();
            System.out.println("Chosen Quantity: " + quantityInput+ " tonnes");
            okButton.setEnabled(false);
        }
    }
}
