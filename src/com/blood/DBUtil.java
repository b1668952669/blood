package com.blood;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* 数据库连接工具
* @author 
*
*/
public class DBUtil {
    
   public static String db_url = "jdbc:mysql://localhost:3306/blood?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
   public static String db_user = "root";
   public static String db_pass = "1234";
    
   public static Connection getConn () {
       Connection conn = null;
        
       try {
           Class.forName("com.mysql.jdbc.Driver");//加载驱动
           System.out.println("数据库加载驱动成功");
           conn = DriverManager.getConnection(db_url, db_user, db_pass);
           System.out.println("数据库连接成功");
       } catch (Exception e) {
           e.printStackTrace();
       }
        
       return conn;
   }
    
   /**
    * 关闭连接
    * @param state
    * @param conn
    */
   public static void close (Statement state, Connection conn) {
       if (state != null) {
           try {
               state.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        
       if (conn != null) {
           try {
               conn.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
    
   public static void close (ResultSet rs, Statement state, Connection conn) {
       if (rs != null) {
           try {
               rs.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        
       if (state != null) {
           try {
               state.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        
       if (conn != null) {
           try {
               conn.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }

}