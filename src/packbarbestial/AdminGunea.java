package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class AdminGunea {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGunea window = new AdminGunea();
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
	public AdminGunea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Adminstratzailearen gunea");
		frame.setBounds(100, 100, 649, 103);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnAdminErab = new JButton("Erabiltzaile bat administratzaile bihurtu");
		btnAdminErab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String[] args = new String[] {"1"};
				ErabiltzaileLista.main(args);
			}
		});
		panel_1.add(btnAdminErab);
		
		JButton btnSuprErabiltzaile = new JButton("Erabiltzaile bati baimenak kendu");
		btnSuprErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String[] args = new String[] {"2"};
				ErabiltzaileLista.main(args);
			}
		});
		panel_1.add(btnSuprErabiltzaile);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnAnimalia = new JButton("Animalia berria sartu");
		btnAnimalia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimaliaSartu.main(null);
			}
		});
		panel.add(btnAnimalia);
		
		JButton btnAtzera = new JButton("Atzera");
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Jokatu.main(null);
			}
		});
	}

}
