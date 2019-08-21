package EditEmployee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        
        String sql = "select * from employee";
        
        try {
            ptmt = conn.prepareStatement(sql);
            
            ResultSet rs = ptmt.executeQuery();
            System.out.println("***********************************************************************************************");
            System.out.println("*  Eid |            Ename               |    Sex     |                                        *");
            System.out.println("*---------------------------------------------------------------------------------------------*");
            while(rs.next()){                
                int Eid = rs.getInt("Eid");
                String Ename = rs.getString("Ename");
                String Sex = rs.getString("Sex");
                System.out.printf("*%5s | %30s | %10s |                                        *\n",Eid,Ename,Sex);           
            }
            System.out.println("***********************************************************************************************");
        } catch (SQLException ex) {
            System.out.println("loi: " + ex.getMessage());
        }
        
    }
}


