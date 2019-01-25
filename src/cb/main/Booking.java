package cb.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Booking extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 11, 650, 439);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JButton movBtn1 = new JButton("");
		movBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("diablo"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn1.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/diablo.jpg")));
		movBtn1.setBounds(50, 11, 105, 150);
		mainPanel.add(movBtn1);
		
		JButton movBtn3 = new JButton("");
		movBtn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("passage"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn3.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/passage.jpg")));
		movBtn3.setBounds(350, 11, 105, 150);
		mainPanel.add(movBtn3);
		
		JButton movBtn2 = new JButton("");
		movBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("dovlatov"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn2.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/dovlatov.jpg")));
		movBtn2.setBounds(200, 11, 105, 150);
		mainPanel.add(movBtn2);
		
		JButton movBtn4 = new JButton("");
		movBtn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("peachtopia"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn4.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/peachtopia.jpg")));
		movBtn4.setBounds(500, 11, 105, 150);
		mainPanel.add(movBtn4);
		
		JButton movBtn5 = new JButton("");
		movBtn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("sergio"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn5.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/sergio.jpg")));
		movBtn5.setBounds(50, 225, 105, 150);
		mainPanel.add(movBtn5);
		
		JButton movBtn6 = new JButton("");
		movBtn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("stormBoy"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn6.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/stormBoy.jpg")));
		movBtn6.setBounds(200, 225, 105, 150);
		mainPanel.add(movBtn6);
		
		JButton movBtn7 = new JButton("");
		movBtn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("szpieg"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn7.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/szpieg.jpg")));
		movBtn7.setBounds(350, 225, 105, 150);
		mainPanel.add(movBtn7);
		
		JButton movBtn8 = new JButton("");
		movBtn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ShowMovie(movie("zabawa"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn8.setIcon(new ImageIcon(Booking.class.getResource("/cb/main/zabawa.jpg")));
		movBtn8.setBounds(500, 225, 105, 150);
		mainPanel.add(movBtn8);
		
		
	}
	public Movie movie(String movieFile) throws FileNotFoundException {		
		Scanner reader = new Scanner(new File("" + movieFile + ".txt"));
		Movie m = new Movie();
		m.title = reader.nextLine();
		m.runTime = reader.nextLine();
		m.production = reader.nextLine();
		m.category = reader.nextLine();
		m.releaseDate = reader.nextLine();
		m.distrubution = reader.nextLine();
		m.director = reader.nextLine();
		m.cast = reader.nextLine();
		m.description = "";
		m.image = movieFile;
		while(reader.hasNextLine()) {
			m.description += reader.nextLine();
		}
		return m;
	}
	
	public void ShowMovie(Movie movie) {
		infoUI ifn = new infoUI(movie, this);
		this.setVisible(false);
		ifn.setVisible(true);
		ifn.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}

class Movie {
	String image, title, runTime, production, category, releaseDate, distrubution, director, cast, description;
}
