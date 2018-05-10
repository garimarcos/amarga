package packbarbestial;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;

public class RankingEguna {

	private JFrame frame;
	private JTable table;
	private ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[1]);
	private MyTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingEguna window = new RankingEguna();
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
	public RankingEguna() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Eguneko partida onenak");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				RankingAukeraketa.main(null);
			}
		});
		frame.setBounds(100, 100, 980, 560);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		erabiltzaileak = Datubasea.getnDatubasea().egunekoPartidaOnenak();
		
		tableModel = new MyTableModel();
		
		tableModel.addColumn("Kodea",new Vector(erabiltzaileak[0]));
		tableModel.insertRow(0, new Object[] { "Puntuazioak"});	
		
		table = new JTable(tableModel);
		frame.getContentPane().add(table);
	}

}
