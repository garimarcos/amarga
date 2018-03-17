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
		for(int i=1;i<=kop;i++){ //sartutako kopuruaren arabera burutuko dugu metodo hau, horrela hedagarria izango da jokalari gehiago sartzerako orduan
			Scanner sc1=new Scanner(System.in);
			System.out.println("Sartu jokalariaren izena: ");
			String izena=sc1.nextLine();
			Scanner sc2=new Scanner(System.in);
			System.out.println(izena + ", sartu nahi duzun kolorea");
			String kolorea=sc2.nextLine();
			ListaJokalariak.getNireLista().add(new Jokalaria(izena,kolorea)); //EMAn sartu
			sc1.close();
			sc2.close();
		}
		sc.close();
	}
	
	public String[] mahaiaPrestatu(){
		ListaJokalariak.getNireLista().jokLortu(1).hasieratu();
		return ListaJokalariak.getNireLista().jokLortu(1).mahaiaPrestatu();
	}

}
