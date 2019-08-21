package ChooseProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import ChooseProduct.ShowProduct;
import ChooseProduct.showEmployee;
import ConnectDB.connectDB;
import ChooseProduct.PrintBill;
import ChooseProduct.PrintTotalPrice;

public class ToBill {

	static Connection conn = null;

	public static void main(String[] args) throws Exception {
		
	}

	public static void ToBill() throws Exception {
		conn = connectDB.getConnection();

		Scanner input = new Scanner(System.in);

		try {
			int PiD;
			String Cname;
			String Address;
			int Tel;
			int EiD;
			int Quantity;

			showEmployee.showemployee();
			
			System.out.print("Employee: "); EiD = input.nextInt();
			System.out.println("");
			
			System.out.print("Customer: ");input.nextLine(); Cname = input.nextLine();
			System.out.print("Address: "); Address = input.nextLine();
			System.out.print("Phone number:"); Tel = input.nextInt();
			
			String sql1 = "Insert into customer(`Cname`,`Address`,`Tel`)" 
			+ "value('" + Cname + "','" + Address + "','"+ Tel + "')";
			PreparedStatement tobill1 = conn.prepareStatement(sql1);
			int kt1 = tobill1.executeUpdate();	
			
//show product
			ShowProduct.showproduct();
			
			while(kt1 != 0) {
				System.out.print("Select product: ");
				PiD = input.nextInt();
				System.out.println("");
				
			if(PiD != 0) {
				// chon so luong
				System.out.print("Quantity: "); Quantity = input.nextInt();
				System.out.println("");

				// nhap customer
				String sql2 = 
				 "Insert into bill(`CiD`,`PiD`,`EiD`,`Pname`,`Quantity`,`Price`)"
				 + "select CiD, PiD, EiD, product.Pname," + Quantity + ", "+ Quantity +"*product.Price from customer,product,employee where CiD = (select CiD from customer where CiD order by CiD desc limit 1) and EiD = " + EiD +" and PiD = " + PiD +"";

				PreparedStatement tobill2 = conn.prepareStatement(sql2);
				int kt2 = tobill2.executeUpdate();
				
				//them topping
				int optiontopping;
				System.out.println("***********************************************************************************************");
				System.out.println("*                              ---do you want add topping ?---                                *");
				System.out.println("*                              |  1  |         yes           |                                *");
				System.out.println("*                              |  2  |         no            |                                *");
				System.out.println("*                              -------------------------------                                *");
				System.out.println("***********************************************************************************************");
				System.out.print("Select: "); optiontopping = input.nextInt();
				System.out.println("");
				
				switch(optiontopping) {
				case 1:
					System.out.println("Add Topping");
					String sql3 = "update bill set Note = 'Add topping' where CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
					PreparedStatement tobill3 = conn.prepareStatement(sql3);
					int kt3 = tobill3.executeUpdate();
					
					String sql4 = "update bill set Price = Price + 5000 where CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
					PreparedStatement tobill4 = conn.prepareStatement(sql4);
					int kt4 = tobill4.executeUpdate();
					
					break;
				case 2: 
					System.out.println("No topping");
					String sql5 = "update bill set Note = 'No topping' where CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
					PreparedStatement tobill5 = conn.prepareStatement(sql5);
					int kt5 = tobill5.executeUpdate();
					System.out.println("");
					
					break;
				} // end topping
				
				System.out.println("Order continue  (select 0 break)");
				System.out.println("");
			}
			
			else {
				//tong gia		
				Statement tonggia = null;
				tonggia = conn.createStatement();
				
				ResultSet rs = null;
				
				
				String sql6 = "select Price from bill where CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
				rs = tonggia.executeQuery(sql6);
				
				
				int tong = 0;
				while(rs.next()) {
					
					tong = tong + rs.getInt("Price");
				}
				
				String sql7 = "Insert into invoice(TotalPrice)"
				+ "value ("+ tong +")";
				PreparedStatement tobill7 = conn.prepareStatement(sql7);
				int kt7 = tobill7.executeUpdate();
		
				String sql8 = "update bill set IniD = (select IniD from invoice where IniD order by IniD desc limit 1) where CiD = (select CiD from customer where CiD order by CiD desc limit 1)";
				PreparedStatement tobill8 = conn.prepareStatement(sql8);
				int kt8 = tobill8.executeUpdate();
				// end tong gia
				
				//in bill
				PrintBill.printbill();
				PrintTotalPrice.printtotalprice();
				
				System.out.println("");
				break;
			}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}
