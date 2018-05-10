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
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Login extends JDialog{

	private JFrame frame;
	private JTextField email;
	private JPasswordField pasahitza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setModal(true);
		frame = new JFrame("Login");
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					sartuDatuak();
				}
			}
		});
		frame.setBounds(100, 100, 426, 143);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 0, 0, 0));

		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblIzena = new JLabel("Email");
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblIzena);
		
		email = new JTextField();
		panel_1.add(email);
		email.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblPasahitza);
		
		pasahitza = new JPasswordField();
		panel_2.add(pasahitza);
		pasahitza.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton atzera = new JButton("Atzera");
		atzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DatuenSarrera.main(null);
			}
		});
		panel.add(atzera);
		
		JButton sartu = new JButton("Sartu");
		sartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sartuDatuak();
			}
		});
		panel.add(sartu);
		frame.getRootPane().setDefaultButton(sartu);
	}
	
	private void sartuDatuak(){
		char[] pass=pasahitza.getPassword();
		String pasahitza = new String(pass);
		boolean ondo =Datubasea.getnDatubasea().login(email.getText(), pasahitza);
		if(!ondo) JOptionPane.showMessageDialog(frame, "Login errorea","Error",JOptionPane.ERROR_MESSAGE);
		else{
			Jokoa.getnJokoa().addJokalaria(email.getText(), null);
			frame.dispose();
			Jokatu.main(null);
		}
	}

}
