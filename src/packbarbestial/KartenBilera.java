package packbarbestial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class KartenBilera {
	
	private static KartenBilera nKartenBilera=new KartenBilera();
	private HashMap<Integer,String> kartaUrdinak=new HashMap<Integer,String>();
	private HashMap<Integer,String> kartaBerdeak=new HashMap<Integer,String>();

	private KartenBilera() {
		kartakHasieratu("urdina");
		kartakHasieratu("berdea");
	}
	
	public static KartenBilera getnKartenBilera(){
		return nKartenBilera;
	}
	
	private void kartakHasieratu(String pKolore){
		switch(pKolore){
		case "urdina":
			File kartaUrdinakURL=new File("resources/kartaUrdinakURL.txt");
			fitxategiaKargatu(kartaUrdinakURL,kartaUrdinak);
			break;
		case "berdea":
			File kartaBerdeakURL=new File("resources/kartaBerdeakURL.txt");
			fitxategiaKargatu(kartaBerdeakURL,kartaBerdeak);
			break;
		}
		
	}
	
	private void fitxategiaKargatu(File pFile, HashMap<Integer,String> th){
		try{
			FileReader fr=new FileReader(pFile);
			BufferedReader br=new BufferedReader(fr);
			String lerroa=br.readLine();
			int i=1;
			while(lerroa!=null){
				th.put(i, lerroa);
				i++;
				lerroa=br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getURL(int pIndarra,String pKolore){
		if(pKolore.equalsIgnoreCase("urdina")) return kartaUrdinak.get(pIndarra);
		else return kartaBerdeak.get(pIndarra);
	}
	

}
