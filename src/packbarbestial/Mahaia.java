package packbarbestial;

import java.util.Scanner;

public class Mahaia {
	private static Mahaia nMahaia=new Mahaia();
	
	private Mahaia(){
		
	}
	
	public static Mahaia getnMahaia(){
		return nMahaia;
	}
	
	public void hasieratu(){
		sortuJokalariak();
	}
	
	private void sortuJokalariak(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Sartu jokalari kopurua (ordenagailuaren kontra jokatzetakoan, sartu 1): ");
		int kop=sc.nextInt();
		for(int i=0;i<=kop;i++){ //sartutako kopuruaren arabera burutuko dugu metodo hau, horrela hedagarria izango da jokalari gehiago sartzerako orduan
			System.out.println("Sartu jokalariaren izena: ");
			String izena=sc.nextLine();
			System.out.println(izena + ", sartu nahi duzun kolorea: ");
			String kolorea=sc.nextLine();
			ListaJokalariak.getNireLista().add(new Jokalaria(izena,kolorea)); //EMAn sartu
			sc.close();
		}
	}

}
