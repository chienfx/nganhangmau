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
import connected.connectDB;
public class xoaDB {
    public static void xoaCm(){
        Connection conn = connectDB.KetNoi();
        Scanner input = new Scanner(System.in);
        int Cid;
        System.out.print("you waint delete : ");
        Cid = input.nextInt();
        
        String sql = "delete from customer where Cid = ?";
       
        try{
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,Cid);
        
        int kt = ptmt.executeUpdate();
        if(kt!=0){
            System.out.println("success delete");
        }
        ptmt.close();
        conn.close();
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
     }
    
}
