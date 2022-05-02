package Kunden; 

import java.sql.*;

public class Bestellung{

	static void createTable(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement();
			String sql = "create table if not exists " + tableName
					+ " (id integer primary key autoincrement, kundeID integer, "
					+ "artikelID integer, anzahl integer, foreign key (kundeID) "
					+ "references Kunde (id), foreign key (artikelID) references " + "Artikel (id));";
			System.out.println("Tabelle " + tableName + " wurde erstellt.");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	static void insertInto(Connection c, String tableName, int kundeID, int artikelID, int anzahl) {
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select lagerbestand from Artikel where id = " + artikelID + ";");
			int lagerbestand = rs.getInt("lagerbestand");
			rs.close();
			if (anzahl <= lagerbestand) {
				String sql = "insert into " + tableName + " (kundeID, artikelID, anzahl) values " +
					"(" + kundeID + ", " + artikelID + ", " + anzahl + ");";
				System.out.println("insert --> Bestellung.");
				stmt.executeUpdate(sql);
			} else {
				System.out.println("Lagerbestand zu niedrig!");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void showBestellung(Connection c, String tableName, int id) {
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select kundeID from Bestellung where id = " + id + ";");
			int xKunde = rs.getInt("kundeID");
			rs.close();
			ResultSet rs2 = stmt.executeQuery("select artikelID from Bestellung where id = " + id + ";");
			int xArtikel = rs.getInt("artikelID");
			rs2.close();
			ResultSet rs3 = stmt.executeQuery("select bezeichnung from Artikel where id = " + xArtikel + ";");
			String strBezeichnung = rs3.getString("bezeichnung");
			rs3.close();
			ResultSet rs4 = stmt.executeQuery("select name from Kunde where id = " + xKunde + ";");
			String strName = rs4.getString("name");
			rs4.close();
			ResultSet rs5 = stmt.executeQuery("select anzahl from Bestellung where id = " + id + ";");
			int strAnzahl = rs5.getInt("anzahl");
			System.out.println("Bestellung " + id + ":\nName: " + strName + "\nBezeichnung: " + strBezeichnung
					+ "\nAnzahl: " + strAnzahl);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void deleteBestellung(Connection c, String tableName, int id) {
		try {
			Statement stmt = c.createStatement();
			String sql = "delete from Bestellung where id = " + id + ";";
			System.out.println("Bestellung " + id + " wurde gelöscht.");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void updateBestellung(Connection c, String tableName, int id, int anzahl) {
		try {
			Statement stmt = c.createStatement();
			String sql = "update " + tableName + " set anzahl = " + anzahl + " where id = " + id + ";";
			System.out.println("update --> Bestellung.");
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}