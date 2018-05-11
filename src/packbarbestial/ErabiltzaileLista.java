package packbarbestial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ErabiltzaileLista {

	private JFrame frame;
	private JTextField textField;
	private String[] args;
	private MyTableModel tableModel;
	private ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[7]);
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErabiltzaileLista window = new ErabiltzaileLista(args);
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
	public ErabiltzaileLista(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		this.args=args;
		tableModel = new MyTableModel();
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					egikaritu();
				}
			}
		});
		frame.setBounds(100, 100, 1252, 228);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblEmail);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_1.add(btnAtzera);
		
		JButton btnOngi = new JButton("Ongi");
		btnOngi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				egikaritu();
			}
		});
		panel_1.add(btnOngi);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
//		erabiltzaileak = Datubasea.getnDatubasea().erabiltzaileakIkusi();
//		
//		tableModel = new MyTableModel();
//		
//		tableModel.addColumn("Izena",new Vector(erabiltzaileak[0]));
//		tableModel.addColumn("Abizena", new Vector(erabiltzaileak[1]));
//		tableModel.addColumn("Pasahitza", new Vector(erabiltzaileak[2]));
//		tableModel.addColumn("Jaio urtea", new Vector(erabiltzaileak[3]));
//		tableModel.addColumn("email", new Vector(erabiltzaileak[4]));
//		tableModel.addColumn("Erregistro data", new Vector(erabiltzaileak[5]));
//		tableModel.addColumn("Mota", new Vector(erabiltzaileak[6]));
//		tableModel.insertRow(0, new Object[] { "Izena","Abizena","Pasahitza", "Jaio urtea","email","Erregistro data","Mota" });
//	
//		
//		table = new JTable(tableModel);
		panel_5.add(new ErabiltzaileLista2());
		
	}
	
	private void egikaritu(){
		int aukera = Integer.parseInt(args[0]);
		switch(aukera){
		case 1:
			Datubasea.getnDatubasea().administratzaileBihurtu(textField.getText());
			break;
		case 2:
			Datubasea.getnDatubasea().baimenakKendu(textField.getText());
			break;
		}
		textField.setText("");
		tableModel.fireTableDataChanged();
		//tableModel.fireTableRowsDeleted(0, table.getRowCount());
	}
	

}
