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
        
        String sql = "select * from product";
        
        try {
            ptmt = conn.prepareStatement(sql);
            
            ResultSet rs = ptmt.executeQuery();
            System.out.println("***********************************************************************************************");            
            System.out.println("*  Pid |            Pname               |  Quantity  |   Price   |                            *");
            System.out.println("*---------------------------------------------------------------------------------------------*");
            while(rs.next()){
                int Pid = rs.getInt("Pid");
                String Pname = rs.getString("Pname");
                int Quantity = rs.getInt("Quantity");
                int Price = rs.getInt("Price");
                
                
                System.out.printf("*%5s | %30s | %10s |%10s |                            *\n",Pid,Pname,Quantity,Price);
                
            }
            System.out.println("***********************************************************************************************");
        } catch (SQLException ex) {
            System.out.println("loi: " + ex.getMessage());
        }
        
    }
}
