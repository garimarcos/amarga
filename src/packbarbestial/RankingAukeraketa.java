package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankingAukeraketa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingAukeraketa window = new RankingAukeraketa();
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
	public RankingAukeraketa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 303, 119);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		panel_1.add(comboBox);
		comboBox.addItem("1. Erabiltzailearen partida onenak");
		comboBox.addItem("2. Eguneko partida onenak");
		comboBox.addItem("3. Historikoki partida onenak");
		comboBox.addItem("4. Jokalari onenak");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Atzera");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Jokatu.main(null);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Gorde");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aukera = comboBox.getSelectedItem().toString();
				char zkS = aukera.charAt(0);
				int zk = Character.getNumericValue(zkS);
				switch(zk){
				case 1:
					RankingJokalaria.main(null);
					break;
				case 2:
					RankingEguna.main(null);
					break;
				case 3:
					HistorikokiOnenak.main(null);
					break;
				case 4:
					BatezBestekoOnenak.main(null);
					break;
				}
				frame.dispose();
			}
		});
		panel.add(btnNewButton);
	}

}
