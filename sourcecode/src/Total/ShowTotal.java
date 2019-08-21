package Total;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConnectDB.connectDB;
import Total.Options;

public class ShowTotal {
	static Connection conn = null;
	
	public static void main(String[] args) throws Exception{
		show_total();
	}
		
	public static void show_total() throws Exception{
		conn = connectDB.getConnection();
		
		
		try {
			String sql = "Select IniD, Date, TotalPrice from invoice";
			PreparedStatement show = conn.prepareStatement(sql);
			ResultSet kt = show.executeQuery(sql);
			System.out.println("***********************************************************************************************");
			System.out.println("*  ID   |        Date         |        Price         |                                        *");
			System.out.println("*---------------------------------------------------------------------------------------------*");
			while(kt.next()) {
				int id = kt.getInt("IniD");
				Date date = kt.getDate("Date");
				int price = kt.getInt("TotalPrice");
				
				System.out.printf("* %5s | %20s| %20s |                                        *\n", id, date, price);
			}
			System.out.println("***********************************************************************************************");
			System.out.println("");
			Options.option();
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
