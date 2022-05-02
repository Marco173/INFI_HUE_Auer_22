package Autoverleih;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Runner {
	
	
	static Connection getConnection()  throws ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/autoverleih?seTimezone=true&serverTimezone=UTC";
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
		
		/*drop
		dropTable(c, "kunde"); 
		*/
	//Creates
	//Auto.createtable(c, "auto");v
	//Kunden.createTable(c, "kunde");
	//autoverleih.createTable(c, "autoverleih");
		
	//Inserts	
	//	Auto.insertinto(c, "IL-727NA", "VW", 95, 2015);
		//Kunden.insertInto(c, "Auer", "marco.auer99@gmail.com"); 
	//autoverleih.insertInto(c, 1, "IL-727NA", LocalDate.of(2022, 03, 14), LocalDate.of(2022, 04, 10));
	
		//Auto.insertinto(c, "IL-456D", "Audi", 200, 2020); 
		//Kunden.insertInto(c, "Jungman", "Julian.jungman@gmail.com");  
		//autoverleih.insertInto(c, 2, "IL-456D", LocalDate.of(2022, 3, 15), LocalDate.of(2022, 5, 30));
		
	}
	
	
	
	

	static public void dropTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement(); 
			String sql = "drop table if exists " + tableName + ";";
			System.out.println("Tabelle " + tableName + " wurde gelöscht."); 
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
