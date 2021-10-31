package com.xuantujava.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class test {
	public static void main(String args[]){  
        try{  

        	
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://xuantudbspr.cmxxavfzjxrv.ap-northeast-1.rds.amazonaws.com/xuantudbspr","xuantudbspr","xuantudbspr");  
            Statement stmt = conn.createStatement();  
         //   ResultSet rs = stmt.executeQuery("select * from emp");    
            conn.close();  
        }catch(Exception ex){
            //System.out.println(ex);
        }  
    }
}
