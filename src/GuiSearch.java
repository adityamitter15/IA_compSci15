import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.*;
import java.util.ArrayList;
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
    private JLabel instructions1;
    private JLabel instructions2;
    private JList searchResults;
    private DefaultListModel<String> searchResultsList;
    private JTextField filter;
    private JTextField searchBar;
    public JTextField inputQuantity;
    private JButton searchButton;
    private JButton calcButton;
    private JComboBox filterCombo;

    public GuiSearch(){
        frame= new JFrame();

        //Instructions on the labels
        instructions1 = new JLabel("Search for a paper type: ");
        instructions1.setBounds(LEFT_MARGIN, TOP_MARGIN, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions1);

        instructions2 = new JLabel("Enter Quantity (15-25t / vessel): ");
        instructions2.setBounds(LEFT_MARGIN, TOP_MARGIN*3, TEXT_WIDTH, TEXT_HEIGHT);
        frame.add(instructions2);

        //JList
        searchResultsList = new DefaultListModel();
        searchResults = new JList(searchResultsList);
        searchResults.setBounds(LEFT_MARGIN*5, TOP_MARGIN, TEXT_WIDTH + 50,TEXT_HEIGHT*5);
        frame.add(searchResults);
        searchResults.setVisible(false);
        /**
         * action listner
         * arraylist selected
         * selected.add(searchResults.getSelectedItem)
         */
        searchResultsList.
        @Override
        public void actionPerformed(ListSelectionEvent e) {
            String selectedItem = (String) searchResults.getSelectedValue();
            ArrayList<String> selectedItems = new ArrayList<>();
            selectedItems.add(selectedItem);
        }

        //Input text fields
        filter = new JTextField();
        filter.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT*2, TEXT_WIDTH, TEXT_HEIGHT);
        filter.getDocument().addDocumentListener(this);
        frame.add(filter);
        filter.setEnabled(false);

        searchBar = new JTextField();
        searchBar.setBounds(LEFT_MARGIN, TOP_MARGIN + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        searchBar.getDocument().addDocumentListener(this);
        frame.add(searchBar);

        inputQuantity = new JTextField();
        inputQuantity.setBounds(LEFT_MARGIN, TOP_MARGIN*3 + TEXT_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
        inputQuantity.getDocument().addDocumentListener(this);
        frame.add(inputQuantity);

        //buttons
        searchButton = new JButton("Search");
        searchButton.setBounds(LEFT_MARGIN*3, TOP_MARGIN + TEXT_HEIGHT , BUTTON_WIDTH, BUTTON_HEIGHT);
        searchButton.addActionListener(this);
        frame.add(searchButton);

        calcButton = new JButton("Calculate Rate");
        calcButton.setBounds(LEFT_MARGIN*3, TOP_MARGIN*3 + TEXT_HEIGHT , BUTTON_WIDTH, BUTTON_HEIGHT);
        calcButton.addActionListener(this);
        frame.add(calcButton);

        //combo box
        String[] filterTypes = {"Choose Filter","GSM", "Width", "Brightness", "Weight"};
        filterCombo = new JComboBox(filterTypes);
        filterCombo.setBounds(LEFT_MARGIN*3, TOP_MARGIN + TEXT_HEIGHT*2 , BUTTON_WIDTH, BUTTON_HEIGHT);
        filterCombo.addActionListener(this);
        frame.add(filterCombo);

        //other frame attributes
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            Inventory searchPaper = new Inventory();
            ArrayList<String> results;

            //results = searchPaper.search(searchBar.getText(),Integer.parseInt(filter.getText()),Integer.parseInt(filter.getText()),Integer.parseInt(filter.getText()), Double.parseDouble(filter.getText()));

            System.out.println("Searching for " + searchBar.getText());
            if(filter.getText().equals("")){
               results = searchPaper.search(searchBar.getText(),-1, -1, -1, -1);
            }else{
                results = searchPaper.search(searchBar.getText(),Integer.parseInt(filter.getText()),Integer.parseInt(filter.getText()), Integer.parseInt(filter.getText()), Double.parseDouble(filter.getText()));
            }
            searchResults.setVisible(true);
            searchResultsList.add(0,new String( "Quality,\tGSM,\tWidth,\tBrightness,\tWeight"));
            for(String s : results){
                searchResultsList.addElement(s);
            }
        }
        if(e.getSource() == filterCombo){
            JComboBox cb = (JComboBox)e.getSource();
            String msg = (String)cb.getSelectedItem();
            /*switch (msg) {
                case "GSM": outputText.setText("Searching with Chosen GSM");
                    break;
                case "Width": outputText.setText("Searching with Chosen Width");
                    break;
                case "Brightness": outputText.setText("Searching with Chosen Brightness");
                    break;
                case "Weight": outputText.setText("Searching with Chosen Weight");
                    break;
                default: outputText.setText("An error occurred");
            }*/
            filter.setEnabled(true);
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
