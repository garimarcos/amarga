package packbarbestial;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class RankingJokalaria extends JPanel {
	
	private JTable table;
	private ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[9]);
	private MyTableModel tableModel;
	
    public RankingJokalaria() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1160, 200));
        
        erabiltzaileak = Datubasea.getnDatubasea().jokalariarenPartidaOnenak();
		
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
		//tableModel.insertRow(0, new Object[] { "Kodea","Kolorea","Data", "Hasiera ordua","Bukaera ordua","Jokalariaren email","Jokalariaren puntuak" ,"Ordenagailuaren puntuak","Irabazi du"});	
		
		table = new JTable(tableModel);
		TableColumnModel columnModel = table.getColumnModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(150);
		columnModel.getColumn(5).setPreferredWidth(150);
		columnModel.getColumn(6).setPreferredWidth(150);
		columnModel.getColumn(7).setPreferredWidth(170);
		columnModel.getColumn(8).setPreferredWidth(100);

        // Turn off JTable's auto resize so that JScrollPane will show a horizontal
        // scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    private static void showFrame() {
        JPanel panel = new RankingJokalaria();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				RankingAukeraketa.main(null);
			}
		});
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Partida hoberenak");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               RankingJokalaria.showFrame();
            }
        });
    }
}