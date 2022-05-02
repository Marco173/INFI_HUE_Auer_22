package Json_Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import org.json.JSONObject;


public class Person {
	

		static void write(Connection c, String file) {
			try {
				FileWriter fw = new FileWriter(file);
				JSONObject j = new JSONObject();
				String s = "";

				Statement stmt = c.createStatement();
				String sql = "select vorname, nachname, age, gehalt from mitarbeiter;";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					String vorname = rs.getString("vorname");
					String nachname = rs.getString("nachname");
					int age = rs.getInt("age");
					int gehalt = rs.getInt("gehalt");
					
					j.put("vorname", vorname);
					j.put("nachname", nachname);
					j.put("age", age);
					j.put("gehalt", gehalt);
					
					s = s + j;
				}
				fw.write(s); 
				fw.flush();
				fw.close();
				rs.close();
				stmt.close();
				System.out.println("funktioniert");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
