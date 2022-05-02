package Schule;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Klassen {
	
	static void createTable(Connection c, String tablename) { 
		try { 
			Statement stmt = c.createStatement(); 
			String sql = "create table if not exists " + tablename 
					+"(id int  auto_increment,"
					+ " klasse varchar(40), anzahl_schueler int , primary key(id));"; 
			System.out.println("Table " + tablename + " wurde erstellt "); 
			System.out.println('\n');
			stmt.executeUpdate(sql); 
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	} 
	
	static void insertInto(Connection c , String klasse, int anzahl_schueler) { 
		try {
			Statement stmt = c.createStatement(); 
			String sql = "Insert into klasse (klasse , anzahl_schueler) values (\"" + klasse + "\"," + anzahl_schueler + ");"; 
			System.out.println("Insert der Klasse:"+ klasse + "war erfolgreich"); 
			System.out.println("\n");
			stmt.executeUpdate(sql); 
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
