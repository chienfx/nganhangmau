/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditCustomer;

/**
 *
 * @author PC
 */
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import connected.connectDB;
public class themDB {
    
    Connection conn = null;
    PreparedStatement ptmt = null;
    Scanner input = new Scanner(System.in);
  
    public void InsertCm(){
        connectDB cn = new connectDB();
        conn = cn.KetNoi();

        String Cname;
        String Note;
        String Address;
        int Tel;
	
        		System.out.print("input Cname: ");Cname = input.nextLine();
                
                Cname = themDB.Chuanhoachuoi(Cname);
                
                System.out.print("input Note: ");Note = input.nextLine();
                System.out.print("input Address: ");Address = input.nextLine();
                
                Address = themDB.Chuanhoachuoi(Address);
                
                System.out.print("input Tel: ");Tel = input.nextInt();
                
                String sql = "insert into customer(Cname,Note,Address,Tel) values (?,?,?,?)";
                
                try {
                    ptmt = conn.prepareStatement(sql);
                    
                    ptmt.setString(1,Cname);
                    ptmt.setString(2,Note);
                    ptmt.setString(3,Address);
                    ptmt.setInt(4,Tel);
                    
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
