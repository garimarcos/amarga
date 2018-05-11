package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KoloreAukera {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KoloreAukera window = new KoloreAukera();
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
	public KoloreAukera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 411, 117);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblKolore = new JLabel("Kolorea");
		panel_1.add(lblKolore);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		panel_1.add(comboBox);
		
		comboBox.addItem("Berdea");
		comboBox.addItem("Urdina");
		comboBox.addItem("Gorria");
		comboBox.addItem("Horia");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Jokatu.main(null);
			}
		});
		panel.add(btnAtzera);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kolore=comboBox.getSelectedItem().toString();
				Jokoa.getnJokoa().setKolore(kolore);
				frame.dispose();
				Hasiera.main(null);
			}
		});
		panel.add(btnGorde);
	}

}
