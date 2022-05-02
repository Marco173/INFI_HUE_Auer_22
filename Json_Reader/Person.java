package Json_Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Person {

	static void read(Connection c, String file, String tableName) {
		try {
			File f = new File(file);
			Scanner scanner = new Scanner(f);
			String data = "";
			while (scanner.hasNextLine()) {
				data = scanner.nextLine();
				Object o = new JSONParser().parse(data);
				JSONObject j = (JSONObject) o;
				
				String vorname = (String)j.get("vorname");
				String nachname = (String)j.get("nachname");
				
				
				String sql = "insert into " + tableName + " (vorname, nachname) values (?, ?);";
				
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1, vorname);
				stmt.setString(2, nachname);
				stmt.executeUpdate();
				stmt.close();
				System.out.printf("Vorname: %s\nNachname: %s\n", vorname, nachname);
				System.out.println();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File wurde nicht gefunden.");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}