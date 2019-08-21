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
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import connected.connectDB;

public class hienthi {
    Connection conn = null;
    PreparedStatement ptmt = null;
    connectDB cn = new connectDB();
    
    public void Display(){
        conn = cn.KetNoi();
        
        String sql = "select * from customer";
        
        try {
            ptmt = conn.prepareStatement(sql);
            
            ResultSet rs = ptmt.executeQuery();
            System.out.println("***********************************************************************************************");
            System.out.println("*  Cid |        Cname         |        Note          |     Address    |    Tel    |           *");
            System.out.println("*---------------------------------------------------------------------------------------------*");
            while(rs.next()){
                int Cid = rs.getInt("Cid");
                String Cname = rs.getString("Cname");
                String Note = rs.getString("Note");
                String Address = rs.getString("Address");
                int Tel = rs.getInt("Tel");
                
                System.out.printf("*%5s | %20s | %20s |%15s |%10s |           *\n",Cid,Cname,Note,Address,Tel);
                
                
            }
            System.out.println("***********************************************************************************************");
        } catch (SQLException ex) {
            System.out.println("loi: " + ex.getMessage());
        }
        
    }
}
