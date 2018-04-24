package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KameleoiAukera extends JDialog{

	private JFrame frame;
	private Jokoa j=Jokoa.getnJokoa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KameleoiAukera window = new KameleoiAukera();
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
	public KameleoiAukera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setModal(true);
		frame.setBounds(100, 100, 136, 89);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		frame.getContentPane().add(comboBox);
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
		
		JButton btnNewButton = new JButton("Baieztatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukeratua=(String) comboBox.getSelectedItem();
				switch(aukeratua){
				case "Mofeta":
					j.sortuKameleoi(1);
					break;
				case "Loro":
					j.sortuKameleoi(2);
					break;
				case "Kanguro":
					j.sortuKameleoi(3);
					break;
				case "Tximino":
					j.sortuKameleoi(4);
					break;
				case "Foka":
					j.sortuKameleoi(6);
					break;
				case "Zebra":
					j.sortuKameleoi(7);
					break;
				case "Jirafa":
					j.sortuKameleoi(8);
					break;
				case "Sugea":
					j.sortuKameleoi(9);
					break;
				case "Krokodilo":
					j.sortuKameleoi(10);
					break;
				case "Hipopotamo":
					j.sortuKameleoi(11);
					break;
				case "Lehoi":
					j.sortuKameleoi(12);
					break;
				}
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}
