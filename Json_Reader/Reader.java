package Json_Reader;

import java.sql.*;

public class Reader {

	
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
			
			Person.read(c, "C:\\Users\\marco\\Desktop\\Schule\\3AHWII_Runde2\\INFI\\json_reader.txt", "person");
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
