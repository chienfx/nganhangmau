/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditProduct;

/**
 *
 * @author PC
 */
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import MainMenu.GetLine;
import connected.connectDB;
public class themDB {
    
    Connection conn = null;
    PreparedStatement ptmt = null;
    Scanner input = new Scanner(System.in);
  
    public void InsertPd(){
        connectDB cn = new connectDB();
        conn = cn.KetNoi();

        String Pname;
        int Quantity;
        int Price;
        
        System.out.print("input Pname: ");Pname = GetLine.gString();
         Pname = themDB.Chuanhoachuoi(Pname);
        System.out.print("input Quantity: ");Quantity = GetLine.gInt();
        System.out.print("input Price: ");Price = GetLine.gInt();
        
        String sql = "insert into product(Pname,Quantity,Price) values (?,?,?)";
        
        try {
            ptmt = conn.prepareStatement(sql);
            
            ptmt.setString(1,Pname);
            ptmt.setInt(2,Quantity);
            ptmt.setInt(3,Price);
            
         int kt = ptmt.executeUpdate();
         if(kt != 0 ){
             System.out.println("success");
         }else{
             System.err.println("error");
         }
         ptmt.close();
         conn.close();
        } catch (SQLException ex) {
            System.out.println("loi : " + ex.getMessage());
        }
    }
    
    public static String Chuanhoachuoi(String chuoichuan){
		String[] str;
        str = chuoichuan.split("\\s+");
		String chuoisaukhichuan = "" ;
		for(int i = 0 ;i< str.length; i++){
			chuoisaukhichuan += " "+ String.valueOf(str[i].charAt(0)).toUpperCase() + str[i].substring(1).toLowerCase();
		}
		return chuoisaukhichuan;
	}
    
}
    
    
    
    
//    public static void main(String[] args) throws Exception {
//		post();
//	}
//    
//    public static void post() throws Exception{
//		Scanner input = new Scanner(System.in);
//		final String var1 = input.next();
//		final String var2 = "";
//		try {
//			Connection conn = getConnection();
//			
//			PreparedStatement posted = conn.prepareStatement("Insert into product(Pname,Ptype,Pquantity,Price) values ('"+ var1 +"','L','1000','10000')");
//			
//			posted.executeUpdate();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		finally {
//			System.out.println("Inserted");
//		}
//	}
//    
//    public static Connection getConnection() throws Exception{
//		try {
//			String driver = "com.mysql.cj.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306/qlts";
//			String username = "root";
//			String password = "";
//			Class.forName(driver);
//			
//			Connection conn = DriverManager.getConnection(url,username,password);
//			System.out.println("Connected");
//			return conn;
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		return null;
//	}
//
//
//}