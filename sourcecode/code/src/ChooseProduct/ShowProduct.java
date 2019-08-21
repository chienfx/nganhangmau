package ChooseProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import ConnectDB.connectDB;

public class ShowProduct {
    static Connection conn = null;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		showproduct();
	}
	
	public static void showproduct() throws Exception{
		conn = connectDB.getConnection();

		try {
			String sql = "Select * from product";

			PreparedStatement show = conn.prepareStatement(sql);

			ResultSet kt = show.executeQuery(sql);

			System.out.println("***********************************************************************************************");
			System.out.println("*  Pid |            Pname               |  Quantity  |   Price   |                            *");
			System.out.println("*---------------------------------------------------------------------------------------------*");

			while(kt.next()){
				int Pid = kt.getInt("Pid");
				String Pname = kt.getString("Pname");
				int Quantity = kt.getInt("Quantity");
				int Price = kt.getInt("Price");


				System.out.printf("*%5s | %30s | %10s |%10s |                            *\n",Pid,Pname,Quantity,Price);

			}
			System.out.println("***********************************************************************************************");
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

