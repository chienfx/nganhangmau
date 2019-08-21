/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connected;

/**
 *
 * @author PC
 */
import java.sql.*;
import java.util.*;
public class connectDB {
    
    
    public static Connection KetNoi(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/quanlytrasua";
        String username = "root";
        String password = "";
    	
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException ex) {
            System.err.println("load driver don't success");
        } catch (SQLException e) {
            System.err.println("loi nhe ");
        }
        return conn;
    }
    
}
