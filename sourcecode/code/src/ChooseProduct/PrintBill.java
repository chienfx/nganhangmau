package ChooseProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConnectDB.connectDB;

public class PrintBill {

	static Connection conn = null;

	public static void main(String[] args) throws Exception{

	}

	public static void printbill() throws Exception{
		conn = connectDB.getConnection();

		try {

			System.out.println("To pay a bill");
			System.out.println("");
			System.out.println("***********************************************************************************************");

			java.util.Date date=new java.util.Date();

			String sql = "select bill.CiD, bill.EiD, Pname, Quantity, bill.Note, Price, Ename, Cname, Address, Tel from bill "
					+ "inner join employee on bill.EiD = employee.EiD "
					+ "inner join customer on bill.CiD = customer.CiD"
					+ " where IniD = (select IniD from invoice order by IniD desc limit 1) and bill.CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
			PreparedStatement tobill = conn.prepareStatement(sql);
			ResultSet kt = tobill.executeQuery(sql);

			if(kt.next()) {
				String ename = kt.getString("Ename");
				String cname = kt.getString("Cname");
				String address = kt.getString("Address");
				int tel = kt.getInt("Tel");

				System.out.println("*- Employee: "+ename);
				System.out.println("*- Customer: "+cname);
				System.out.println("*- Address: "+address);
				System.out.println("*- Tel: "+tel);
			}

			System.out.println("*- " + date + " --------------------------------------------------------------*");
			System.out.println("*---------------------------------------------------------------------------------------------*");
			System.out.println("*---------------------------------------------------------------------------------------------*");
			System.out.println("*                                                                                             *");

			String sql9 = "select Pname, Quantity, Note, Price from bill where IniD = (select IniD from invoice order by IniD desc limit 1) and CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
			PreparedStatement tobill9 = conn.prepareStatement(sql9);
			ResultSet kt9 = tobill9.executeQuery(sql9);

			System.out.println("*        Name        | Quantity |      Note     |    Price   |                                *");
			System.out.println("*---------------------------------------------------------------------------------------------*");

			while(kt9.next()) {
				String name = kt9.getString("Pname");
				int quantity = kt9.getInt("Quantity");
				String note = kt9.getString("Note");
				int price = kt9.getInt("Price");


				System.out.printf("* %10s | %5s \t| %10s \t| %10s |                                *\n", name, quantity, note, price);

			}
			System.out.println("***********************************************************************************************");

			System.out.println("");
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
