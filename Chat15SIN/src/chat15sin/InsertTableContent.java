/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat15sin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertTableContent {
    public static void main(String[] args) {
        Connection con = null;
  
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SQlite15SIN.db");
            String sql = "INSERT INTO TblContent(sender,receiver,type,content,inComeTime,isDeliver) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("y/M/d h:m:s");
            Date date = new Date();
            pstmt.setString(1, "user");
            pstmt.setString(2, "quan");
            pstmt.setString(3, "chat");
            pstmt.setString(4, "hello quan , di nhau ko ?");
            pstmt.setString(5, sdf.format(date));
            pstmt.setString(6, "false");
            pstmt.executeUpdate();
            System.out.println("Them Database Thanh Cong");
        }catch(Exception e){
            e.printStackTrace();
        }     
    }
}
