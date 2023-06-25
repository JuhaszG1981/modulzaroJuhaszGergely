package feladat2;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Dbkezelo {
	
	private static Connection connection;
	private static PreparedStatement sqlCommand; 
	private Dbkezelo() {
	}
	
	public static void connectToDB() throws SQLException {
		try {
			
			String connectionString = "jdbc:mysql://127.0.0.1:3306/ingatlan_db?autoReconnect=true&useSSL=false";
			connection = DriverManager.getConnection(connectionString, "root","Ruander2023");
			
		} catch (Exception e) {
			
			throw new SQLException("sikertelen kapcsolódás");
			
		}
	}
	
	public static void disconnectFromDB() throws SQLException {
	try {
		connection.close();
	} catch (Exception e) {
		throw new SQLException("Kapcsolat bontása sikertelen");
	}
	}
	
	public static void newHouse(Ingatlan ingatlan) throws SQLException {
		//tulajdonos, hrsz, alapterulet, ar
		try {
			
			sqlCommand = connection.prepareStatement("INSERT INTO ingatlanok(tulajdonos, hrsz, alapterulet, ar) VALUES (?,?,?,?)");
			sqlCommand.setString(1, ingatlan.getTulajdonos()); 
			sqlCommand.setString(2, ingatlan.getHrsz());
			sqlCommand.setInt(3, ingatlan.getAlapterulet());
			sqlCommand.setInt(4, ingatlan.getAr());
			sqlCommand.executeUpdate();
			sqlCommand.clearParameters();
			
		} catch (Exception e) {
			
			throw new SQLException("Hiba miatt a Mentés sikertelen");	
			}
		
	}
	
		public static void modHouse(Ingatlan ingatlan) throws SQLException {
		
		try {
			sqlCommand = connection.prepareStatement("UPDATE ingatlanok SET ar=?  WHERE hrsz=?");
			sqlCommand.setInt(1, ingatlan.getAr());
			sqlCommand.setString(2, ingatlan.getHrsz());
			
			sqlCommand.executeUpdate();
			
			sqlCommand.clearParameters();
			
		} catch (Exception e) {
			
				throw new SQLException("adatbázis módosítása sikertelen");
			
		}
	
		}
	public static void delHouse(Ingatlan ingatlan) throws SQLException {
		try {
			
			sqlCommand = connection.prepareStatement("DELETE FROM ingatlanok WHERE hrsz=?");
			sqlCommand.setString(1, ingatlan.getHrsz());
			sqlCommand.executeUpdate();
			sqlCommand.clearParameters();
			
		} catch (Exception e) {
			throw new SQLException("adatbázisban történő törlés sikertelen");
		}
		
		
	}
	
	
	
	public static List<Ingatlan> readHouse() throws SQLException{
		//tulajdonos, hrsz, alapterulet, ar
		try {
			List<Ingatlan> ingatlanok = new ArrayList<Ingatlan>();
			sqlCommand = connection.prepareStatement("SELECT * FROM ingatlanok");
			ResultSet res = sqlCommand.executeQuery();
			while (res.next()) {
				ingatlanok.add(new Ingatlan(res.getString("tulajdonos"), res.getString("hrsz"), res.getInt("alapterulet"), res.getInt("ar")));
			}
			res.close();
			return ingatlanok;
		} catch (Exception e) {
			throw new SQLException("adatbázis beolvasás sikertelen");
		}
	}

}
