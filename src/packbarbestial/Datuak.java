package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Datuak {

	private JFrame frame;
	private JTextField izena;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		frame.getContentPane().add(panel_6);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datubasea.getnDatubasea().jokBerriaSartu(izena.getText(), "", "", 0, "");
			}
		});
		panel_6.add(btnGorde);
	}

}
