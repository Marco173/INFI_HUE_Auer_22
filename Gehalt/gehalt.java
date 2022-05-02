package Gehalt;

import java.sql.*; 


public class gehalt {


	public static void main(String[] args) {
		Connection c = getConnection();
		createTable(c, "firstTest");
		insertIntoTable(c, "firstTest", "Herbert", 679);
		insertIntoTable(c, "firstTest", "Fritz", 4500);
		insertIntoTable(c, "firstTest", "Julian", 500);
		System.out.printf("Gesammter Betrag der Gehälter: %d\n", gesamtGehalt(c, "firstTest"));
	}

	public static Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:firstTest.db");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Datenbank wurde nicht gefunden!");
			System.exit(1);
			return null;
		}
	}

	public static void createTable(Connection c, String tableName) {
		Statement stmt;
		try {
			stmt = c.createStatement();
			String sql = "create table if not exists " + tableName +
					" (name varchar(32), gehalt int);";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Table wurde " + tableName + " erstellt!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertIntoTable(Connection c, String tableName, String name, int gehalt) {
		Statement stmt;
		try {
			stmt = c.createStatement();
			String sql = "insert into " + tableName + " values" +
					" (\"" + name + "\", " + gehalt + ");";
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Inserts wurden ausgeführt!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int gesamtGehalt(Connection c, String tableName) {
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select sum(gehalt) from " + tableName + ";");
			int gesamtGehalt = rs.getInt("sum(gehalt)");
			rs.close();
			stmt.close();
			return gesamtGehalt;
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return 0;
	}
}