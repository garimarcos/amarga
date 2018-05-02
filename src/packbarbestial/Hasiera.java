package packbarbestial;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Hasiera extends JFrame implements Observer{
	
	private Jokoa j=Jokoa.getnJokoa();

	private JFrame frame;
	
	private JLabelPro tablero1;
	private JLabelPro tablero2;
	private JLabelPro tablero3;
	private JLabelPro tablero4;
	private JLabelPro tablero5;
	
	private JButtonPro karta1;
	private JButtonPro karta2;
	private JButtonPro karta3;
	private JButtonPro karta4;
	private JButtonPro hartzeke;
	private JButtonPro titulu;
	
	private boolean hasiera = true;
	private boolean botaOrd = false;
	private boolean botaJok = true;
	private JPanel panelComboBox;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hasiera window = new Hasiera();
					window.frame.setVisible(true);
					//nHasiera.frame.setVisible(true);
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
		j.addObserver(this);
		initialize();
	}
	
//	public static Hasiera getnHasiera(){
//		return nHasiera;
//	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		KopuruAukera.main();
//		int i=0;
		DatuenSarrera.main(null);
//		System.out.println(ListaJokalariazk.getNireLista().getKop());
//		while(i<ListaJokalariak.getNireLista().getKop()){
//			DatuenSarrera.main();
//			i++;
//			System.out.println(i);
//		}
		j.ordenagailuaSortu();
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
		barBestial.setIcon(new ImageIcon("img/barBestial-resize.png"));
		//barBestial.setIconURL("https://i.imgur.com/F3xnPNi.png");
		
		panel_goikoa.add(barBestial);
		
		titulu = new JButtonPro("");
		titulu.addActionListener(new GertaeraKudeatzailea());
		titulu.erdianJarri();
		titulu.setIcon(new ImageIcon("img/logo-resize.png"));
		//titulu.setIconURL("https://i.imgur.com/1bpmanW.png");
		panel_goikoa.add(titulu);
		
		JLabelPro esLoQueHay = new JLabelPro("");
		esLoQueHay.erdianJarri();
		esLoQueHay.setIcon(new ImageIcon("img/esLoQueHay-resize.png"));
		//esLoQueHay.setIconURL("https://i.imgur.com/Ob4fbBg.png");		
		panel_goikoa.add(esLoQueHay);
		
		JPanel panel_erdikoa = new JPanel();
		panel_erdikoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_erdikoa);
		panel_erdikoa.setLayout(new GridLayout(1, 9));
		
		JLabelPro hutsuneErdEzk = new JLabelPro("");
		hutsuneErdEzk.erdianJarri();
		panel_erdikoa.add(hutsuneErdEzk);
		
		JLabelPro zerukoAtea = new JLabelPro("");
		//zerukoAtea.setIconURL("https://i.imgur.com/ZxIaeus.png");
		zerukoAtea.setIcon(new ImageIcon("img/puertaCielo-resize.png"));
		zerukoAtea.erdianJarri();
		panel_erdikoa.add(zerukoAtea);
		
		tablero1 = new JLabelPro("KARTA1");
		panel_erdikoa.add(tablero1);
		
		tablero2 = new JLabelPro("KARTA2");
		panel_erdikoa.add(tablero2);
		
		tablero3 = new JLabelPro("KARTA3");
		panel_erdikoa.add(tablero3);
		
		tablero4 = new JLabelPro("KARTA4");
		panel_erdikoa.add(tablero4);
		
		tablero5 = new JLabelPro("KARTA5");
		panel_erdikoa.add(tablero5);
		
		JLabelPro patada = new JLabelPro("");
		//patada.setIconURL("https://i.imgur.com/Sb87kRz.png");
		patada.setIcon(new ImageIcon("img/patada-resize.png"));
		patada.erdianJarri();
		panel_erdikoa.add(patada);
		
		JLabelPro hutsuneErdEsk = new JLabelPro("");
		hutsuneErdEsk.erdianJarri();
		panel_erdikoa.add(hutsuneErdEsk);
		
		JPanel panel_behekoa= new JPanel();
		panel_behekoa.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_behekoa);
		panel_behekoa.setLayout(new GridLayout(1, 7));
		
		
		String[] kartaurl = new String[4];
		kartaurl = j.mahaiaPrestatu();
		
		karta1 = new JButtonPro("");
		karta1.addActionListener(new GertaeraKudeatzailea());
		
		panelComboBox = new JPanel();
		panelComboBox.setBackground(Color.WHITE);
		panel_behekoa.add(panelComboBox);
		panelComboBox.setLayout(new GridLayout(1, 0, 0, 0));
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String animalia=(String)comboBox.getSelectedItem();
				switch(animalia){
				case "Mofeta":
					j.esleituKameleoi(1);
					break;
				case "Loro":
					j.esleituKameleoi(2);
					break;
				case "Kanguro":
					j.esleituKameleoi(3);
					break;
				case "Tximino":
					j.esleituKameleoi(4);
					break;
				case "Foka":
					j.esleituKameleoi(6);
					break;
				case "Zebra":
					j.esleituKameleoi(7);
					break;
				case "Jirafa":
					j.esleituKameleoi(8);
					break;
				case "Sugea":
					j.esleituKameleoi(9);
					break;
				case "Krokodilo":
					j.esleituKameleoi(10);
					break;
				case "Hipopotamo":
					j.esleituKameleoi(11);
					break;
				case "Lehoi":
					j.esleituKameleoi(12);
					break;
				}
				panelComboBox.setVisible(false);
			}
		});
		panelComboBox.add(comboBox);
		
		comboBox.addItem("Mofeta");
		comboBox.addItem("Loro");
		comboBox.addItem("Kanguro");
		comboBox.addItem("Tximino");
		comboBox.addItem("Foka");
		comboBox.addItem("Zebra");
		comboBox.addItem("Jirafa");
		comboBox.addItem("Sugea");
		comboBox.addItem("Krokodilo");
		comboBox.addItem("Hipopotamo");
		comboBox.addItem("Lehoi");
		
		panelComboBox.setVisible(false);
		
		//karta1.setIconURL(kartaurl[0]);
		karta1.setIcon(new ImageIcon(kartaurl[0]));
		panel_behekoa.add(karta1);
		karta1.erdianJarri();
		
		karta2 = new JButtonPro("");
		karta2.addActionListener(new GertaeraKudeatzailea());
		//karta2.setIconURL(kartaurl[1]);
		karta2.setIcon(new ImageIcon(kartaurl[1]));
		karta2.erdianJarri();
		panel_behekoa.add(karta2);
		
		karta3 = new JButtonPro("");
		karta3.addActionListener(new GertaeraKudeatzailea());
		//karta3.setIconURL(kartaurl[2]);
		karta3.setIcon(new ImageIcon(kartaurl[2]));
		karta3.erdianJarri();
		panel_behekoa.add(karta3);
		
		karta4 = new JButtonPro("");
		karta4.addActionListener(new GertaeraKudeatzailea());
		//karta4.setIconURL(kartaurl[3]);
		karta4.setIcon(new ImageIcon(kartaurl[3]));
		karta4.erdianJarri();
		panel_behekoa.add(karta4);
		
		JLabelPro hutsuneBehEsk_1 = new JLabelPro("");
		hutsuneBehEsk_1.erdianJarri();
		panel_behekoa.add(hutsuneBehEsk_1);
		
		hartzeke = new JButtonPro("");
		hartzeke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] ondo=j.hartu();
				//System.out.println(ondo[0]);
				if(ondo[0]==3) JOptionPane.showMessageDialog(frame, "Mazoa hutsik dago");
				else if(ondo[0]==0) JOptionPane.showMessageDialog(frame, "Jada 4 karta dituzu eskuan!");
				else if(ondo[0]==2) JOptionPane.showMessageDialog(frame, "Ez duzu karta berria hartu!");
				else{
					int posizioa=ondo[1];
					int indarra=ondo[2];
					String url=kokatu(indarra);
					switch(posizioa){
					case 0:
						karta1.setIcon(new ImageIcon(url));
						break;
					case 1:
						karta2.setIcon(new ImageIcon(url));
						break;
					case 2:
						karta3.setIcon(new ImageIcon(url));
						break;
					case 3:
						karta4.setIcon(new ImageIcon(url));
						break;
					}
				}
			}
		});
		hartzeke.erdianJarri();
		hartzeke.setIcon(new ImageIcon("img/mazo-resize.png"));
		//hartzeke.setIconURL("https://i.imgur.com/7rFbePP.png");
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
		return j.getUrl(indarra,1);
	}
	
	public class GertaeraKudeatzailea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int k=-8;
			if(e.getSource().equals(karta1)){
				if(botaJok){
					k=j.bota(1);		
					
					if(k!=0 && k!=-1){
						karta1.setIcon(null);
						botaJok=false;
						botaOrd=true;
					}
				}
				
			}
			else if(e.getSource().equals(karta2)){
				if(botaJok){
					k=j.bota(2);		
					
					if(k!=0 && k!=-1){
						karta2.setIcon(null);
						botaJok=false;
						botaOrd=true;
					}
				}
				
			}
			else if(e.getSource().equals(karta3)){
				if(botaJok){
					k=j.bota(3);		
					
					if(k!=0 && k!=-1){
						karta3.setIcon(null);
						botaJok=false;
						botaOrd=true;
					}
				}
				
			}
			else if(e.getSource().equals(karta4)){
				if(botaJok){
					k=j.bota(4);		
					
					if(k!=0 && k!=-1){
						karta4.setIcon(null);
						botaJok=false;
						botaOrd=true;
					}
				}
				
			}
			else if(e.getSource().equals(titulu)){
				if(botaOrd){
					k=j.botaOrdenagailua();
					int pos=j.getTableroKop();
					tableroanKartaIpini(k, pos,2);
					//j.animaladakGauzatu(k,2);
					
					if(k!=0 && k!=-1){
						botaOrd=false;
						botaJok=true;
					}
				}else k=-8;
			}
			try{
				if(k==0) JOptionPane.showMessageDialog(frame, "Hutsik!");
				if(k==-1) JOptionPane.showMessageDialog(frame, "Karta hartu behar duzu!");
				else if(k==5){
					if(botaOrd){
						int erantzuna=Integer.parseInt(JOptionPane.showInputDialog("Zein indarra?"));
						j.esleituKameleoi(erantzuna);
//						JOptionPane.showMessageDialog(frame, "Aukeratu karta");
//						panelComboBox.setVisible(true);
					}
					
				}else if(k==2){
					int erantzuna=1;
						if(botaOrd){
							erantzuna=Integer.parseInt(JOptionPane.showInputDialog("Aukeratu bota nahi duzun animaliaren posizioa"));
							boolean ondo=(erantzuna>=0 && erantzuna<j.getTableroKop());
							while(!ondo){
								JOptionPane optionPane = new JOptionPane("MESEDEZ, ZENBAKI EGOKIA SARTU!!!!!!!!!", JOptionPane.ERROR_MESSAGE);    
								JDialog dialog = optionPane.createDialog("ERROR");
								dialog.setAlwaysOnTop(true);
								dialog.setVisible(true);
								erantzuna=Integer.parseInt(JOptionPane.showInputDialog("Aukeratu bota nahi duzun animaliaren posizioa"));
								if(erantzuna>0 && erantzuna<j.getTableroKop()) ondo=true;
							}
						} j.kanporatu(erantzuna);
				}else if(k==3){
					int zenbatAurreratu=1;
					if(botaOrd){
						zenbatAurreratu=Integer.parseInt(JOptionPane.showInputDialog("Zenbat aurreratu nahi dituzu?"));
						boolean ondo=(zenbatAurreratu==1 || zenbatAurreratu==2);
						while(!ondo){
							JOptionPane optionPane = new JOptionPane("MESEDEZ, ZENBAKI EGOKIA SARTU!!!!!!!!!", JOptionPane.ERROR_MESSAGE);    
							JDialog dialog = optionPane.createDialog("ERROR");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
							zenbatAurreratu=Integer.parseInt(JOptionPane.showInputDialog("Zenbat aurreratu nahi dituzu?"));
							if(zenbatAurreratu==1 || zenbatAurreratu==2) ondo=true;
						}
						
					}j.aurreratu(zenbatAurreratu);
				}
				if(k==-8) JOptionPane.showMessageDialog(frame, "Ez da zure txanda");
				else if(botaOrd){
					int pos=j.getTableroKop();
					tableroanKartaIpini(k, pos,1);
					if (!hasiera){
						j.animaladakGauzatu(k,1);
					}
					hasiera = false;
				}if(botaJok) j.animaladakGauzatu(k, 2);
			}catch(NullPointerException x){
				JOptionPane.showMessageDialog(frame, "Hutsik");
			}catch(IndexOutOfBoundsException x){
				JOptionPane.showMessageDialog(frame, "Hor ez dago kartarik");
			}catch(NumberFormatException x){
				JOptionPane.showMessageDialog(frame, "Zenbaki okerra");
			}
		}
		
		private void tableroanKartaIpini(int k,int pos,int jok){
			switch(pos){
			case 1:
				tablero1.setIcon(new ImageIcon(j.getUrl(k,jok)));
				break;
			case 2:
				tablero2.setIcon(new ImageIcon(j.getUrl(k,jok)));
				break;
			case 3:
				tablero3.setIcon(new ImageIcon(j.getUrl(k,jok)));
				break;
			case 4:
				tablero4.setIcon(new ImageIcon(j.getUrl(k,jok)));
				break;
			case 5:
				tablero5.setIcon(new ImageIcon(j.getUrl(k,jok)));
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		ArrayList<Integer> kartak = new ArrayList<Integer>();
		kartak = (ArrayList<Integer>)arg;
		int i=0;
		while (i<kartak.size()-1){
			switch(i){
			case 0:
				tablero1.setIcon(new ImageIcon(j.getKartaUrl(kartak.get(i),kartak.get(i+1))));
				tablero2.setIcon(null);
				tablero3.setIcon(null);
				tablero4.setIcon(null);
				tablero5.setIcon(null);
				break;
			case 2:
				tablero2.setIcon(new ImageIcon(j.getKartaUrl(kartak.get(i),kartak.get(i+1))));
				break;
			case 4:
				tablero3.setIcon(new ImageIcon(j.getKartaUrl(kartak.get(i),kartak.get(i+1))));
				break;
			case 6:
				tablero4.setIcon(new ImageIcon(j.getKartaUrl(kartak.get(i),kartak.get(i+1))));
				break;
			case 8:
				tablero5.setIcon(new ImageIcon(j.getKartaUrl(kartak.get(i),kartak.get(i+1))));
				break;
			}
			i++;
		}
		
	}
	
}
