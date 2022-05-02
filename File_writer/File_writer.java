package File_writer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class File_writer {

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

			schueler.writeSchueler(c, "C:\\Users\\marco\\Desktop\\Schule\\3AHWII_Runde2\\INFI\\Writeperson.csv");
			klassen.writeKlassen(c, "C:\\Users\\marco\\Desktop\\Schule\\3AHWII_Runde2\\INFI\\Writeklassen.csv");

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
