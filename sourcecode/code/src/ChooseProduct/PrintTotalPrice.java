package ChooseProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConnectDB.connectDB;

public class PrintTotalPrice{
	static Connection conn = null;
	
	public static void main(String[] args) throws Exception {
		
	}
	
	public static void printtotalprice() throws Exception{
		conn = connectDB.getConnection();

		try {
			
			
			String sql10 = "select TotalPrice from invoice where IniD = (select IniD from invoice order by IniD desc limit 1)"; 
			PreparedStatement tobill10 = conn.prepareStatement(sql10);
			ResultSet kt10 = tobill10.executeQuery(sql10);
			
			System.out.print("*-Total: ");
			if(kt10.next()) {
			int total = kt10.getInt("TotalPrice");
			System.out.println(total + " VND --------------------------------------------------------------------------*");
			System.out.println("**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			}
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
}
}
