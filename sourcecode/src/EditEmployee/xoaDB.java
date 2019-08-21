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
import java.util.*;
import java.sql.*;
import connected.connectDB;
public class xoaDB {
    public static void xoaEm(){
        Connection conn = connectDB.KetNoi();
        Scanner input = new Scanner(System.in);
        int Eid;
        System.out.print("you want delete : ");
        Eid = input.nextInt();
        
        String sql = "delete from employee where Eid = ?";
       
        try{
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,Eid);
        
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