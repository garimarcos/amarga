package packbarbestial;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KopuruAukera extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jokKopText;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(/*String[] args*/) {
		try {
			KopuruAukera dialog = new KopuruAukera();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public KopuruAukera() {
		setModal(true);
		setBounds(100, 100, 320, 109);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1,2));
		{
			JLabel jokKopLabel = new JLabel("Jokalari kopurua");
			contentPanel.add(jokKopLabel);
		}
		{
			jokKopText = new JTextField();
			contentPanel.add(jokKopText);
			jokKopText.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try{
								int pKop=Integer.parseInt(jokKopText.getText());
								if(pKop!=1) throw new KopuruEzEgokiaException();
								else{
									ListaJokalariak.getNireLista().setKop(pKop);
									dispose();
								}
							}catch(NumberFormatException e1){
								JOptionPane.showMessageDialog(contentPanel, "Kopuru okerra");
							}catch(KopuruEzEgokiaException e1){
								JOptionPane.showMessageDialog(contentPanel, "Momentuz jokalari bakarrak jolastu dezake");
							}catch(InputMismatchException e1){
								e1.printStackTrace();
							}
					}
				});
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						int erantzuna=JOptionPane.showConfirmDialog(frame, "Ziur irten nahi zarela?","Irteera",JOptionPane.INFORMATION_MESSAGE);
						if(erantzuna==JOptionPane.YES_OPTION) System.exit(0);
						else if((erantzuna==JOptionPane.NO_OPTION) || (erantzuna==JOptionPane.CANCEL_OPTION)) frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
