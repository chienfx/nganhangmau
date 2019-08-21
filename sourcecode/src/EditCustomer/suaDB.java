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

import MainMenu.GetLine;
import connected.connectDB;

public class suaDB {
    Connection conn = null;
    PreparedStatement ptmt = null;
    Scanner input = new Scanner(System.in);
    
    public void UpdateCm(){
        connectDB cn = new connectDB();
        conn = cn.KetNoi();
        String Cid = "0";
        String Cname;
        String Note;
        String Address;
        int Tel;
        
        System.out.print("select update: ");
        Cid = input.nextLine();
        
        
        
        System.out.print("input Cname: ");Cname = GetLine.gString();
        Cname = themDB.Chuanhoachuoi(Cname);
        
        System.out.print("input Note: ");Note = GetLine.gString();
        
        System.out.print("input Address: ");Address = GetLine.gString();
        Address = themDB.Chuanhoachuoi(Address);
        
        System.out.print("input Tel: ");Tel = GetLine.gInt();
        
        
        String sql = "update customer set Cname= ?, Note= ? , Address= ?, Tel= ? where Cid = ?";
        
        try {
            ptmt = conn.prepareStatement(sql);
            
            ptmt.setString(1,Cname);
            ptmt.setString(2,Note);
            ptmt.setString(3,Address);
            ptmt.setInt(4,Tel);
            ptmt.setInt(5,Integer.parseInt(Cid));

         int kt = ptmt.executeUpdate();
         if(kt != 0 ){
             System.out.println("success");
         }else{
             System.err.println("error");
         }
         ptmt.close();
         conn.close();
        } catch (SQLException ex) {
        	ex.getStackTrace();
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

