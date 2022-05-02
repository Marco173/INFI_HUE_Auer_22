package Schule;

import java.sql.Connection;
import java.sql.Statement;

public class Schueler {

	static void createTable(Connection c, String tablename) {
		try {
			Statement stmt = c.createStatement();
			String sql = "create table if not exists " + tablename + "(id int auto_increment,"
					+ " vorname varchar(40), nachname varchar(40), primary key (id));";
			System.out.println("Table " + tablename + " wurde erstellt"); 
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	static void insertInto(Connection c, String vorname, String nachname) {
		try {
			Statement stmt = c.createStatement();
			String sql = "Insert into schueler (vorname,nachname) values (\""+ vorname + "\",\"" + nachname + "\");";
			System.out.println("Insert Schüler: " + vorname + " " + nachname + " war erfoglreich");
			System.out.println("\n");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
