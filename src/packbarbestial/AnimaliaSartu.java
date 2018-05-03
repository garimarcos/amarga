package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class AnimaliaSartu {

	private JFrame frame;

	private JTextField izena;
	private JTextField zenbakia;
	private JTextField puntuazioa;
	private JTextField azalpena;
	private JCheckBox chckbxOinarrizkoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimaliaSartu window = new AnimaliaSartu();
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
	public AnimaliaSartu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Animaliaren erregistroa");
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					sartuDatuak();
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblIzena = new JLabel("Izena");
		panel_1.add(lblIzena);
		
		izena = new JTextField();
		panel_1.add(izena);
		izena.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblZenbakia = new JLabel("Zenbakia");
		panel_2.add(lblZenbakia);
		
		zenbakia = new JTextField();
		panel_2.add(zenbakia);
		zenbakia.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblPuntuazioa = new JLabel("Puntuazioa");
		panel_3.add(lblPuntuazioa);
		
		puntuazioa = new JTextField();
		panel_3.add(puntuazioa);
		puntuazioa.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblAzalpena = new JLabel("Azalpena");
		panel_4.add(lblAzalpena);
		
		azalpena = new JTextField();
		panel_4.add(azalpena);
		azalpena.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblOinarrizkoa = new JLabel("Oinarrizkoa");
		panel_5.add(lblOinarrizkoa);
		
		chckbxOinarrizkoa = new JCheckBox("");
		panel_5.add(chckbxOinarrizkoa);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnAtzera);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnGorde);
		frame.getRootPane().setDefaultButton(btnGorde);
	}
	
	private void sartuDatuak(){
		try{
			int zk = Integer.parseInt(zenbakia.getText());
			int punt = Integer.parseInt(puntuazioa.getText());
			boolean orijinala=chckbxOinarrizkoa.isSelected();
			Datubasea.getnDatubasea().animaliaSartu(izena.getText(), zk, punt, azalpena.getText(), orijinala);
			frame.dispose();
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(frame, "Sartu zenbakia","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
