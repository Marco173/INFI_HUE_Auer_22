package Kunden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner { 
	

	static Connection getConnection()  throws ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/kaufland";
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
		
		dropTable(c, "Kunden");
		dropTable(c, "Artikel");
		dropTable(c, "Bestellung");
		
		Kunden.createTable(c, "Kunden");
		Artikel.createTable(c, "Artikel");
		Bestellung.createTable(c, "Bestellung");
		
		Kunden.insertInto(c, "Kunden", "Marco", "marcoauer@tsn.at");
		Kunden.insertInto(c, "Kunden", "Simon", "skleinlechner@tsn.at");
		Artikel.insertInto(c, "Artikel", "Bike", 2500, 2);
		Artikel.insertInto(c, "Artikel", "Handschuhe", 35, 30);
		Bestellung.insertInto(c, "Bestellung", 1, 1, 15);
		Bestellung.insertInto(c, "Bestellung", 1, 2, 3);
		
		Bestellung.showBestellung(c, "Bestellung", 1);
		Bestellung.showBestellung(c, "Bestellung", 2);
		
		Bestellung.deleteBestellung(c, "Bestellung", 1);
		Bestellung.updateBestellung(c, "Bestellung", 2, 5);
		Bestellung.showBestellung(c, "Bestellung", 2);
	}
	
	static public void dropTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement(); 
			String sql = "drop table if exists " + tableName + ";";
			System.out.println("Tabelle " + tableName + " wurde gelöscht.");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	}

