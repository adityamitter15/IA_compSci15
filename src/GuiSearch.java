import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.util.Scanner;
public class GuiSearch implements ActionListener, DocumentListener {

    private final int FRAME_WIDTH = 1028;
    private final int FRAME_HEIGHT = 768;
    private final int LEFT_MARGIN = 100;
    private final int TOP_MARGIN = 50;
    private final int TEXT_WIDTH = 200;
    private final int TEXT_HEIGHT = 30;
    private final int BUTTON_WIDTH = 150;
    private final int BUTTON_HEIGHT = 30;

    private JFrame frame;
    private JTextField filter;
    private JTextField searchBar;
    public JTextField inputQuantity;
    private JButton filterButton;
    private JButton searchButton;
    private JButton calcButton;
    private JComboBox filterCombo;

    public GuiSearch(){
        frame= new JFrame();

        //Instructions on the labels
        JLabel instructions1 = new JLabel("Search for a paper type: ");
        instructions1.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions1);

        JLabel instructions2 = new JLabel("Enter Quantity (15-25t / vessel): ");
        instructions2.setBounds(LEFT_MARGIN, TOP_MARGIN*3, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions2);

        //Input text fields
        filter = new JTextField();
        filter.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT*2, TEXT_WIDTH, TEXT_HEIGHT);
        filter.getDocument().addDocumentListener(this);
        frame.add(filter);
        filter.setVisible(false);

        searchBar = new JTextField();
        searchBar.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        searchBar.getDocument().addDocumentListener(this);
        frame.add(searchBar);

        inputQuantity = new JTextField();
        inputQuantity.setBounds(LEFT_MARGIN, TOP_MARGIN*3 + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        inputQuantity.getDocument().addDocumentListener(this);
        frame.add(inputQuantity);

        //buttons
        filterButton = new JButton("Filter (optional)");
        filterButton.setBounds(LEFT_MARGIN*3, TOP_MARGIN + TEXT_HEIGHT*2 , BUTTON_WIDTH, BUTTON_HEIGHT);
        filterButton.addActionListener(this);
        frame.add(filterButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(LEFT_MARGIN*3, TOP_MARGIN + TEXT_HEIGHT , BUTTON_WIDTH, BUTTON_HEIGHT);
        searchButton.addActionListener(this);
        frame.add(searchButton);

        calcButton = new JButton("Calculate Rate");
        calcButton.setBounds(LEFT_MARGIN*3, TOP_MARGIN*3 + TEXT_HEIGHT , BUTTON_WIDTH, BUTTON_HEIGHT);
        calcButton.addActionListener(this);
        frame.add(calcButton);

        //combo box
        String[] filterTypes = {"GSM", "Width", "Brightness", "Weight"};
        filterCombo = new JComboBox(filterTypes);
        filterCombo.setBounds(LEFT_MARGIN*5, TOP_MARGIN + TEXT_HEIGHT*2 , BUTTON_WIDTH, BUTTON_HEIGHT);
        filterCombo.addActionListener(this);
        frame.add(filterCombo);
        filterCombo.setVisible(false);

        //other frame attributes
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            Inventory searchPaper = new Inventory();
            System.out.println("Searching for " + searchBar.getText());
            if(searchBar.getText().equals("")){
                searchPaper.search(searchBar.getText(),-1);
            }else{
                searchPaper.search(searchBar.getText(),Integer.parseInt(filter.getText()));
            }
        }
        if (e.getActionCommand().equals("Filter (optional)")) {
            filterCombo.setVisible(true);
        }
        if(e.getSource() == filterCombo){
            filter.setVisible(true);
        }
        if (e.getActionCommand().equals("Calculate Rate")) {
            MagazinePaper calc = new MagazinePaper();
            calc.calculate();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
