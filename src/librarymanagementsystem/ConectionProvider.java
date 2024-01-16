/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;
import java.sql.*;
/**
 *
 * @author Oluwatobi
 */
public class ConectionProvider {
    public static Connection getConnection(){
        try{
            String username; // Enter the database root name
            String password; // Enter the database password
            String dataConn = 
                    "jdbc:mysql://localhost:3306/libary management system";
            Connection con = DriverManager.getConnection(dataConn, username, password);
            return con;
        }
        catch(SQLException e){
            return null;
        }
    }
    
}
