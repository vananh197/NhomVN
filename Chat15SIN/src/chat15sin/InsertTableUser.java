/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat15sin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class InsertTableUser {
     public static void main(String[] args) {
        Connection con = null;
  
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SQlite15SIN.db");

            
            String sql = "INSERT INTO TblUser(username,password) VALUES(?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, "user");
            pstmt.setString(2, "1234");
            
            pstmt.setString(1, "koke");
            pstmt.setString(2, "123");
            
            pstmt.executeUpdate();
            System.out.println("Them Database Thanh Cong");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
