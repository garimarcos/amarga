package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Puntuazioa {

	private JFrame frame;
	private String[] args;
	private boolean jokIrabazi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puntuazioa window = new Puntuazioa(args);
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
	public Puntuazioa(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		this.args = args;
		int[] puntuak = Jokoa.getnJokoa().lortuPuntuak();
		String[] puntuString = new String[puntuak.length];
		int i = 0;
		while(i<=puntuak.length-1){
			puntuString[i] = String.valueOf(puntuak[i]);
			i++;
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblJokalariarenKartaKopurua = new JLabel("Jokalariaren karta kopurua");
		lblJokalariarenKartaKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblJokalariarenKartaKopurua);
		
		JLabel labelKopJok = new JLabel("");
		labelKopJok.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(labelKopJok);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblJokalariarenPuntuak = new JLabel("Jokalariaren puntuak");
		lblJokalariarenPuntuak.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblJokalariarenPuntuak);
		
		JLabel labelJokPuntu = new JLabel("");
		labelJokPuntu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(labelJokPuntu);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblOrdenagailuarenKartaKopurua = new JLabel("Ordenagailuaren karta kopurua");
		lblOrdenagailuarenKartaKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblOrdenagailuarenKartaKopurua);
		
		JLabel labelOrdKop = new JLabel("");
		labelOrdKop.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(labelOrdKop);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblOrdenagailuarenPuntuak = new JLabel("Ordenagailuaren puntuak");
		lblOrdenagailuarenPuntuak.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblOrdenagailuarenPuntuak);
		
		JLabel labelOrdPuntu = new JLabel("");
		labelOrdPuntu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(labelOrdPuntu);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int puntuJok = puntuak[1];
				int puntuOrd = puntuak[3];
				Jokoa j = Jokoa.getnJokoa();
				String jokKolore = j.jokKolore();
				String jokEmail = j.jokEmail();
				int hOrdua = Integer.parseInt(args[0]);
				int hMin = Integer.parseInt(args[1]);
				int hSeg = Integer.parseInt(args[2]);
				int bOrdua = Integer.parseInt(args[3]);
				int bMin= Integer.parseInt(args[4]);
				int bSeg = Integer.parseInt(args[5]);
				
				Datubasea.getnDatubasea().partidaBerriaSartu(jokKolore, hOrdua, hMin, hSeg, bOrdua, bMin, bSeg, jokEmail, puntuJok, puntuOrd, jokIrabazi);
				frame.dispose();
				AudioIrabazi.stop();
				AudioGaldu.stop();
				Jokatu.main(null);
			}
		});
		panel.add(btnOk);
		labelKopJok.setText(puntuString[0]);
		labelJokPuntu.setText(puntuString[1]);
		labelOrdKop.setText(puntuString[2]);
		labelOrdPuntu.setText(puntuString[3]);
		
		jokIrabazi = irabaziDu(labelOrdKop.getText(),labelOrdPuntu.getText(),labelKopJok.getText(),labelJokPuntu.getText());
		
			try {
				if(!jokIrabazi) AudioGaldu.main(null);
				else AudioIrabazi.main(null);;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}
		

	}
	
	private boolean irabaziDu(String ordKop, String ordPuntu, String kopJok, String jokPuntu){ //true bueltatuko du jokalariak irabazi badu
		int ordKopInt = Integer.parseInt(ordKop);
		int jokKop = Integer.parseInt(kopJok);
		if(ordKopInt>jokKop) return false;
		else if (ordKopInt == jokKop){
			int puntuJok = Integer.parseInt(jokPuntu);
			int puntuOrd = Integer.parseInt(ordPuntu);
			if(puntuJok<puntuOrd) return true;
			else return false;
		}else return true;
	}

}
