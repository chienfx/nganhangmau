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
import connected.connectDB;
public class xoaDB {
    public static void xoapd(){
        Connection conn = connectDB.KetNoi();
        Scanner input = new Scanner(System.in);
        int Pid;
        System.out.print("you waint delete : ");
        Pid = input.nextInt();
        
        String sql = "delete from product where Pid = ?";
       
        try{
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,Pid);
        
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

