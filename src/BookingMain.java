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
import java.net.URL;
import java.util.Scanner;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class BookingMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingMain frame = new BookingMain();
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
	public BookingMain() {
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
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn1.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/diablo.jpg")));
		movBtn1.setBounds(50, 11, 105, 150);
		mainPanel.add(movBtn1);
		
		JButton movBtn3 = new JButton("");
		movBtn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn3.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/passage.jpg")));
		movBtn3.setBounds(350, 11, 105, 150);
		mainPanel.add(movBtn3);
		
		JButton movBtn2 = new JButton("");
		movBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn2.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/dovlatov.jpg")));
		movBtn2.setBounds(200, 11, 105, 150);
		mainPanel.add(movBtn2);
		
		JButton movBtn4 = new JButton("");
		movBtn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn4.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/peachtopia.jpg")));
		movBtn4.setBounds(500, 11, 105, 150);
		mainPanel.add(movBtn4);
		
		JButton movBtn5 = new JButton("");
		movBtn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn5.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/sergio.jpg")));
		movBtn5.setBounds(50, 225, 105, 150);
		mainPanel.add(movBtn5);
		
		JButton movBtn6 = new JButton("");
		movBtn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
				try {
					ShowMovie(movie("\\stormBoy.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		movBtn6.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/stormBoy.jpg")));
		movBtn6.setBounds(200, 225, 105, 150);
		mainPanel.add(movBtn6);
		
		JButton movBtn7 = new JButton("");
		movBtn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn7.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/szpieg.jpg")));
		movBtn7.setBounds(350, 225, 105, 150);
		mainPanel.add(movBtn7);
		
		JButton movBtn8 = new JButton("");
		movBtn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel.removeAll();
				contentPane.remove(mainPanel);
				contentPane.repaint();
			}
		});
		movBtn8.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/zabawa.jpg")));
		movBtn8.setBounds(500, 225, 105, 150);
		mainPanel.add(movBtn8);
		
		
	}
	public Movie movie(String movieFile) throws FileNotFoundException {		
		String filePath = System.getProperty("user.dir") + movieFile;
		System.out.println(new File("stormBoy.txt").getAbsolutePath());

		Scanner reader = new Scanner(new File("stormBoy.txt").getAbsoluteFile());
		Movie m = new Movie();
		m.title = reader.nextLine();
		m.runTime = reader.nextLine();
		m.production = reader.nextLine();
		m.category = reader.nextLine();
		m.releaseDate = reader.nextLine();
		m.distrubution = reader.nextLine();
		m.director = reader.nextLine();
		m.cast = reader.nextLine();
		return m;
	}
	
	public void ShowMovie(Movie movie) {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(10, 11, 650, 439);
		contentPane.add(infoPanel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BookingMain.class.getResource("/cb/main/stormBoy.jpg")));
		label.setBounds(10, 11, 105, 150);
		infoPanel.add(label);
		
		JLabel lblTitle = new JLabel("Original Title: " + movie.title);
		lblTitle.setForeground(new Color(102, 102, 255));
		lblTitle.setToolTipText("");
		lblTitle.setBounds(138, 25, 502, 14);
		infoPanel.add(lblTitle);
		
		JLabel lblRuntime = new JLabel("Runtime: " + movie.runTime);
		lblRuntime.setHorizontalAlignment(SwingConstants.LEFT);
		lblRuntime.setForeground(new Color(102, 102, 204));
		lblRuntime.setToolTipText("");
		lblRuntime.setBounds(138, 38, 502, 14);
		infoPanel.add(lblRuntime);
		
		JLabel lblProduction = new JLabel("Production:");
		lblProduction.setForeground(new Color(102, 102, 204));
		lblProduction.setToolTipText("");
		lblProduction.setBounds(138, 50, 502, 14);
		infoPanel.add(lblProduction);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setToolTipText("");
		lblCategory.setForeground(new Color(102, 102, 204));
		lblCategory.setBounds(138, 63, 502, 14);
		infoPanel.add(lblCategory);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setToolTipText("");
		lblReleaseDate.setForeground(new Color(102, 102, 204));
		lblReleaseDate.setBounds(138, 75, 502, 14);
		infoPanel.add(lblReleaseDate);
		
		JLabel lblDistribution = new JLabel("Distribution:");
		lblDistribution.setToolTipText("");
		lblDistribution.setForeground(new Color(102, 102, 204));
		lblDistribution.setBounds(138, 86, 502, 14);
		infoPanel.add(lblDistribution);
		
		JLabel lblDirectedBy = new JLabel("Directed by:");
		lblDirectedBy.setToolTipText("");
		lblDirectedBy.setForeground(new Color(102, 102, 204));
		lblDirectedBy.setBounds(138, 111, 502, 14);
		infoPanel.add(lblDirectedBy);
		
		JLabel lblCast = new JLabel("Cast:");
		lblCast.setToolTipText("");
		lblCast.setForeground(new Color(102, 102, 204));
		lblCast.setBounds(138, 129, 502, 14);
		infoPanel.add(lblCast);
		
		JTextPane description = new JTextPane();
		description.setEditable(false);
		description.setBounds(10, 172, 630, 256);
		infoPanel.add(description);
	}
}

class Movie {
	String title, runTime, production, category, releaseDate, distrubution, director, cast;
}
