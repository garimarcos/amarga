package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jokatu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jokatu window = new Jokatu();
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
	public Jokatu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 97);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton atzera = new JButton("Atzera");
		atzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Jokoa.getnJokoa().hutsituLista();
				DatuenSarrera.main(null);
			}
		});
		frame.getContentPane().add(atzera);
		
		JButton jokatu = new JButton("Jokatu");
		jokatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				KoloreAukera.main(null);
			}
		});
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RankingAukeraketa.main(null);
			}
		});
		frame.getContentPane().add(btnRanking);
		frame.getContentPane().add(jokatu);
		
		JButton admin = new JButton("Administratzailearen gunea");
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminGunea.main(null);
			}
		});
		frame.getContentPane().add(admin);
		if(!this.administratzaileaDa()) admin.setEnabled(false);
	}
	
	private boolean administratzaileaDa(){
		String izen = Jokoa.getnJokoa().jokIzen();
		return Datubasea.getnDatubasea().administratzaileaDa(izen);
	}

}
