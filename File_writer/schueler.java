package File_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class schueler {
	 
	static void writeSchueler(Connection c, String file) {
		try {
			File f = new File(file);
			FileWriter fw = new FileWriter(f);
			Statement stmt = c.createStatement();
			String sql = "select vorname, nachname from person;";
			ResultSet rs = stmt.executeQuery(sql);
			int x = 1; //Variable
			System.out.println();System.out.println("Schueler:");

			while (rs.next()) {
				String vn = rs.getString("vorname");
				String nn = rs.getString("nachname");
				String s =  vn + ", " + nn + ", \n";
				fw.write(s);
				String output =  vn + "|" + nn + "|";
				System.out.println(output);
				x++;
			}
			
			rs.close();
			stmt.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
