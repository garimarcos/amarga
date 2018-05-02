package packbarbestial;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import java.sql.ResultSetMetaData;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Datubasea {
	
		private String username="root";
		private String password="shuaelsa10";
		private String zerbitzaria="jdbc:mysql://localhost:3306/jokoa";
		private Connection konexioa;
	
	private static Datubasea nDatubasea = new Datubasea();
	
	private Datubasea(){
		konektatu();
	}
	
	public static Datubasea getnDatubasea(){ return nDatubasea; }
	
	private void konektatu(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			konexioa=DriverManager.getConnection(zerbitzaria,username,password);
//			if(konexioa!=null) System.out.println("Konexio zuzena");
//			else System.out.println("Konexio okerra");
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void jokBerriaSartu(String pIzen, String pAbizen, String pPasahitza, int pJaioUrtea, String pEmail){
		try {
			int urtea = Calendar.getInstance().get(Calendar.YEAR);
			int hil = Calendar.getInstance().get(Calendar.MONTH);
			int egun = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			String data = urtea+"-"+hil+"-"+egun;
			PreparedStatement ps=null;
			ps=konexioa.prepareStatement("insert into jokalaria values ('"+pIzen+"', '"+pAbizen+"', '"+pPasahitza+"', '"+pJaioUrtea+"','"+pEmail+"', '"+data+"','normal')");
			ps.executeUpdate();
		} catch (MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}