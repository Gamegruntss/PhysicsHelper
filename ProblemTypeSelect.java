import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProblemTypeSelect {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProblemTypeSelect window = new ProblemTypeSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProblemTypeSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 958, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 942, 568);
		frame.getContentPane().add(contentPane);
		
		JLabel title = new JLabel("Welcome to the Physics Homework Helper!");
		title.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		title.setBounds(190, 11, 565, 62);
		contentPane.add(title);
		
		JLabel subheading = new JLabel("What type of physics problem are you trying to solve?");
		subheading.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		subheading.setBounds(250, 145, 422, 23);
		contentPane.add(subheading);
		
		JButton FreeFallButton = new JButton("Freefall");
		FreeFallButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		FreeFallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FFGUI gui = new FFGUI();
				gui.setVisible(true);
				
			}
		});
		FreeFallButton.setBounds(490, 227, 144, 45);
		contentPane.add(FreeFallButton);
		
		JButton ProjectileButton = new JButton("Projectile");
		ProjectileButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		ProjectileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ProjectileGUI projGUI = new ProjectileGUI();
				projGUI.setVisible(true);
			}
		});
		ProjectileButton.setBounds(490, 323, 144, 45);
		contentPane.add(ProjectileButton);
		
		JButton StaticsButton = new JButton("Statics");
		StaticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StaticsGUI s = new StaticsGUI();
				s.setVisible(true);
			}
		});
		StaticsButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		StaticsButton.setBounds(269, 323, 144, 45);
		contentPane.add(StaticsButton);
		
		JButton DynamicsButton = new JButton("Dynamics");
		DynamicsButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		DynamicsButton.setBounds(269, 227, 144, 45);
		contentPane.add(DynamicsButton);
	}
}
