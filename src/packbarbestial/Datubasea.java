package packbarbestial;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public boolean jokBerriaSartu(String pIzen, String pAbizen, String pPasahitza, int pJaioUrtea, String pEmail) throws JokalariBerriaException{
		try {
			String data = gaurkoData();
			PreparedStatement ps=null;
			ps=konexioa.prepareStatement("select email from jokalaria where email='"+pEmail+"'");
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				ps=konexioa.prepareStatement("insert into jokalaria values ('"+pIzen+"', '"+pAbizen+"', '"+pPasahitza+"', '"+pJaioUrtea+"','"+pEmail+"', '"+data+"','normal')");
				ps.executeUpdate();
				return true;
			}else throw new JokalariBerriaException();
		}catch (MySQLSyntaxErrorException e){
			//e.printStackTrace();
			return false;
		}catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean login(String pEmail, String pPasahitza){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("select email, pasahitza from jokalaria where email='" + pEmail + "'");
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
	
	public boolean administratzaileaDa(String pEmail){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("select email, mota from jokalaria where email='" + pEmail + "'");
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
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void administratzaileBihurtu(String pIzen){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("update jokalaria set mota='admin' where izena='" + pIzen + "'");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void baimenakKendu(String pIzen){
		PreparedStatement ps = null;
		try{
			ps=konexioa.prepareStatement("delete from jokalaria where izena='"+pIzen+"'");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void partidaBerriaSartu(String pKolorea, int hOrdua, int hMin, int hSeg, int bOrdua, int bMin, int bSeg,  String jokIzen, int puntuJok, int puntuOrd, boolean jokIrabazi){
		PreparedStatement ps = null;
		try{
			int kode=0;
			ps=konexioa.prepareStatement("SELECT kodea FROM partida ORDER BY kodea DESC LIMIT 1");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				kode=rs.getInt("kodea");
			}
			kode++;
			int egoera = 0;
			if (jokIrabazi) egoera = 1;
			String data = gaurkoData();
			String hasieraOrdua = hOrdua + ":" + hMin + ":" + hSeg;
			String bukaeraOrdua = bOrdua + ":" + bMin + ":" + bSeg;
			ps=konexioa.prepareStatement("insert into partida values(" + kode + ",'" + pKolorea + "','" + data + "','" + hasieraOrdua + "','" + bukaeraOrdua +"','" + jokIzen + "'," + puntuJok + "," + puntuOrd + "," + egoera + ")");
			ps.executeUpdate();
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private String gaurkoData(){
		int urtea = Calendar.getInstance().get(Calendar.YEAR);
		int hil = Calendar.getInstance().get(Calendar.MONTH)+1;
		int egun = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String data = urtea + "-" + hil + "-" + egun;
		return data;
	}
	
	public ArrayList<String>[] erabiltzaileakIkusi(){
		PreparedStatement ps = null;
		try{
			ps = konexioa.prepareStatement("select * from jokalaria");
			ResultSet rs = ps.executeQuery();
			ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[7]);
			for(int i=0;i<erabiltzaileak.length;i++){
				erabiltzaileak[i]=new ArrayList<String>();
			}
			int i = 0;
			while(i<erabiltzaileak.length){
				while(rs.next()){
					String balio = rs.getString(i+1);
					erabiltzaileak[i].add(balio);
				}
				rs.first();
				rs.previous();
				i++;
				
			}
			return erabiltzaileak;
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String>[] jokalariarenPartidaOnenak(){
		PreparedStatement ps = null;
		try{
			String email = Jokoa.getnJokoa().jokEmail();
			ps = konexioa.prepareStatement("select P.* from (partida AS P INNER JOIN jokalaria AS J ON P.jokEmail=J.email) ORDER BY P.puntuJok DESC;");
			ResultSet rs = ps.executeQuery();
			ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[9]);
			for(int i=0;i<erabiltzaileak.length;i++){
				erabiltzaileak[i]=new ArrayList<String>();
			}
			int i = 0;
			while(i<erabiltzaileak.length){
				while(rs.next()){
					String balio = rs.getString(i+1);
					erabiltzaileak[i].add(balio);
				}
				rs.first();
				rs.previous();
				i++;
				
			}
			return erabiltzaileak;
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String>[] egunekoPartidaOnenak(){
		PreparedStatement ps = null;
		try{
			String email = Jokoa.getnJokoa().jokEmail();
			ps = konexioa.prepareStatement("(SELECT puntuJok FROM partida WHERE data=CURDATE()) UNION (SELECT puntuOrd FROM partida WHERE data=CURDATE()) ORDER BY puntuJok DESC"); //ez dakigu norenak diren
			ResultSet rs = ps.executeQuery();
			ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[1]);
			for(int i=0;i<erabiltzaileak.length;i++){
				erabiltzaileak[i]=new ArrayList<String>();
			}
			int i = 0;
			while(i<erabiltzaileak.length){
				while(rs.next()){
					String balio = rs.getString(i+1);
					erabiltzaileak[i].add(balio);
				}
				rs.first();
				rs.previous();
				i++;
				
			}
			return erabiltzaileak;
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String>[] historikokiPartidaOnenak(){
		PreparedStatement ps = null;
		try{
			String email = Jokoa.getnJokoa().jokEmail();
			ps = konexioa.prepareStatement("SELECT * FROM partida ORDER BY puntuJok DESC");
			ResultSet rs = ps.executeQuery();
			ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[9]);
			for(int i=0;i<erabiltzaileak.length;i++){
				erabiltzaileak[i]=new ArrayList<String>();
			}
			int i = 0;
			while(i<erabiltzaileak.length){
				while(rs.next()){
					String balio = rs.getString(i+1);
					erabiltzaileak[i].add(balio);
				}
				rs.first();
				rs.previous();
				i++;
				
			}
			return erabiltzaileak;
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String>[] batezBestekoPartidaOnenak(){
		PreparedStatement ps = null;
		try{
			String email = Jokoa.getnJokoa().jokEmail();
			ps = konexioa.prepareStatement("SELECT izena FROM jokalaria INNER JOIN partida ON jokEmail=email WHERE egoera=1 GROUP BY ORDER BY AVG(puntuJok) DESC");
			ResultSet rs = ps.executeQuery();
			ArrayList<String>[] erabiltzaileak =  (ArrayList<String>[])(new ArrayList[1]);
			for(int i=0;i<erabiltzaileak.length;i++){
				erabiltzaileak[i]=new ArrayList<String>();
			}
			int i = 0;
			while(i<erabiltzaileak.length){
				while(rs.next()){
					String balio = rs.getString(i+1);
					erabiltzaileak[i].add(balio);
				}
				rs.first();
				rs.previous();
				i++;
				
			}
			return erabiltzaileak;
		}catch(MySQLSyntaxErrorException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
