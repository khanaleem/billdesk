package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hriday Dubey
 */

public class DataConnect {

	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://10.1.0.5\\MSSQLSERVER:1433;databaseName=ebex_uat","ebexuser","ebex@123");
			
//                        Connection con = DriverManager.getConnection("jdbc:sqlserver://172.31.29.15\\BILLDESK:1433;databaseName=ebex","sa","L0veT0Log!n@321");
//			
                        return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
      
        
}