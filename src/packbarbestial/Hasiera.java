package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import java.awt.event.WindowAdapter;

@SuppressWarnings("unused")
public class Hasiera {

	private JFrame frame;
	private Jokoa j=Jokoa.getnJokoa();

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
//		int i=0;
		DatuenSarrera.main();
//		System.out.println(ListaJokalariazk.getNireLista().getKop());
//		while(i<ListaJokalariak.getNireLista().getKop()){
//			DatuenSarrera.main();
//			i++;
//			System.out.println(i);
//		}
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int erantzuna=JOptionPane.showConfirmDialog(frame, "Ziur irten nahi zarela?","Irteera",JOptionPane.INFORMATION_MESSAGE);
				if(erantzuna==JOptionPane.YES_OPTION) System.exit(0);
				else if((erantzuna==JOptionPane.NO_OPTION) || (erantzuna==JOptionPane.CANCEL_OPTION)) frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
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
		kartaurl = j.mahaiaPrestatu();
		
		JButtonPro karta1 = new JButtonPro("");
		karta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Karta k=j.bota(1);
				karta1.setIcon(null);
				j.gehituTablerora(k);
				int pos=j.getTableroKop();
				String non="tablero"+String.valueOf(pos);
				switch(pos){
				case 1:
					tablero1.setIconURL(j.getUrl(k.getIndarra()));
					break;
				case 2:
					tablero2.setIconURL(j.getUrl(k.getIndarra()));
					break;
				case 3:
					tablero3.setIconURL(j.getUrl(k.getIndarra()));
					break;
				case 4:
					tablero4.setIconURL(j.getUrl(k.getIndarra()));
					break;
				case 5:
					tablero5.setIconURL(j.getUrl(k.getIndarra()));
					break;
				}
//				tablero1.setIconURL(KartenBilera.getnKartenBilera().getURL(k.getIndarra(), ListaJokalariak.getNireLista().jokLortu(1).getKolore()));
				try{
					k.egikaritu();
				}catch(NullPointerException x){
					JOptionPane.showMessageDialog(frame, "Ez duzu karta berria hartu!");
				}
				
			}
		});
		karta1.setIconURL(kartaurl[0]);
		panel_behekoa.add(karta1);
		karta1.erdianJarri();
		
		JButtonPro karta2 = new JButtonPro("");
		karta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Karta k=j.bota(2);
				karta2.setIcon(null);
			}
		});
		karta2.setIconURL(kartaurl[1]);
		karta2.erdianJarri();
		panel_behekoa.add(karta2);
		
		JButtonPro karta3 = new JButtonPro("");
		karta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Karta k=j.bota(3);
				karta3.setIcon(null);
			}
		});
		karta3.setIconURL(kartaurl[2]);
		karta3.erdianJarri();
		panel_behekoa.add(karta3);
		
		JButtonPro karta4 = new JButtonPro("");
		karta4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Karta k=j.bota(4);
				karta4.setIcon(null);
			}
		});
		karta4.setIconURL(kartaurl[3]);
		karta4.erdianJarri();
		panel_behekoa.add(karta4);
		
		JLabelPro hutsuneBehEsk_1 = new JLabelPro("");
		hutsuneBehEsk_1.erdianJarri();
		panel_behekoa.add(hutsuneBehEsk_1);
		
		JButtonPro hartzeke = new JButtonPro("");
		hartzeke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] ondo=j.hartu();
				if(ondo[0]==0) JOptionPane.showMessageDialog(frame, "Jada 4 karta dituzu eskuan!");
				else if(ondo[0]==2) JOptionPane.showMessageDialog(frame, "Ez duzu karta berria hartu!");
				else{
					int posizioa=ondo[1];
					int indarra=ondo[2];
					String url=kokatu(indarra);
					switch(posizioa){
					case 0:
						karta1.setIconURL(url);
						break;
					case 1:
						karta2.setIconURL(url);
						break;
					case 2:
						karta3.setIconURL(url);
						break;
					case 3:
						karta4.setIconURL(url);
						break;
					}
				}
			}
		});
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
	private String kokatu(int indarra){
		return j.getUrl(indarra);
	}
	
	private void irudiaIpini(JLabelPro tablero,String url){
		tablero.setIconURL(url);
	}

}


