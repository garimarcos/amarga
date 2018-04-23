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

public class DatuenSarrera extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFrame frame;
	private JTextField jokIzenText;
	private JTextField jokKoloreText;

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
		setBounds(100, 100, 420, 128);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2,2));
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
			JLabel jokKoloreLabel = new JLabel("Jokalariaren kolorea");
			contentPanel.add(jokKoloreLabel);
		}
		{
			jokKoloreText = new JTextField();
			contentPanel.add(jokKoloreText);
			jokKoloreText.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String kol="";
						if(!jokKoloreText.getText().equalsIgnoreCase("berdea") && !jokKoloreText.getText().equalsIgnoreCase("urdina")){
							kol="berdea";
						}else kol=jokKoloreText.getText();
						Jokoa.getnJokoa().addJokalaria(jokIzenText.getText(), kol);
						dispose();
					}
				});
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
