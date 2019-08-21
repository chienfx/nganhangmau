package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	public static void main(String[] args) throws Exception {
		
	}

	public static Connection getConnection() throws Exception{
		
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/quanlytrasua";
			String username = "root";
			String password = "";
			
			try {	
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}

}
