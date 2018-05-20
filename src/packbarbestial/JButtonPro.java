package packbarbestial;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JButtonPro extends JButton {

	public JButtonPro() {
		// TODO Auto-generated constructor stub
	}

	public JButtonPro(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public JButtonPro(String text) {
		super(text);		
		// TODO Auto-generated constructor stub
	}

	public JButtonPro(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public JButtonPro(String text, Icon icon) {
		super(text, icon);
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
			//Image newImg=image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
			this.setIcon(new ImageIcon(image));	
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			this.setIcon(null);
		}
	}

}
