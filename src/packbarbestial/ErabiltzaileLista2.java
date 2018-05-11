package packbarbestial;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class ErabiltzaileLista2 extends JPanel {
	
	private JTable table;
	private ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[7]);
	private MyTableModel tableModel;
	
    public ErabiltzaileLista2() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1129, 200));
        
        erabiltzaileak = Datubasea.getnDatubasea().erabiltzaileakIkusi();
		
		tableModel = new MyTableModel();
		
		tableModel.addColumn("Izena",new Vector(erabiltzaileak[0]));
		tableModel.addColumn("Abizena", new Vector(erabiltzaileak[1]));
		tableModel.addColumn("Pasahitza", new Vector(erabiltzaileak[2]));
		tableModel.addColumn("Jaio urtea", new Vector(erabiltzaileak[3]));
		tableModel.addColumn("email", new Vector(erabiltzaileak[4]));
		tableModel.addColumn("Erregistro data", new Vector(erabiltzaileak[5]));
		tableModel.addColumn("Mota", new Vector(erabiltzaileak[6]));
		//tableModel.insertRow(0, new Object[] { "Izena","Abizena","Pasahitza", "Jaio urtea","email","Erregistro data","Mota" });
	
		table = new JTable(tableModel);
		TableColumnModel columnModel = table.getColumnModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(150);
		columnModel.getColumn(5).setPreferredWidth(100);
		columnModel.getColumn(6).setPreferredWidth(50);

        // Turn off JTable's auto resize so that JScrollPane will show a horizontal
        // scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    private static void showFrame() {
        JPanel panel = new ErabiltzaileLista2();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
		});
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Erabiltzaileen lista");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               ErabiltzaileLista2.showFrame();
            }
        });
    }
}