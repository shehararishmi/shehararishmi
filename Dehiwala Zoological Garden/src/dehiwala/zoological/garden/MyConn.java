/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dehiwala.zoological.garden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shehara
 */
public class MyConn {
    static Connection c;
    public static void getMyConn()throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/DehiwalaZoologicalGarden";
    c=DriverManager.getConnection(url, "root","Ranzil0805" );
    
    }
    public static void save(String sql)throws Exception{
        if (c == null) {
          getMyConn();
        }
        Statement stmt = c.createStatement();
        stmt.executeUpdate(sql);  
    }
    
    public static ResultSet search (String sql)throws Exception {
        if (c == null) {
            getMyConn();
        }
        Statement stmt = c.createStatement();
        return stmt.executeQuery(sql);    
    }
           
}
