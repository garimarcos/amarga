package packbarbestial;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;

public class HistorikokiOnenak {

	private JFrame frame;
	private JTable table;
	private ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[9]);
	private MyTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistorikokiOnenak window = new HistorikokiOnenak();
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
	public HistorikokiOnenak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Historikoki partida onenak");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frame.dispose();
				RankingAukeraketa.main(null);
			}
		});
		frame.setBounds(100, 100, 980, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		erabiltzaileak = Datubasea.getnDatubasea().historikokiPartidaOnenak();
		
		tableModel = new MyTableModel();
		
		tableModel.addColumn("Kodea",new Vector(erabiltzaileak[0]));
		tableModel.addColumn("Kolorea", new Vector(erabiltzaileak[1]));
		tableModel.addColumn("Data", new Vector(erabiltzaileak[2]));
		tableModel.addColumn("Hasiera ordua", new Vector(erabiltzaileak[3]));
		tableModel.addColumn("Bukaera ordua", new Vector(erabiltzaileak[4]));
		tableModel.addColumn("Jokalariaren email", new Vector(erabiltzaileak[5]));
		tableModel.addColumn("Jokalariaren puntuak", new Vector(erabiltzaileak[6]));
		tableModel.addColumn("Ordenagailuaren puntuak", new Vector(erabiltzaileak[7]));
		tableModel.addColumn("Irabazi du", new Vector(erabiltzaileak[8]));
		tableModel.insertRow(0, new Object[] { "Kodea","Kolorea","Data", "Hasiera ordua","Bukaera ordua","Jokalariaren email","Jokalariaren puntuak" ,"Ordenagailuaren puntuak","Irabazi du"});	
		
		table = new JTable(tableModel);
		frame.getContentPane().add(table);
	}

}
