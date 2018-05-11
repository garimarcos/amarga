package packbarbestial;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class BatezBestekoOnenak2 extends JPanel {
	
	private JTable table;
	private ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[1]);
	private MyTableModel tableModel;
	
    public BatezBestekoOnenak2() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(370, 200));
        
        erabiltzaileak = Datubasea.getnDatubasea().historikokiPartidaOnenak();
		
		tableModel = new MyTableModel();
		
		tableModel.addColumn("Partida kodea",new Vector(erabiltzaileak[0]));
		//tableModel.insertRow(0, new Object[] { "Izena"});
		
		table = new JTable(tableModel);
		
		TableColumnModel columnModel = table.getColumnModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		columnModel.getColumn(0).setPreferredWidth(100);

        // Turn off JTable's auto resize so that JScrollPane will show a horizontal
        // scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    private static void showFrame() {
        JPanel panel = new BatezBestekoOnenak2();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				RankingAukeraketa.main(null);
			}
		});
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Batez besteko puntuaziorik onenak");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               BatezBestekoOnenak2.showFrame();
            }
        });
    }
}