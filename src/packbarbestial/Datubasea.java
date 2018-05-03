package packbarbestial;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Datubasea {
	
		private String username="root";
		private String password="shuaelsa10";
		private String zerbitzaria="jdbc:mysql://localhost:3306/jokoa?useSSL=false";
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
	
	public boolean jokBerriaSartu(String pIzen, String pAbizen, String pPasahitza, int pJaioUrtea, String pEmail){
		try {
			int urtea = Calendar.getInstance().get(Calendar.YEAR);
			int hil = Calendar.getInstance().get(Calendar.MONTH)+1;
			int egun = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			String data = urtea + "-" + hil + "-" + egun;
			PreparedStatement ps=null;
			ps=konexioa.prepareStatement("insert into jokalaria values ('"+pIzen+"', '"+pAbizen+"', '"+pPasahitza+"', '"+pJaioUrtea+"','"+pEmail+"', '"+data+"','normal')");
			ps.executeUpdate();
			return true;
		}catch (MySQLSyntaxErrorException e){
			//e.printStackTrace();
			return false;
		}catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean login(String pIzen, String pPasahitza){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("select izena, pasahitza from jokalaria where izena='" + pIzen + "'");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getString("pasahitza").equals(pPasahitza)) return true;
				else return false;
			}
			return false;
		}catch (MySQLSyntaxErrorException e){
			//e.printStackTrace();
			return false;
		}catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean administratzaileaDa(String pIzen){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("select izena, mota from jokalaria where izena='" + pIzen + "'");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getString("mota").equals("admin")) return true;
				else return false;
			}
			return false;
		}catch (MySQLSyntaxErrorException e){
			//e.printStackTrace();
			return false;
		}catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public void animaliaSartu(String pIzen, int pZenb, int pPunt, String pAzalpena, boolean pOrijinala){
		PreparedStatement ps = null;
		try{
			int orijinala=0;
			if(pOrijinala) orijinala=1;
			ps=konexioa.prepareStatement("insert into animalia values('" + pIzen + "'," + pZenb + ",'" + pAzalpena + "'," + pPunt + "," + orijinala + ")");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			
		}catch(SQLException e){
			
		}
	}
	
	public void administratzaileBihurtu(String pIzen){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("update jokalaria set mota='admin' where izena='" + pIzen + "'");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			
		}catch(SQLException e){
			
		}
	}
	
	public void baimenakKendu(String pIzen){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("update jokalaria set pasahitza='admin' where izena='" + pIzen + "'");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			
		}catch(SQLException e){
			
		}
	}
	
	public void partidaBerriaSartu(String pKolorea, int hOrdua, int bOrdua, String jokIzen, int puntuJok, int puntuOrd){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("insert into partida values('");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			
		}catch(SQLException e){
			
		}
	}

}
