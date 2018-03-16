package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Hasiera {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hasiera window = new Hasiera();
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
	public Hasiera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(new GridLayout(3,1));
		
		JPanel panel_goikoa = new JPanel();
		panel_goikoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_goikoa);
		panel_goikoa.setLayout(new GridLayout(1, 3));
		
		JLabel barBestial = new JLabel("");
		try {
			URL url=new URL("https://i.imgur.com/F3xnPNi.png");
			Image image = ImageIO.read(url);
			barBestial.setIcon(new ImageIcon(image));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//barBestial.setIcon(new ImageIcon("F:\\WorkSpace_eclipse\\amarga\\resources\\barBestial---copia1.png"));
		barBestial.setHorizontalAlignment(JLabel.CENTER);
		barBestial.setHorizontalTextPosition(JLabel.CENTER);
		panel_goikoa.add(barBestial);
		
		JLabel titulu = new JLabel("New label");
		panel_goikoa.add(titulu);
		
		JLabel esLoQueHay = new JLabel("");
		esLoQueHay.setIcon(new ImageIcon("F:\\WorkSpace_eclipse\\amarga\\resources\\esloquehay---copia1.png"));
		esLoQueHay.setHorizontalAlignment(JLabel.CENTER);
		esLoQueHay.setHorizontalTextPosition(JLabel.CENTER);
		panel_goikoa.add(esLoQueHay);
		
		
		JPanel panel_erdikoa = new JPanel();
		panel_erdikoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_erdikoa);
		panel_erdikoa.setLayout(new GridLayout(1, 9));
		
		JLabel hutsuneErdEzk = new JLabel("New label");
		hutsuneErdEzk.setHorizontalAlignment(JLabel.CENTER);
		hutsuneErdEzk.setHorizontalTextPosition(JLabel.CENTER);
		panel_erdikoa.add(hutsuneErdEzk);
		
		JLabel zerukoAtea = new JLabel("");
		zerukoAtea.setIcon(new ImageIcon("F:\\WorkSpace_eclipse\\amarga\\resources\\puertacielo---copia1.png"));
		zerukoAtea.setHorizontalAlignment(JLabel.CENTER);
		zerukoAtea.setHorizontalTextPosition(JLabel.CENTER);
		panel_erdikoa.add(zerukoAtea);
		
		JLabel tablero1 = new JLabel("New label");
		panel_erdikoa.add(tablero1);
		
		JLabel tablero2 = new JLabel("New label");
		panel_erdikoa.add(tablero2);
		
		JLabel tablero3 = new JLabel("New label");
		panel_erdikoa.add(tablero3);
		
		JLabel tablero4 = new JLabel("New label");
		panel_erdikoa.add(tablero4);
		
		JLabel tablero5 = new JLabel("New label");
		panel_erdikoa.add(tablero5);
		
		JLabel patada = new JLabel("");
		patada.setIcon(new ImageIcon("F:\\WorkSpace_eclipse\\amarga\\resources\\patada---copia1.png"));
		patada.setHorizontalAlignment(JLabel.CENTER);
		patada.setHorizontalTextPosition(JLabel.CENTER);
		panel_erdikoa.add(patada);
		
		JLabel hutsuneErdEsk = new JLabel("New label");
		panel_erdikoa.add(hutsuneErdEsk);
		
		JPanel panel_behekoa= new JPanel();
		panel_behekoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_behekoa);
		panel_behekoa.setLayout(new GridLayout(1, 7));
		
		JLabel hutsuneBehEzk_1 = new JLabel("New label");
		panel_behekoa.add(hutsuneBehEzk_1);
		
		JLabel karta1 = new JLabel("New label");
		panel_behekoa.add(karta1);
		
		JLabel karta2 = new JLabel("New label");
		panel_behekoa.add(karta2);
		
		JLabel karta3 = new JLabel("New label");
		panel_behekoa.add(karta3);
		
		JLabel karta4 = new JLabel("New label");
		panel_behekoa.add(karta4);
		
		JLabel hutsuneBehEsk_1 = new JLabel("New label");
		panel_behekoa.add(hutsuneBehEsk_1);
		
		JLabel hartzeke = new JLabel("New label");
		panel_behekoa.add(hartzeke);
	
		frame.setBounds(100, 100, 919, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Fitxategia");
		menuBar.add(menu);
		
		JMenuItem mntmItxi = new JMenuItem("Itxi");
		mntmItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		menu.add(mntmItxi);
	}
	
	private void erdianJarri(){
		
	}

}
