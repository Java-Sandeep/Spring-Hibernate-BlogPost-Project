package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection con = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3390/spring", "root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
