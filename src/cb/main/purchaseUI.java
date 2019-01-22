package cb.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class purchaseUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchaseUI frame = new purchaseUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public purchaseUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Ticket Type:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 30, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Block:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTime = new JLabel("Time:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTime, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTime, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblTime);
		
		JLabel lblA = new JLabel("A");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblA, -27, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblB, -67, SpringLayout.NORTH, lblA);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblA, 0, SpringLayout.EAST, lblB);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblB, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblB);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 381, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 135, SpringLayout.EAST, lblA);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, lblA);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -459, SpringLayout.EAST, contentPane);
		lblNewLabel_2.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 381, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 170, SpringLayout.EAST, lblA);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblA);
		lblNewLabel_3.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 381, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 205, SpringLayout.EAST, lblA);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, lblA);
		label.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 381, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, lblA);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, -355, SpringLayout.EAST, contentPane);
		label_1.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.EAST, label_2, -222, SpringLayout.EAST, contentPane);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_3, -228, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 19, SpringLayout.SOUTH, label_3);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.EAST, label_3, -43, SpringLayout.WEST, label_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 213, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_4, -133, SpringLayout.EAST, contentPane);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_5, -265, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_5, -295, SpringLayout.EAST, contentPane);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_6, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_6, -191, SpringLayout.EAST, contentPane);
		contentPane.add(label_6);
	}
}
