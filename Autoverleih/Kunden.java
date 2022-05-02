package Autoverleih;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Kunden {
	
	static void createTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement();
			String sql = "create table if not exists " + tableName
					+ " (id integer auto_increment,nachname varchar(40),email varchar(30),primary key(id));";
			System.out.println("Tabelle " + tableName + " wurde erstellt.");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	static void insertInto(Connection c, String name, String email) {
		String sql = "insert into kunde (nachname, email) values (?,?);";
		try {
			PreparedStatement stmt = c.prepareStatement(sql); 
			stmt.setString(1, name); 
			stmt.setString(2, email);  
			System.out.println("Insert Kunde war erfolgreich"); 
			System.out.println("\n");
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
			
		
	}

}
