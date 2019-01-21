package cb.main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Label;

public class Main {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 255, 204));

		shell.setSize(800, 550);
		shell.setText("Cinema Booking System");
		
		Button mov1 = new Button(shell, SWT.NONE);
		mov1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov1.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19038_small_2.jpg"));
		mov1.setBounds(35, 50, 105, 150);
		
		Button mov2 = new Button(shell, SWT.NONE);
		mov2.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov2.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19039_small_1.jpg"));
		mov2.setBounds(248, 50, 105, 150);
		
		Button mov3 = new Button(shell, SWT.NONE);
		mov3.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov3.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19040_small_1.jpg"));
		mov3.setBounds(446, 50, 105, 150);
		
		Button mov4 = new Button(shell, SWT.NONE);
		mov4.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov4.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19046_small_1.jpg"));
		mov4.setBounds(644, 50, 105, 150);
		
		Button mov5 = new Button(shell, SWT.NONE);
		mov5.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov5.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19047_small_1.jpg"));
		mov5.setBounds(35, 250, 105, 150);
		
		Button mov6 = new Button(shell, SWT.NONE);
		mov6.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov6.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19051_small_1.jpg"));
		mov6.setBounds(248, 250, 105, 150);
		
		Button mov7 = new Button(shell, SWT.NONE);
		mov7.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov7.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19052_small_1.jpg"));
		mov7.setBounds(446, 250, 105, 150);
		
		Button mov8 = new Button(shell, SWT.NONE);
		mov8.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mov1.setToolTipText("Double click to see details and booking.");
			}
		});
		mov8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.dispose();
			}
		});
		mov8.setImage(SWTResourceManager.getImage(Main.class, "/cb/main/film_19159_small_1.jpg"));
		mov8.setBounds(644, 250, 105, 150);
		
		Label lblFilm = new Label(shell, SWT.NONE);
		lblFilm.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblFilm.setAlignment(SWT.CENTER);
		lblFilm.setBounds(30, 216, 115, 15);
		lblFilm.setText("Cats and Peachtopia");
		
		Label lblSergioAndSergei = new Label(shell, SWT.NONE);
		lblSergioAndSergei.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblSergioAndSergei.setAlignment(SWT.CENTER);
		lblSergioAndSergei.setText("Sergio and Sergei");
		lblSergioAndSergei.setBounds(248, 216, 105, 15);
		
		Label lblZabawaZabawa = new Label(shell, SWT.NONE);
		lblZabawaZabawa.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblZabawaZabawa.setAlignment(SWT.CENTER);
		lblZabawaZabawa.setText("Zabawa zabawa");
		lblZabawaZabawa.setBounds(446, 216, 105, 15);
		
		Label lblStormBoy = new Label(shell, SWT.NONE);
		lblStormBoy.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblStormBoy.setAlignment(SWT.CENTER);
		lblStormBoy.setText("Storm Boy");
		lblStormBoy.setBounds(644, 216, 105, 15);
		
		Label lblDiabloWycigO = new Label(shell, SWT.NONE);
		lblDiabloWycigO.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblDiabloWycigO.setAlignment(SWT.CENTER);
		lblDiabloWycigO.setText("Diablo. Wy\u015Bcig o wszystko");
		lblDiabloWycigO.setBounds(10, 416, 153, 15);
		
		Label lblBirdsOfPassage = new Label(shell, SWT.NONE);
		lblBirdsOfPassage.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblBirdsOfPassage.setAlignment(SWT.CENTER);
		lblBirdsOfPassage.setText("Birds of Passage");
		lblBirdsOfPassage.setBounds(248, 416, 105, 15);
		
		Label lblTheSpyGone = new Label(shell, SWT.NONE);
		lblTheSpyGone.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblTheSpyGone.setAlignment(SWT.CENTER);
		lblTheSpyGone.setText("The Spy Gone North");
		lblTheSpyGone.setBounds(440, 416, 123, 15);
		
		Label lblDovlatov = new Label(shell, SWT.NONE);
		lblDovlatov.setBackground(SWTResourceManager.getColor(255, 255, 204));
		lblDovlatov.setAlignment(SWT.CENTER);
		lblDovlatov.setText("Dovlatov");
		lblDovlatov.setBounds(644, 416, 105, 15);

	}
}
