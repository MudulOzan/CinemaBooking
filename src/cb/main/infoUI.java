package cb.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class infoUI extends JFrame {

	private JPanel contentPane;

	public infoUI(Movie movie, JFrame frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setResizable(false);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(infoUI.class.getResource("/cb/main/" + movie.image + ".jpg")));
		sl_contentPane.putConstraint(SpringLayout.NORTH, image, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, image, 10, SpringLayout.WEST, contentPane);
		contentPane.add(image);
		
		JLabel lblOriginalTitle = new JLabel("Original Title:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOriginalTitle, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOriginalTitle, 5, SpringLayout.EAST, image);
		contentPane.add(lblOriginalTitle);
		
		JLabel lblRunTime = new JLabel("RunTime:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblRunTime, 5, SpringLayout.EAST, image);
		contentPane.add(lblRunTime);
		
		JLabel lblProduction = new JLabel("Production:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblProduction, 50, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblProduction, 5, SpringLayout.EAST, image);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblRunTime, -6, SpringLayout.NORTH, lblProduction);
		contentPane.add(lblProduction);
		
		JLabel lblCategory = new JLabel("Category:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCategory, 6, SpringLayout.SOUTH, lblProduction);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCategory, 5, SpringLayout.EAST, image);
		contentPane.add(lblCategory);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRunTime, -19, SpringLayout.EAST, lblReleaseDate);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblReleaseDate, 6, SpringLayout.SOUTH, lblCategory);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblReleaseDate, 5, SpringLayout.EAST, image);
		contentPane.add(lblReleaseDate);
		
		JLabel lblDistribution = new JLabel("Distribution:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDistribution, 6, SpringLayout.SOUTH, lblReleaseDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDistribution, 5, SpringLayout.EAST, image);
		contentPane.add(lblDistribution);
		
		JLabel lblDirectedBy = new JLabel("Directed By:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDirectedBy, 6, SpringLayout.SOUTH, lblDistribution);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDirectedBy, 6, SpringLayout.EAST, image);
		contentPane.add(lblDirectedBy);
		
		JLabel lblCast = new JLabel("Cast:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCast, 6, SpringLayout.SOUTH, lblDirectedBy);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCast, 6, SpringLayout.EAST, image);
		contentPane.add(lblCast);
		
		JTextPane description = new JTextPane();
		JScrollPane jspDescription = new JScrollPane(description);
		description.setEditable(false);
		description.setText(movie.description);
		sl_contentPane.putConstraint(SpringLayout.NORTH, jspDescription, 2, SpringLayout.SOUTH, lblCast);
		sl_contentPane.putConstraint(SpringLayout.WEST, jspDescription, 0, SpringLayout.WEST, image);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, jspDescription, 285, SpringLayout.SOUTH, lblCast);
		sl_contentPane.putConstraint(SpringLayout.EAST, jspDescription, -5, SpringLayout.EAST, contentPane);
		contentPane.add(jspDescription);
		
		JLabel title = new JLabel(movie.title);
		sl_contentPane.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, image);
		sl_contentPane.putConstraint(SpringLayout.WEST, title, 6, SpringLayout.EAST, lblOriginalTitle);
		contentPane.add(title);
		
		JLabel runTime = new JLabel(movie.runTime);
		sl_contentPane.putConstraint(SpringLayout.WEST, runTime, 1, SpringLayout.EAST, lblRunTime);
		contentPane.add(runTime);
		
		JLabel production = new JLabel(movie.production);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, runTime, -6, SpringLayout.NORTH, production);
		sl_contentPane.putConstraint(SpringLayout.WEST, production, 6, SpringLayout.EAST, lblProduction);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, production, 0, SpringLayout.SOUTH, lblProduction);
		contentPane.add(production);
		
		JLabel category = new JLabel(movie.category);
		sl_contentPane.putConstraint(SpringLayout.NORTH, category, 0, SpringLayout.NORTH, lblCategory);
		sl_contentPane.putConstraint(SpringLayout.WEST, category, 6, SpringLayout.EAST, lblCategory);
		contentPane.add(category);
		
		JLabel releaseDate = new JLabel(movie.releaseDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, releaseDate, 6, SpringLayout.EAST, lblReleaseDate);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, releaseDate, 0, SpringLayout.SOUTH, lblReleaseDate);
		contentPane.add(releaseDate);
		
		JLabel distribution = new JLabel(movie.distrubution);
		sl_contentPane.putConstraint(SpringLayout.WEST, distribution, 6, SpringLayout.EAST, lblDistribution);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, distribution, 0, SpringLayout.SOUTH, lblDistribution);
		contentPane.add(distribution);
		
		JLabel director = new JLabel(movie.director);
		sl_contentPane.putConstraint(SpringLayout.WEST, director, 6, SpringLayout.EAST, lblDirectedBy);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, director, 0, SpringLayout.SOUTH, lblDirectedBy);
		contentPane.add(director);
		
		JLabel cast = new JLabel(movie.cast);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cast, 0, SpringLayout.NORTH, lblCast);
		sl_contentPane.putConstraint(SpringLayout.WEST, cast, 6, SpringLayout.EAST, lblCast);
		contentPane.add(cast);
		
		JLabel btnBack = new JLabel("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		        frame.setVisible(true);
		        setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon(infoUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-fewer-details@2x.png")));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		JFrame infoFrame = this;
		JLabel btnPurchase = new JLabel("");
		btnPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				purchaseUI pUI = new purchaseUI(infoFrame, movie, "Adult", "12-00");
				setVisible(false);
				pUI.setVisible(true);
				pUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPurchase, 0, SpringLayout.NORTH, lblDirectedBy);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPurchase, -10, SpringLayout.EAST, contentPane);
		btnPurchase.setIcon(new ImageIcon(infoUI.class.getResource("/org/eclipse/jface/text/source/projection/images/collapsed@2x.png")));
		contentPane.add(btnPurchase);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
		        frame.setVisible(true);
		    }
		});
	}
}
