package packbarbestial;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;

public class DatuenSarrera extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFrame frame;
	private JTextField jokIzenText;
	private JRadioButton rdbtnBerdea = new JRadioButton("berdea");
	private JRadioButton rdbtnUrdina = new JRadioButton("urdina");

	/**
	 * Launch the application.
	 */
	public static void main(/*String[] args*/) {
		try {
			DatuenSarrera dialog = new DatuenSarrera();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DatuenSarrera() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int erantzuna=JOptionPane.showConfirmDialog(frame, "Ziur irten nahi zarela?","Irteera",JOptionPane.INFORMATION_MESSAGE);
				if(erantzuna==JOptionPane.YES_OPTION) System.exit(0);
				else if((erantzuna==JOptionPane.NO_OPTION) || (erantzuna==JOptionPane.CANCEL_OPTION)) frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		setModal(true);
		setBounds(100, 100, 286, 128);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2,2));
		rdbtnBerdea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!rdbtnBerdea.isSelected()) rdbtnBerdea.setSelected(true);;
				rdbtnUrdina.setSelected(false);
			}
		});
		rdbtnBerdea.setSelected(true);
		rdbtnUrdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!rdbtnUrdina.isSelected()) rdbtnUrdina.setSelected(true);;
				rdbtnBerdea.setSelected(false);
			}
		});
		rdbtnUrdina.setSelected(false);
		{
			JLabel jokIzenLabel = new JLabel("Jokalariaren izena");
			contentPanel.add(jokIzenLabel);
		}
		{
			jokIzenText = new JTextField();
			contentPanel.add(jokIzenText);
			jokIzenText.setColumns(10);
		}
		{
			
			contentPanel.add(rdbtnBerdea);
			
		}
		{
	
			contentPanel.add(rdbtnUrdina);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String kol="";
						if (rdbtnBerdea.isSelected()) kol="berdea";
						else if (rdbtnUrdina.isSelected()) kol="urdina";
						Jokoa.getnJokoa().addJokalaria(jokIzenText.getText(), kol);
						dispose();
					}
				});
				buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Kantzelatu");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
