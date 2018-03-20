package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("unused")
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
		KopuruAukera.main();
		int i=1;
		while(i<=ListaJokalariak.getNireLista().getKop()){
			i++;
			DatuenSarrera.main();
		}
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(new GridLayout(3,1));
		
		JPanel panel_goikoa = new JPanel();
		panel_goikoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_goikoa);
		panel_goikoa.setLayout(new GridLayout(1, 3));
		
		JLabelPro barBestial = new JLabelPro("");
		barBestial.erdianJarri();
		barBestial.setIconURL("https://i.imgur.com/F3xnPNi.png");
		panel_goikoa.add(barBestial);
		
		JLabelPro titulu = new JLabelPro("");
		titulu.erdianJarri();
		titulu.setIconURL("https://i.imgur.com/1bpmanW.png");
		panel_goikoa.add(titulu);
		
		JLabelPro esLoQueHay = new JLabelPro("");
		esLoQueHay.erdianJarri();
		esLoQueHay.setIconURL("https://i.imgur.com/Ob4fbBg.png");		
		panel_goikoa.add(esLoQueHay);
		
		JPanel panel_erdikoa = new JPanel();
		panel_erdikoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_erdikoa);
		panel_erdikoa.setLayout(new GridLayout(1, 9));
		
		JLabelPro hutsuneErdEzk = new JLabelPro("");
		hutsuneErdEzk.erdianJarri();
		panel_erdikoa.add(hutsuneErdEzk);
		
		JLabelPro zerukoAtea = new JLabelPro("");
		zerukoAtea.setIconURL("https://i.imgur.com/ZxIaeus.png");
		zerukoAtea.erdianJarri();
		panel_erdikoa.add(zerukoAtea);
		
		JLabelPro tablero1 = new JLabelPro("KARTA1");
		panel_erdikoa.add(tablero1);
		
		JLabelPro tablero2 = new JLabelPro("KARTA2");
		panel_erdikoa.add(tablero2);
		
		JLabelPro tablero3 = new JLabelPro("KARTA3");
		panel_erdikoa.add(tablero3);
		
		JLabelPro tablero4 = new JLabelPro("KARTA4");
		panel_erdikoa.add(tablero4);
		
		JLabelPro tablero5 = new JLabelPro("KARTA5");
		panel_erdikoa.add(tablero5);
		
		JLabelPro patada = new JLabelPro("");
		patada.setIconURL("https://i.imgur.com/Sb87kRz.png");
		patada.erdianJarri();
		panel_erdikoa.add(patada);
		
		JLabelPro hutsuneErdEsk = new JLabelPro("");
		hutsuneErdEsk.erdianJarri();
		panel_erdikoa.add(hutsuneErdEsk);
		
		JPanel panel_behekoa= new JPanel();
		panel_behekoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_behekoa);
		panel_behekoa.setLayout(new GridLayout(1, 7));
		
		JLabelPro hutsuneBehEzk_1 = new JLabelPro("");
		hutsuneBehEzk_1.erdianJarri();
		panel_behekoa.add(hutsuneBehEzk_1);
		
		
		String[] kartaurl = new String[4];
		kartaurl = Mahaia.getnMahaia().mahaiaPrestatu();
		
		JLabelPro karta1 = new JLabelPro("");
		karta1.setIconURL(kartaurl[0]);
		karta1.erdianJarri();
		panel_behekoa.add(karta1);
		
		JLabelPro karta2 = new JLabelPro("");
		karta2.setIconURL(kartaurl[1]);
		karta2.erdianJarri();
		panel_behekoa.add(karta2);
		
		JLabelPro karta3 = new JLabelPro("");
		karta3.setIconURL(kartaurl[2]);
		karta3.erdianJarri();
		panel_behekoa.add(karta3);
		
		JLabelPro karta4 = new JLabelPro("");
		karta4.setIconURL(kartaurl[3]);
		karta4.erdianJarri();
		panel_behekoa.add(karta4);
		
		JLabelPro hutsuneBehEsk_1 = new JLabelPro("");
		hutsuneBehEsk_1.erdianJarri();
		panel_behekoa.add(hutsuneBehEsk_1);
		
		JLabelPro hartzeke = new JLabelPro("");
		hartzeke.erdianJarri();
		hartzeke.setIconURL("https://i.imgur.com/7rFbePP.png");
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
				frame.dispose();
			}
		});
		menu.add(mntmItxi);
	}

}


