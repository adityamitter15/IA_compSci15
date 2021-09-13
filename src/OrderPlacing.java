import javax.swing.*;
import java.awt.event.*;

public class OrderPlacing implements ActionListener {
    //this will have 3 subclasses which are 3 qualities of paper
    private final int button_width = 400;
    private final int button_height = 150;
    private JFrame frame;
    JButton[] buttons;
    public OrderPlacing(){
        frame = new JFrame();
        buttons = new JButton[3];
        // initialise all 3 buttons
        for (int i = 0; i < 3; i++) {
            buttons[0] = new JButton("Magazine Paper");
            buttons[1] = new JButton("Newsprint Paper");
            buttons[2] = new JButton("Book Paper");

            int xPosition = 0;
            int yPosition = i*button_height;
            buttons[i].setBounds(xPosition, yPosition, button_width, button_height);
            // add event listener
            buttons[i].addActionListener(this);

            // add button to JFrame
            frame.add(buttons[i]);

            frame.setSize(400, 500);
            frame.setLayout(null);
            // make the frame visible
            frame.setVisible(true);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Magazine Paper")) {
            System.out.println("Opens Magazine Paper order details");
        } else if (e.getActionCommand().equals("Newsprint Paper")){
            System.out.println("Opens Newsprint Paper order details");
        } else{
            System.out.println("Opens Book Paper order details");
        }
    }

}
