package Autoverleih;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class autoverleih {
	
	
	static void createTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement();
			String sql = "create table if not exists " + tableName + " (kId int, kz varchar(40), " +
			"verleih_start date, verleih_ende date , primary key (kId, kz), "
			+ "foreign key (kId) references kunde (id), " +
			"foreign key (kz) references auto (kennzeichen));";
			System.out.println("Tabelle " + tableName + " wurde erstellt.");
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insertInto(Connection c, int kId, String kz, LocalDate st, LocalDate en) {
		Date d = Date.valueOf(st); 
		Date u = Date.valueOf(en);
		java.sql.Date localdate = new java.sql.Date(d.getTime());  
		java.sql.Date locadate  = new java.sql.Date(u.getTime());
		String sql = "insert into autoverleih (kId, kz, verleih_start, verleih_ende) values (?, ?, ?, ?);";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, kId);
			stmt.setString(2, kz); 
			stmt.setDate(3, localdate);
			stmt.setDate(4, locadate);
			System.out.println("Insert war erfolgreich"); 
			System.out.println("\n");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
