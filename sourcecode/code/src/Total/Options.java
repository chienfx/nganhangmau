package Total;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import ConnectDB.connectDB;

public class Options {

	static Connection conn = null;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		option();
	}

	public static void option() throws Exception{
		conn = connectDB.getConnection();

		try {
			int choice;

			System.out.print("Please select Invoice ID: "); choice = input.nextInt();

			String sql1 = "select bill.CiD, bill.EiD, Pname, Quantity, bill.Note, Price, Ename, Cname, Address, Tel from bill "
					+ "inner join employee on bill.EiD = employee.EiD "
					+ "inner join customer on bill.CiD = customer.CiD"
					+ " where IniD = '"+ choice + "'";

			PreparedStatement show1 = conn.prepareStatement(sql1);
			ResultSet kt1 = show1.executeQuery(sql1);

			if(kt1.next()) {
				String ename = kt1.getString("Ename");
				String cname = kt1.getString("Cname");
				String address = kt1.getString("Address");
				int tel = kt1.getInt("Tel");

				System.out.println("Employee: " + ename);
				System.out.println("Customer: " + cname);
				System.out.println("Address: " + address);
				System.out.println("Tel: "+ tel);
			}

			String sql = "select bill.CiD, bill.EiD, Pname, Quantity, bill.Note, Price, Ename, Cname, Address from bill "
					+ "inner join employee on bill.EiD = employee.EiD "
					+ "inner join customer on bill.CiD = customer.CiD"
					+ " where IniD = '"+ choice + "'";

			PreparedStatement show = conn.prepareStatement(sql);
			ResultSet kt = show.executeQuery(sql);
			System.out.println("***********************************************************************************************");
			System.out.println("*         Name         |     Quantity    |         Note         |       Price     |           *");
			System.out.println("*---------------------------------------------------------------------------------------------*");
			while(kt.next()) {
				String name = kt.getString("Pname");
				int quantity = kt.getInt("Quantity");
				String note = kt.getString("Note");
				int price = kt.getInt("Price");

				System.out.printf("* %20s | %15s | %20s | %15s |           *\n", name, quantity, note, price);
			}
			System.out.println("***********************************************************************************************");

			String sql2 = "select bill.CiD, bill.EiD, Pname, Quantity, bill.Note, Price, Ename, Cname, Address, Tel, TotalPrice from bill "
					+ "inner join employee on bill.EiD = employee.EiD "
					+ "inner join customer on bill.CiD = customer.CiD "
					+ "inner join invoice on bill.IniD = invoice.IniD"
					+ " where bill.IniD = '"+ choice + "'";

			PreparedStatement show2 = conn.prepareStatement(sql2);
			ResultSet kt2 = show2.executeQuery(sql2);

			if(kt2.next()) {
				int total = kt2.getInt("TotalPrice");
				System.out.println("");
				System.out.println("Total Price: "+total);
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
