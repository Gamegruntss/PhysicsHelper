import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class failedGUI{
    private int clicks = 0;
    private JLabel label = new JLabel("Number of clicks:  0     ");
    private JFrame frame = new JFrame();

    public failedGUI() {

        // the clickable button
        JButton button = new JButton("Click Me");
        //button.addActionListener(this);
        

        // the panel with the button and text
        JPanel panel = new JPanel();
        JTextField initialVel = new JTextField();
        panel.setBorder(BorderFactory.createEmptyBorder(400, 700, 400, 700));
        panel.setLayout(new GridLayout(6, 9));
        panel.add(label);
        panel.add(initialVel);
        initialVel.hide();
        
      //creates a checkbox
        JCheckBox cB = new JCheckBox(new AbstractAction("Initial Velocity") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
        	
        });
        
        
        panel.add(cB);
        

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
   /* public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Number of clicks:  " + clicks);
    }*/

    // create one Frame
    public static void main(String[] args) {
        new failedGUI();
    }
}