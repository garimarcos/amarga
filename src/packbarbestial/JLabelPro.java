package packbarbestial;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelPro extends JLabel {

	public JLabelPro() {
		// TODO Auto-generated constructor stub
	}

	public JLabelPro(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public JLabelPro(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public JLabelPro(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public JLabelPro(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public JLabelPro(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public void erdianJarri(){
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	public void setIconURL(String pURL){
		try{
			URL url=new URL(pURL);
			Image image=ImageIO.read(url);
			this.setIcon(new ImageIcon(image));
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
