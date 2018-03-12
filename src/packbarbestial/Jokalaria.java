package packbarbestial;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Jokalaria {
	
	private String izena;
	private String kolorea;
	private Stack<Karta> hartzeke;
	private LinkedList<Karta> eskuan;
	
	public Jokalaria(String pIzen, String pKolore){
		this.izena=pIzen;
		this.kolorea=pKolore;
		this.hartzeke=new Stack<Karta>();
		this.eskuan=new LinkedList<Karta>();
	}
	
	public void hasieratu(){
		for(int i=0;i<=5;i++){
			Random rn=new Random();
			int zk=rn.nextInt(13);
			
		}
		
	}

}
