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
	private HashMap<Integer,String> kartaGorriak=new HashMap<Integer,String>();
	private HashMap<Integer,String> kartaHoriak=new HashMap<Integer,String>();

	private KartenBilera() {
		kartakHasieratu("urdina");
		kartakHasieratu("berdea");
		kartakHasieratu("gorria");
		kartakHasieratu("horia");
	}
	
	public static KartenBilera getnKartenBilera(){
		return nKartenBilera;
	}
	
	private void kartakHasieratu(String pKolore){
		if(pKolore.equalsIgnoreCase("urdina")){
			File kartaUrdinakURL=new File("resources/kartaUrdinak.txt");
			fitxategiaKargatu(kartaUrdinakURL,kartaUrdinak);
		}else if(pKolore.equalsIgnoreCase("berdea")){
			File kartaBerdeakURL=new File("resources/kartaBerdeak.txt");
			fitxategiaKargatu(kartaBerdeakURL,kartaBerdeak);
		}else if(pKolore.equalsIgnoreCase("gorria")){
			File kartaGorriakURL=new File("resources/kartaGorriak.txt");
			fitxategiaKargatu(kartaGorriakURL,kartaGorriak);
		}else if(pKolore.equalsIgnoreCase("horia")){
			File kartaHoriakURL=new File("resources/kartaHoriak.txt");
			fitxategiaKargatu(kartaHoriakURL,kartaHoriak);
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
		else if(pKolore.equalsIgnoreCase("berdea")) return kartaBerdeak.get(pIndarra);
		else if(pKolore.equalsIgnoreCase("gorria")) return kartaGorriak.get(pIndarra);
		else return kartaHoriak.get(pIndarra);
	}

}
