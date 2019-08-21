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
import connected.connectDB;
public class suaDB {
    Connection conn = null;
    PreparedStatement ptmt = null;
    Scanner input = new Scanner(System.in);
  
    public void UpdatePd(){
        connectDB cn = new connectDB();
        conn = cn.KetNoi();
        
        String Pname;
        int Quantity;
        int Price;
        String Pid = "0";
        
        System.out.print("select update: ");
        Pid = input.nextLine();
        
        
        
        System.out.print("input Pname: ");
        Pname = input.nextLine();
        Pname = themDB.Chuanhoachuoi(Pname);
        
        
        System.out.print("input Quantity: ");
        Quantity = input.nextInt();
        
        System.out.print("input Price: ");
        Price = input.nextInt();
        
        String sql = "update product set Pname= ?,Quantity= ?,Price= ? where Pid = ?";
        
        try {
            ptmt = conn.prepareStatement(sql);
            
            ptmt.setString(1,Pname);
            ptmt.setInt(2,Quantity);
            ptmt.setInt(3,Price);
            ptmt.setInt(4,Integer.parseInt(Pid));
            
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
