package Autoverleih;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Auto {
	
	static void createtable(Connection c, String tablename) { 
		try {
			Statement stmt = c.createStatement();
			String sql = "create table if not exists " + tablename + "(kennzeichen varchar(40), "
					+ " marke varchar(40), ps int, baujahr int, primary key (kennzeichen));";
			System.out.println("Table " + tablename + " wurde erstellt"); 
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	static void insertinto(Connection c, String kennzeichen,String marke,int ps,int baujahr) {  
			String sql ="insert into auto (kennzeichen,marke,ps,baujahr) values (?,?,?,?);"; 
		try {
			PreparedStatement stmt = c.prepareStatement(sql); 
			stmt.setString(1, kennzeichen); 
			stmt.setString(2, marke); 
			stmt.setInt(3, ps); 
			stmt.setInt(4, baujahr); 
			System.out.println("Insert Auto war erfolgreich"); 
			System.out.println("\n");
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}
