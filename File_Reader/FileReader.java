package File_Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FileReader {

	static Connection getConnection(String url, String user, String pass) {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/csvreader?seTimezone=true&serverTimezone=UTC";
			String user = "root";
			String pass = "Marco123";

			Connection c = getConnection(url, user, pass);

			// insertschuler(c);
			insertklassen(c);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static void insertschuler(Connection c) throws FileNotFoundException {
		try {
			File f = new File("C:\\Users\\marco\\Desktop\\Schule\\3AHWII_Runde2\\INFI\\Insertperson.csv");
			Scanner s = new Scanner(f);
			String string = "";
			int i = 0;

			while (s.hasNextLine()) {
				string = s.nextLine();
				String[] str = string.split(";");
				String sql = "insert into person (vorname, nachname) values (?, ?);";
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1, str[0]);
				stmt.setString(2, str[1]);
				stmt.executeUpdate();
				stmt.close();
				System.out.printf("insert Schüler war Erfolgreich");
				System.out.println("\n");
				i++;
			}
			s.close();

		} catch (SQLException e) {

		}
	}

	static void insertklassen(Connection c) throws FileNotFoundException {
		try {
			File f1 = new File("C:\\Users\\marco\\Desktop\\Schule\\3AHWII_Runde2\\INFI\\Insertklassen.csv");
			Scanner s1 = new Scanner(f1);
			String string1 = "";
			int e = 0;

			while (s1.hasNextLine()) {
				string1 = s1.nextLine();
				String[] str2 = string1.split(";");
				String sql1 = "insert into klassen (klassenname, Raum) values (?, ?);";
				PreparedStatement stmt = c.prepareStatement(sql1);
				stmt.setString(1, str2[0]);
				stmt.setString(2, str2[1]);
				stmt.executeUpdate();
				stmt.close();
				System.out.printf("insert Klassen war Erfolgreich");
				System.out.println("\n");
				e++;
			}
			s1.close();

		} catch (SQLException e) {

		}
	}

}
