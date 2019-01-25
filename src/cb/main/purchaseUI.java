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
	private JLabel [][] lblSeats = new JLabel[4][4];
	private JLabel hangSelectedSeat;
	/**
	 * Create the frame.
	 */
	public purchaseUI(JFrame frame, Movie movie, String pTime) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				lblSeats[i][j] = new JLabel("");
			}
		}
		File tmpDir = new File(movie.image + pTime + ".txt");
		if(!tmpDir.exists()) {
			String fileName = movie.image + pTime + ".txt";
			try {
				PrintWriter writer = new PrintWriter(fileName, "UTF-8");
				for(int i = 0; i < 16; i++) { writer.println("0"); }
				writer.close();
			} 
			catch (UnsupportedEncodingException | FileNotFoundException e) { e.printStackTrace(); }
		}
		Scanner reader;
		try {
			reader = new Scanner(new File(movie.image + pTime + ".txt"));
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
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					int localI = i;
					int localJ = j;
					lblSeats[i][j].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if(selectedSeatRow != -1 && selectedSeatColumn != -1) {
								if(checkSeat(localI, localJ, selectedSeatRow, selectedSeatColumn, lblSeats[localI][localJ])) {
									selectedSeatRow = (localI);
									selectedSeatColumn = (localJ);
								}
							}
							else {
								if(checkSeat(localI, localJ, lblSeats[localI][localJ])) {
									selectedSeatRow = (localI);
									selectedSeatColumn = (localJ);
								}
							}
						}
					});
				}
			}
		    
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[0][1], -191, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, seatA, -91, SpringLayout.WEST, lblSeats[0][0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[0][1], 171, SpringLayout.WEST, contentPane);
			if(seats[0][0] == 0) {
				lblSeats[0][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[0][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[0][0]);
	
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[0][0], 0, SpringLayout.NORTH, lblSeats[0][0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[0][1], 6, SpringLayout.EAST, lblSeats[0][0]);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[0][0], -191, SpringLayout.SOUTH, contentPane);
			if(seats[0][1] == 0) {
				lblSeats[0][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[0][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[0][1]);
	
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[0][2], 0, SpringLayout.NORTH, lblSeats[0][0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[0][2], 6, SpringLayout.EAST, lblSeats[0][1]);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[0][2], -191, SpringLayout.SOUTH, contentPane);
			if(seats[0][2] == 0) {
				lblSeats[0][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[0][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[0][2]);
	
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[0][3], 0, SpringLayout.NORTH, lblSeats[0][0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[0][3], 0, SpringLayout.WEST, lblTime);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[0][3], -191, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[0][3], -355, SpringLayout.EAST, contentPane);
			if(seats[0][3] == 0) {
				lblSeats[0][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[0][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[0][3]);
	
			JLabel seatB = new JLabel("B");
			sl_contentPane.putConstraint(SpringLayout.NORTH, seatA, 29, SpringLayout.SOUTH, seatB);
			sl_contentPane.putConstraint(SpringLayout.WEST, seatB, 30, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, seatB, -579, SpringLayout.EAST, contentPane);
			seatB.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(seatB);
	
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[1][1], 6, SpringLayout.EAST, lblSeats[1][0]);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[1][1], 0, SpringLayout.SOUTH, lblSeats[1][0]);
			if(seats[1][1] == 0) {
				lblSeats[1][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[1][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[1][1]);
	
			
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[0][0], 8, SpringLayout.SOUTH, lblSeats[1][0]);
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[1][0], 91, SpringLayout.EAST, seatB);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[0][0], 0, SpringLayout.EAST, lblSeats[1][0]);
			if(seats[1][0] == 0) {
				lblSeats[1][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[1][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[1][0]);
	
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[1][2], 0, SpringLayout.NORTH, lblSeats[1][0]);
			if(seats[1][2] == 0) {
				lblSeats[1][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[1][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[1][2]);
	
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[1][3], -355, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[1][2], -5, SpringLayout.WEST, lblSeats[1][3]);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[1][3], 0, SpringLayout.NORTH, lblSeats[1][0]);
			if(seats[1][3] == 0) {
				lblSeats[1][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[1][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[1][3]);
	
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[2][3], 0, SpringLayout.WEST, lblTime);
			if(seats[2][3] == 0) {
				lblSeats[2][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[2][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[2][3]);
	
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[2][0], -284, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[2][3], 0, SpringLayout.NORTH, lblSeats[2][0]);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[1][0], 6, SpringLayout.SOUTH, lblSeats[2][0]);
			if(seats[2][0] == 0) {
				lblSeats[2][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[2][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[2][0]);
	
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[2][2], 0, SpringLayout.NORTH, lblSeats[2][0]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[2][2], -6, SpringLayout.WEST, lblSeats[2][3]);
			if(seats[2][2] == 0) {
				lblSeats[2][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[2][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[2][2]);
	
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[2][1], 0, SpringLayout.NORTH, lblSeats[2][0]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[2][1], -424, SpringLayout.EAST, contentPane);
			if(seats[2][1] == 0) {
				lblSeats[2][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[2][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[2][1]);
	
			JLabel seatC = new JLabel("C");
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[2][0], 130, SpringLayout.EAST, seatC);
			sl_contentPane.putConstraint(SpringLayout.NORTH, seatB, 16, SpringLayout.SOUTH, seatC);
			sl_contentPane.putConstraint(SpringLayout.WEST, seatC, 0, SpringLayout.WEST, lblNewLabel);
			seatC.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(seatC);
	
			sl_contentPane.putConstraint(SpringLayout.WEST, lblSeats[3][0], 0, SpringLayout.WEST, lblSeats[0][0]);
			if(seats[3][0] == 0) {
				lblSeats[3][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[3][0].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[3][0]);
	
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[3][1], -6, SpringLayout.NORTH, lblSeats[2][1]);
			sl_contentPane.putConstraint(SpringLayout.NORTH, lblSeats[3][0], 0, SpringLayout.NORTH, lblSeats[3][1]);
			if(seats[3][1] == 0) {
				lblSeats[3][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[3][1].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[3][1]);
	
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[3][2], -6, SpringLayout.NORTH, lblSeats[2][2]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[3][1], -6, SpringLayout.WEST, lblSeats[3][2]);
			if(seats[3][2] == 0) {
				lblSeats[3][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[3][2].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[3][2]);
	
			
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSeats[3][3], -6, SpringLayout.NORTH, lblSeats[2][3]);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[3][3], -355, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lblSeats[3][2], -5, SpringLayout.WEST, lblSeats[3][3]);
			if(seats[3][3] == 0) {
				lblSeats[3][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
			}
			else {
				lblSeats[3][3].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
			}
			contentPane.add(lblSeats[3][3]);
	
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
			
			
			
			cbTime.setSelectedItem(pTime.replace("-", ":"));
			JButton btnShow = new JButton("SHOW");
			btnShow.addActionListener(new ActionListener( ) {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						String time = cbTime.getSelectedItem().toString().replace(":", "-");
						File tmpDir = new File(movie.image + time + ".txt");
						if(!tmpDir.exists()) {
							String fileName = movie.image + time + ".txt";
							try {
								PrintWriter writer = new PrintWriter(fileName, "UTF-8");
								for(int i = 0; i < 16; i++) { writer.println("0"); }
								writer.close();
							} 
							catch (UnsupportedEncodingException e) { e.printStackTrace(); }
						}
						Scanner reader = new Scanner(new File(movie.image + time + ".txt"));
						for(int i = 0; i < 4; i++) {
							for(int j = 0; j < 4; j++) {
								seats[i][j] = Integer.parseInt(reader.nextLine());
							}
						}
						purchaseUI pUI = new purchaseUI(frame, movie, cbTime.getSelectedItem().toString().replace(":", "-"));
						pUI.setVisible(true);
						pUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						dispose();
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
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnPurchase, 0, SpringLayout.NORTH, lblSeats[2][3]);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnPurchase, -306, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPurchase, -246, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnPurchase, -22, SpringLayout.EAST, contentPane);
			btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int purchase = JOptionPane.showConfirmDialog(null, "Do you want to buy ticket for " + movie.title + " at " + cbTime, "Purchase", JOptionPane.YES_NO_OPTION);
					if(purchase == JOptionPane.YES_OPTION) {
						if (selectedSeatRow != -1 && selectedSeatColumn != -1) {
							seats[selectedSeatRow][selectedSeatColumn] = 1;
							lblSeats[selectedSeatRow][selectedSeatColumn].setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
							Purchase(movie, cbTicketType.getSelectedIndex(), cbTime.getSelectedItem(), selectedSeatRow,
									selectedSeatColumn);
						} else {
							JOptionPane error = new JOptionPane("You haven't selected any seat.", JOptionPane.ERROR_MESSAGE);
							JDialog dialog = error.createDialog("Failure");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
						}
					}
				}
			});
			contentPane.add(btnPurchase);
			this.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent e) {
			        frame.setVisible(true);
			        dispose();
			    }
			});
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public boolean checkSeat(int i, int j, JLabel thisLabel) {
		if(seats[i][j] == 0) {
			if(hangSelectedSeat == null) {
				hangSelectedSeat = thisLabel;
			}
			else {
				if(seats[i][j] == 0) {
					hangSelectedSeat.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
				}
				else {
					hangSelectedSeat.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
				}
				hangSelectedSeat = thisLabel;
			}
			thisLabel.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/selectedSeat.png")));
			return true; 
		}
		else { 
			JOptionPane error = new JOptionPane("This seat is occupied.", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = error.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			return false; 
		}
	}
	
	public boolean checkSeat(int i, int j, int x, int y, JLabel thisLabel) {
		if(seats[i][j] == 0) {
			if(hangSelectedSeat == null) {
				hangSelectedSeat = thisLabel;
			}
			else {
				if(seats[x][y] == 0) {
					hangSelectedSeat.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/emptySeat1.png")));
				}
				else {
					hangSelectedSeat.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/occupiedSeat.png")));
				}
				hangSelectedSeat = thisLabel;
			}
			thisLabel.setIcon(new ImageIcon(purchaseUI.class.getResource("/cb/main/selectedSeat.png")));
			return true; 
		}
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
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i != seatRow) {
						writer.println(seats[i][j]);
					} else {
						if (j != seatColumn) {
							writer.println(seats[i][j]);
						} else {
							writer.println(1);
							JOptionPane success = new JOptionPane("You have succesfully bought a ticket to " + m.title + " at " + ticketTime + ".", JOptionPane.INFORMATION_MESSAGE);
							JDialog dialog = success.createDialog("Purchase");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
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
