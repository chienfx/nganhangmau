package ChooseProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import ConnectDB.connectDB;

public class showEmployee {

	static Connection conn = null;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		
	}
	
	public static void showemployee() throws Exception{
		conn = connectDB.getConnection();

		try {
			String sql = "Select EiD,Ename from employee";

			PreparedStatement show = conn.prepareStatement(sql);

			ResultSet kt = show.executeQuery(sql);

			System.out.println("***********************************************************************************************");
			System.out.println("*-----------------------------------------   Employee   --------------------------------------*");
			System.out.println("*  Eid |            Ename               |                                                     *");
			System.out.println("*---------------------------------------------------------------------------------------------*");

			while(kt.next()) {
				int id = kt.getInt("EiD");
				String name = kt.getString("Ename");

				System.out.printf("*%5s | %30s |                                                     *\n",id,name);
			}
			System.out.println("***********************************************************************************************");
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
