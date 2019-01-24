package cb.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class purchaseUI extends JFrame {

	private JPanel contentPane;
	private int selectedSeatRow = 0;
	private int selectedSeatColumn = 0;
	private int [][] seats = new int[4][4];
	private JLabel [] lblSeats = new JLabel[16];
	/**
	 * Create the frame.
	 */
	public purchaseUI(Movie movie) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		for(int i = 0; i < 16; i++) {
			lblSeats[i] = new JLabel("");
		}
		Scanner reader;
		try {
			reader = new Scanner(new File(movie.image + ("12-00.txt")));
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					seats[i][j] = Integer.parseInt(reader.nextLine());
				}
			}
		
		
			JLabel lblNewLabel = new JLabel("Ticket Type:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 30, SpringLayout.WEST, contentPane);
			contentPane.add(lblNewLabel);
	
			JLabel lblTime = new JLabel("Time:");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblTime, 0, SpringLayout.NORTH, lblNewLabel);
			lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPane.add(lblTime);
	
			JLabel seatA = new JLabel("A");
			sl_contentPane.putConstraint(SpringLayout.WEST, seatA, 0, SpringLayout.WEST, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, seatA, -205, SpringLayout.SOUTH, contentPane);
			seatA.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(seatA);
	
			lblSeats[0].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(0,0)) {
						selectedSeatRow = 1;
						selectedSeatColumn = 1;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[1], -191, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, seatA, -91, SpringLayout.WEST, lblSeats[0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[1], 171, SpringLayout.WEST, contentPane);
			if(seats[0][0] == 0) {
				lblSeats[0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[0]);
	
			lblSeats[1].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(0,1)) {
						selectedSeatRow = 1;
						selectedSeatColumn = 2;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[0], 0, SpringLayout.NORTH, lblSeats[0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[1], 6, SpringLayout.EAST, lblSeats[0]);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[0], -191, SpringLayout.SOUTH, contentPane);
			if(seats[0][1] == 0) {
				lblSeats[1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[1]);
	
			lblSeats[2].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(0,2)) {
						selectedSeatRow = 1;
						selectedSeatColumn = 3;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[2], 0, SpringLayout.NORTH, lblSeats[0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[2], 6, SpringLayout.EAST, lblSeats[1]);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[2], -191, SpringLayout.SOUTH, contentPane);
			if(seats[0][2] == 0) {
				lblSeats[2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[2]);
	
			lblSeats[3].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(0,3)) {
						selectedSeatRow = 1;
						selectedSeatColumn = 4;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[3], 0, SpringLayout.NORTH, lblSeats[0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[3], 0, SpringLayout.WEST, lblTime);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[3], -191, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[3], -355, SpringLayout.EAST, contentPane);
			if(seats[0][3] == 0) {
				lblSeats[3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[3]);
	
			JLabel seatB = new JLabel("B");
			sl_contentPane.putConstraint(SpringLayout.NORTH, seatA, 29, SpringLayout.SOUTH, seatB);
			sl_contentPane.putConstraint(SpringLayout.WEST, seatB, 30, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, seatB, -579, SpringLayout.EAST, contentPane);
			seatB.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(seatB);
	
			lblSeats[4].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(1,0)) {
						selectedSeatRow = 2;
						selectedSeatColumn = 1;
					}
				}
			});
			
			lblSeats[5].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(1,1)) {
						selectedSeatRow = 2;
						selectedSeatColumn = 2;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[5], 6, SpringLayout.EAST, lblSeats[4]);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[5], 0, SpringLayout.SOUTH, lblSeats[4]);
			if(seats[1][1] == 0) {
				lblSeats[5].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[5].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[5]);
	
			
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[0], 8, SpringLayout.SOUTH, lblSeats[4]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[4], 91, SpringLayout.EAST, seatB);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[0], 0, SpringLayout.EAST, lblSeats[4]);
			if(seats[1][0] == 0) {
				lblSeats[4].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[4].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[4]);
	
			lblSeats[6].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(1,2)) {
						selectedSeatRow = 2;
						selectedSeatColumn = 3;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[6], 0, SpringLayout.NORTH, lblSeats[4]);
			if(seats[1][2] == 0) {
				lblSeats[6].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[6].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[6]);
	
			lblSeats[7].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(1,3)) {
						selectedSeatRow = 2;
						selectedSeatColumn = 4;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[7], -355, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[6], -5, SpringLayout.WEST, lblSeats[7]);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[7], 0, SpringLayout.NORTH, lblSeats[4]);
			if(seats[1][3] == 0) {
				lblSeats[7].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[7].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[7]);
	
			lblSeats[11].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(2,3)) {
						selectedSeatRow = 3;
						selectedSeatColumn = 4;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[11], 0, SpringLayout.WEST, lblTime);
			if(seats[2][3] == 0) {
				lblSeats[11].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[11].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[11]);
	
			lblSeats[8].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(2,0)) {
						selectedSeatRow = 3;
						selectedSeatColumn = 1;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[8], -284, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[11], 0, SpringLayout.NORTH, lblSeats[8]);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[4], 6, SpringLayout.SOUTH, lblSeats[8]);
			if(seats[2][0] == 0) {
				lblSeats[8].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[8].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[8]);
	
			lblSeats[10].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(2,2)) {
						selectedSeatRow = 3;
						selectedSeatColumn = 3;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[10], 0, SpringLayout.NORTH, lblSeats[8]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[10], -6, SpringLayout.WEST, lblSeats[11]);
			if(seats[2][2] == 0) {
				lblSeats[10].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[10].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[10]);
	
			lblSeats[9].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(2,1)) {
						selectedSeatRow = 3;
						selectedSeatColumn = 2;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[9], 0, SpringLayout.NORTH, lblSeats[8]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[9], -424, SpringLayout.EAST, contentPane);
			if(seats[2][1] == 0) {
				lblSeats[9].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[9].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[9]);
	
			JLabel seatC = new JLabel("C");
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[8], 130, SpringLayout.EAST, seatC);
			sl_contentPane.putConstraint(SpringLayout.NORTH, seatB, 16, SpringLayout.SOUTH, seatC);
			sl_contentPane.putConstraint(SpringLayout.WEST, seatC, 0, SpringLayout.WEST, lblNewLabel);
			seatC.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(seatC);
	
			lblSeats[12].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(3,0)) {
						selectedSeatRow = 4;
						selectedSeatColumn = 1;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[12], 0, SpringLayout.WEST, lblSeats[0]);
			if(seats[3][0] == 0) {
				lblSeats[12].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[12].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[12]);
	
			lblSeats[13].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(3,1)) {
						selectedSeatRow = 4;
						selectedSeatColumn = 2;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[13], -6, SpringLayout.NORTH, lblSeats[9]);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[12], 0, SpringLayout.NORTH, lblSeats[13]);
			if(seats[3][1] == 0) {
				lblSeats[13].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[13].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[13]);
	
			lblSeats[14].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(3,2)) {
						selectedSeatRow = 4;
						selectedSeatColumn = 3;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[14], -6, SpringLayout.NORTH, lblSeats[10]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[13], -6, SpringLayout.WEST, lblSeats[14]);
			if(seats[3][2] == 0) {
				lblSeats[14].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[14].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[14]);
	
			lblSeats[15].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(checkSeat(3,3)) {
						selectedSeatRow = 4;
						selectedSeatColumn = 4;
					}
				}
			});
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[15], -6, SpringLayout.NORTH, lblSeats[11]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[15], -355, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[14], -5, SpringLayout.WEST, lblSeats[15]);
			if(seats[3][3] == 0) {
				lblSeats[15].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[15].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[15]);
	
			JLabel lblD = new JLabel("D");
			sl_contentPane.putConstraint(SpringLayout.NORTH, seatC, 16, SpringLayout.SOUTH, lblD);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblD, 29, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblD, 73, SpringLayout.SOUTH, lblNewLabel);
			lblD.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(lblD);
	
			JComboBox cbTicketType = new JComboBox();
			sl_contentPane.putConstraint(SpringLayout.WEST, lblTime, 18, SpringLayout.EAST, cbTicketType);
			sl_contentPane.putConstraint(SpringLayout.NORTH, cbTicketType, 10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, cbTicketType, 6, SpringLayout.EAST, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, cbTicketType, 0, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.EAST, cbTicketType, 126, SpringLayout.EAST, lblNewLabel);
			cbTicketType.addItem("Adult");
			cbTicketType.addItem("Student");
			contentPane.add(cbTicketType);
	
			JComboBox cbTime = new JComboBox();
			sl_contentPane.putConstraint(SpringLayout.NORTH, cbTime, 10, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, cbTime, 6, SpringLayout.EAST, lblTime);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, cbTime, 30, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, cbTime, 126, SpringLayout.EAST, lblTime);
			cbTime.addItem("12:00");
			cbTime.addItem("14:00");
			cbTime.addItem("16:30");
			cbTime.addItem("18:30");
			contentPane.add(cbTime);
	
			JButton btnShow = new JButton("SHOW");
			btnShow.addActionListener(new ActionListener( ) {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						Scanner reader = new Scanner(new File(movie.image + cbTime.getSelectedItem().toString().replace(":", "-")));
						for(int i = 0; i < 4; i++) {
							for(int j = 0; j < 4; j++) {
								seats[i][j] = Integer.parseInt(reader.nextLine());
							}
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}			
			});
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnShow, -1, SpringLayout.NORTH, cbTicketType);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnShow, 10, SpringLayout.EAST, cbTime);
			contentPane.add(btnShow);
	
			JButton btnPurchase = new JButton("PURCHASE");
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnPurchase, 0, SpringLayout.NORTH, lblSeats[11]);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnPurchase, -306, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPurchase, -246, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnPurchase, -22, SpringLayout.EAST, contentPane);
			btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (selectedSeatRow != 0 && selectedSeatColumn != 0) {
						Purchase(movie, cbTicketType.getSelectedIndex(), cbTime.getSelectedItem(), selectedSeatRow,
								selectedSeatColumn);
					} else {
						JOptionPane error = new JOptionPane("You haven't selected any seat.", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = error.createDialog("Failure");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
				}
			});
			contentPane.add(btnPurchase);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public boolean checkSeat(int i, int j) {
		if(seats[i][j] == 0) { return true; }
		else { 
			JOptionPane error = new JOptionPane("This seat is occupied.", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = error.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			return false; 
		}
	}
	
	public void Purchase(Movie m, int ticketType, Object ticketTime, int seatRow, int seatColumn) {
		String time = ticketTime.toString().replace(":", "-");
		System.out.println(time);
		String fileName = m.image + time + ".txt";
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			for (int i = 1; i < 5; i++) {
				for (int j = 1; j < 5; j++) {
					if (i != seatRow) {
						writer.println(seats[i-1][j-1]);
					} else {
						if (j != seatColumn) {
							writer.println(seats[i-1][j-1]);
						} else {
							writer.println(1);
						}
					}
				}
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
