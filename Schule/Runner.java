package Schule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Runner {

	
	static Connection getConnection()  throws ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/schule?seTimezone=true&serverTimezone=UTC";
		String user = "root";
		String pass = "Marco123";

		try {
		    return // Verbindung aufbauen
		    	DriverManager.getConnection(url, user, pass);
		   
		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
		return null;
	} 
	
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c = getConnection(); 
		
		//dropTable(c, "schueler");
		//dropTable(c, "Klasse"); 
		//dropTable(c, "klasenschueler");
	
		//Schueler.createTable(c, "schueler"); 
		//Klassen.createTable(c, "Klasse"); 
		//klassen_schueler.createTable(c, "klassenschueler"); 
		
		//Klassen.insertInto(c, "3AHWII", 24); 
		//Klassen.insertInto(c, "2AHWII", 20); 
		//Klassen.insertInto(c, "1AHWII", 27);
		//klassen_schueler.insertInto(c, 1, 1, LocalDate.now()); 
		
		//Schueler.insertInto(c, "Marco", "Auer");
		Schueler.insertInto(c, "Valentin", "Hörtnagl"); 
		Schueler.insertInto(c, "Simon", "Kleinlechner"); 
		
		//klassen_schueler.insertInto(c, 2, 1, LocalDate.now());
		
	}  
	
	static public void dropTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement(); 
			String sql = "drop tables if exists " + tableName + ";";
			System.out.println("Tabelle " + tableName + " wurde gelöscht."); 
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
