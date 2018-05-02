package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Datuak {

	private JFrame frame;
	private JTextField izena;
	private JTextField abizena;
	private JPasswordField pasahitza;
	private JPasswordField pasahitzaBerretsi;
	private JTextField jaioUrtea;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datuak window = new Datuak();
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
	public Datuak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Erregistroa");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int erantzuna=JOptionPane.showConfirmDialog(frame, "Ziur irten nahi zarela?","Irteera",JOptionPane.INFORMATION_MESSAGE);
				if(erantzuna==JOptionPane.YES_OPTION) System.exit(0);
				else if((erantzuna==JOptionPane.NO_OPTION) || (erantzuna==JOptionPane.CANCEL_OPTION)) frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		frame.getContentPane().setLayout(new GridLayout(7, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblIzena = new JLabel("Izena");
		panel.add(lblIzena);
		
		izena = new JTextField();
		panel.add(izena);
		izena.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblAbizena = new JLabel("Abizena");
		panel_1.add(lblAbizena);
		
		abizena = new JTextField();
		panel_1.add(abizena);
		abizena.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		panel_2.add(lblPasahitza);
		
		pasahitza = new JPasswordField();
		panel_2.add(pasahitza);
		pasahitza.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblPasahitzaBerrets = new JLabel("Pasahitza berretsi");
		panel_6.add(lblPasahitzaBerrets);
		
		pasahitzaBerretsi = new JPasswordField();
		panel_6.add(pasahitzaBerretsi);
		pasahitza.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblJaiotzeurtea = new JLabel("Jaiotze-urtea");
		panel_3.add(lblJaiotzeurtea);
		
		jaioUrtea = new JTextField();
		panel_3.add(jaioUrtea);
		jaioUrtea.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("E-mail");
		panel_4.add(lblEmail);
		
		email = new JTextField();
		panel_4.add(email);
		email.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!(Arrays.equals(pasahitza.getPassword(), pasahitzaBerretsi.getPassword()))) throw new PasahitzaOkerrakException();
					char[] pass=pasahitza.getPassword();
					String pasahitza = new String(pass);
					String jaioU = jaioUrtea.getText();
					int jaiotzeUrt = Integer.parseInt(jaioU);
					Datubasea.getnDatubasea().jokBerriaSartu(izena.getText(),abizena.getText(),pasahitza,jaiotzeUrt,email.getText());
					frame.dispose();
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(frame, "Jaiotze-urtea egokia sartu","Error",JOptionPane.ERROR_MESSAGE);
				}catch(PasahitzaOkerrakException x){
					JOptionPane.showMessageDialog(frame, "Pasahitza desberdinak","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton atzera = new JButton("Atzera");
		atzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_5.add(atzera);
		panel_5.add(btnGorde);
	}

}
