import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI {
	
	
	//creating static variables that can be called in main.java 
	//as attributes of a kinematics eqaution
	
	public static double initialVelocity;
	public static double finalVelocity;
	public static double deltaT;
	public static double deltaY;
	public static double acceleration;
	
	public static boolean ViGive;
	public static boolean VfGive;
	public static boolean dtGive;
	public static boolean dyGiven;
	public static boolean accGive;
	
	
	//creating variables to find the required
	
	public static boolean iniVboo;
	public static boolean finVboo;
	public static boolean dTboo;
	public static boolean dYboo;
	public static boolean accBoo;
	

	private JFrame frame;
	private JTextField ViField;
	private JCheckBox VfBox;
	private JTextField VfField;
	private JCheckBox dtBox;
	private JTextField dtField;
	private JCheckBox dyBox;
	private JTextField dyField;
	private JCheckBox FFbox;
	private JTextField accField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	
	public double emptyFieldCheck(String s) {
		if (!s.equals("")) {
			return Double.valueOf(s);
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(100, 100, 958, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox ViBox = new JCheckBox("Initial Velocity");
		ViBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		ViBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViGive = ViBox.isSelected();
				
				if(ViBox.isSelected()) {
					ViField.setVisible(true);
				} else {
					ViField.setVisible(false);
				}
			}
		});
		ViBox.setBounds(264, 127, 123, 23);
		frame.getContentPane().add(ViBox);
		
		JLabel lblNewLabel = new JLabel("   GIVEN:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel.setBounds(264, 97, 84, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(515, 279, 318, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea outputArea = new JTextArea();
		outputArea.setRows(1);
		outputArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		outputArea.setBounds(10, 11, 298, 117);
		panel.add(outputArea);
		
		ViField = new JTextField();
		ViField.setVisible(false);
		ViField.setHorizontalAlignment(SwingConstants.LEFT);
		ViField.setBounds(236, 157, 151, 23);
		frame.getContentPane().add(ViField);
		ViField.setColumns(10);
		
		VfBox = new JCheckBox("Final Velocity");
		VfBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		VfBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VfGive = VfBox.isSelected();
				if(VfBox.isSelected()) {
					VfField.setVisible(true);
				} else {
					VfField.setVisible(false);
				}
			}
		});
		VfBox.setBounds(264, 187, 123, 23);
		frame.getContentPane().add(VfBox);
		
		VfField = new JTextField();
		VfField.setVisible(false);
		VfField.setBounds(236, 217, 151, 23);
		frame.getContentPane().add(VfField);
		VfField.setColumns(10);
		
		dtBox = new JCheckBox("Change in Time");
		dtBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		dtBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtGive = dtBox.isSelected();
				
				if(dtBox.isSelected()) {
					dtField.setVisible(true);
				} else {
					dtField.setVisible(false);
				}
			}
		});
		dtBox.setBounds(264, 249, 123, 23);
		frame.getContentPane().add(dtBox);
		
		dtField = new JTextField();
		dtField.setVisible(false);
		dtField.setBounds(236, 279, 151, 21);
		frame.getContentPane().add(dtField);
		dtField.setColumns(10);
		
		dyBox = new JCheckBox("Change in Y/Height");
		dyBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		dyBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dyGiven = dyBox.isSelected();
				
				if(dyBox.isSelected()) {
					dyField.setVisible(true);
				} else {
					dyField.setVisible(false);
				}
			}
		});
		dyBox.setBounds(252, 307, 142, 23);
		frame.getContentPane().add(dyBox);
		
		dyField = new JTextField();
		dyField.setVisible(false);
		dyField.setBounds(236, 337, 151, 20);
		frame.getContentPane().add(dyField);
		dyField.setColumns(10);
		
		FFbox = new JCheckBox("Freefall");
		FFbox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		FFbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(FFbox.isSelected()) {
					accField.setVisible(false);
					lblNewLabel_1.setVisible(false);
				} else {
					accField.setVisible(true);
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		FFbox.setBounds(282, 363, 107, 23);
		frame.getContentPane().add(FFbox);
		
		accField = new JTextField();
		accField.setBounds(301, 393, 86, 20);
		frame.getContentPane().add(accField);
		accField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Acceleration:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(224, 396, 84, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialVelocity = emptyFieldCheck(ViField.getText());
				finalVelocity = emptyFieldCheck(VfField.getText());
				deltaT = emptyFieldCheck(dtField.getText());
				deltaY = emptyFieldCheck(dyField.getText());
				if(FFbox.isSelected()) {
					acceleration = -9.8;
				} else {
					acceleration = emptyFieldCheck(accField.getText());
				}
				main.main(new String[0]);
				outputArea.setRows(main.count);
				outputArea.setText(main.reqdOutput);
				outputArea.setEnabled(false);
				
			}
		});
		btnNewButton.setBounds(337, 488, 249, 57);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("  REQUIRED:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_2.setBounds(565, 97, 101, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JCheckBox iniVReq = new JCheckBox("Initial Velocity");
		iniVReq.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		iniVReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniVboo = iniVReq.isSelected();
			}
		});
		iniVReq.setBounds(559, 129, 123, 23);
		frame.getContentPane().add(iniVReq);
		
		JCheckBox finVreq = new JCheckBox("Final Velocity");
		finVreq.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		finVreq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finVboo = finVreq.isSelected();
			}
		});
		finVreq.setBounds(559, 159, 123, 23);
		frame.getContentPane().add(finVreq);
		
		JCheckBox dtReq = new JCheckBox("Change in Time");
		dtReq.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		dtReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dTboo = dtReq.isSelected();
			}
		});
		dtReq.setBounds(559, 189, 123, 23);
		frame.getContentPane().add(dtReq);
		
		JCheckBox dyReq = new JCheckBox("Change in Y/Height");
		dyReq.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		dyReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dYboo = dyReq.isSelected();
			}
		});
		dyReq.setBounds(559, 219, 142, 23);
		frame.getContentPane().add(dyReq);
		
		JCheckBox daReq = new JCheckBox("Acceleration");
		daReq.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		daReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accBoo = daReq.isSelected();
			}
		});
		daReq.setBounds(559, 251, 107, 23);
		frame.getContentPane().add(daReq);
		
		
		
		/*while(main.reqdOutput.equals("")) {}
		setOutputText(main.reqdOutput);*/
	}

	public String getTextFieldText() {
		return ViField.getText();
	}
	public void setTextFieldText(String text) {
		ViField.setText(text);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
