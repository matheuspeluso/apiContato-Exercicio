package aluno.Matheus.Peluso.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String host = "jdbc:postgresql://localhost:5432/bd_apicontatos";
	private static String user = "postgres";
	private static String pass = "0505";
	
	public static Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(host,user,pass);
	}
}
