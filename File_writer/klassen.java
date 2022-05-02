package File_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class klassen {
	
	static void writeKlassen(Connection c, String file) {
		try {
			File f = new File(file);
			FileWriter fw = new FileWriter(f);
			Statement stmt = c.createStatement();
			String sql = "select klassenname, Raum  from klassen;";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println();System.out.println("Klassen:");
			
			while (rs.next()) {
				String kl = rs.getString("klassenname");
				String r = rs.getString("Raum");
				String s =  kl + ", "  + r +  "\n";
				fw.write(s);
				String output =  kl + "|" + r + "|";
				System.out.println(output);
			
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
