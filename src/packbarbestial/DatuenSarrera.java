package packbarbestial;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DatuenSarrera {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatuenSarrera window = new DatuenSarrera();
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
	public DatuenSarrera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String[] aukerak={"Bai","Ez","Atzera"};
				int erantzuna=JOptionPane.showOptionDialog(frame.getContentPane(),"Ziur irten nahi zarela?","Irteera", 0,JOptionPane.INFORMATION_MESSAGE,null,aukerak,null);
				//int erantzuna=JOptionPane.showConfirmDialog(frame, "Ziur irten nahi zarela?","Irteera",JOptionPane.INFORMATION_MESSAGE);
				if(erantzuna==JOptionPane.YES_OPTION) System.exit(0);
				else if((erantzuna==JOptionPane.NO_OPTION) || (erantzuna==JOptionPane.CANCEL_OPTION)) frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		frame.setBounds(100, 100, 815, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0)); 
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabelPro label = new JLabelPro("");
		label.setIcon(new ImageIcon(DatuenSarrera.class.getResource("/logo-resizeHandia.png")));
		//label.setIcon(new ImageIcon("img/logo-resizeHandia.png"));
		label.erdianJarri();
		panel_1.add(label, BorderLayout.CENTER);
		
		JLabelPro lblAukeratu = new JLabelPro("Aukeratu");
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblAukeratu, BorderLayout.NORTH);
		lblAukeratu.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblAukeratu.erdianJarri();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnJokBerria = new JButton("Jokalari berria sortu");
		btnJokBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erregistroa.main(null);
			}
		});
		panel.add(btnJokBerria);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		panel.add(btnSartu);
	}

}
