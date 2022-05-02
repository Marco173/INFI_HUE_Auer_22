package Schule;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class klassen_schueler {
	
	
	static void createTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement();
			String sql = "create table if not exists " + tableName + " (sId int, kId int, " +
			"eintragsdatum date, primary key (sId, kId, eintragsdatum), foreign key (sId) references schueler (id), " +
			"foreign key (kId) references klasse (id));";
			System.out.println("Tabelle " + tableName + " wurde erstellt.");
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	static void insertInto(Connection c, int sId, int kId, LocalDate ld) {
		Date d = Date.valueOf(ld);
		java.sql.Date localdate = new java.sql.Date(d.getTime()); 
		String sql = "insert into klassenschueler (sId, kId, eintragsdatum) values (?, ?, ?);";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, sId);
			stmt.setInt(2, kId); 
			stmt.setDate(3, localdate);
			System.out.println("Inset war erfolgreich"); 
			System.out.println("\n");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



