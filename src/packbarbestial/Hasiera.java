package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
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
		frame.getContentPane().add(panel_goikoa);
		
		JPanel panel_erdikoa = new JPanel();
		frame.getContentPane().add(panel_erdikoa);
		panel_erdikoa.setLayout(new GridLayout(1, 9));
		
		JLabel hutsuneErdEzk = new JLabel("New label");
		panel_erdikoa.add(hutsuneErdEzk);
		
		JLabel zerukoAtea = new JLabel("New label");
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
		
		JLabel patada = new JLabel("New label");
		panel_erdikoa.add(patada);
		
		JLabel hutsuneErdEsk = new JLabel("New label");
		panel_erdikoa.add(hutsuneErdEsk);
		
		JPanel panel_behekoa= new JPanel();
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

}
