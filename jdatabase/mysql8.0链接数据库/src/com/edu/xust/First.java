package com.edu.xust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class First {
    public static void main(String []args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        long startTime=System.currentTimeMillis();
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载成功");
        } catch (Exception ex) {
            System.out.println("加载失败");
            // handle the error
        }

        try {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/world?serverTimezone=UTC","root","xupandontbeevil?");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3310/world?serverTimezone=UTC"+"&user=xumouren&password=xupandontbeevil?");

            System.out.println("连接成功");
            ps = conn.prepareStatement("select no,name from xupan;");
            rs = ps.executeQuery();
            while(rs.next()) {
                int num = rs.getInt("no");
                String name = rs.getString("name");
                System.out.print(num+"\t"+name);
                System.out.println("");
            }



        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("连接失败");
        }
        System.out.println("时间" + (System.currentTimeMillis() - startTime));
    }
}