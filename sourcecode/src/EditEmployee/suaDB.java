/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditEmployee;

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

    public void UpdateEm(){
        connectDB cn = new connectDB();
        conn = cn.KetNoi();
        String Eid = "0";
        String Ename;
        String Sex;
        System.out.print("select Eid: ");Eid = input.nextLine();
        
        System.out.print("input Ename: ");Ename = input.nextLine();
        Ename = themDB.Chuanhoachuoi(Ename);
        System.out.print("input Sex: ");Sex = input.nextLine();
        
        String sql = "UPDATE employee SET Ename = ? , Sex = ? WHERE Eid = ?";
        
        
        
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1,Ename);
            ptmt.setString(2,Sex);
            ptmt.setInt(3,Integer.parseInt(Eid));
            
         int kt = ptmt.executeUpdate();
         if(kt != 0 ){
             System.out.println("success");
         }else{
             System.err.println("error");
         }
         ptmt.close();
         conn.close();
        } catch (SQLException ex) {
        	ex.printStackTrace();
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

