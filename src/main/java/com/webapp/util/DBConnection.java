package com.webapp.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	
	private static final String DRIVER="org.postgresql.Driver";
	private static final String URL="jdbc:postgresql://ec2-107-22-7-9.compute-1.amazonaws.com:5432/d8dfc7pf3bb2om?sslmode=require&user=coqtxvfgvijygl&password=d6185d78d079fa92b475e013a11a3a7d219399f6b3390c779a7ce4a3bbb25a21";
	private static final String USERNAME="coqtxvfgvijygl";
	private static final String PASSWORD="d6185d78d079fa92b475e013a11a3a7d219399f6b3390c779a7ce4a3bbb25a21";
	private static Connection connection=null;
	
	
	public static Connection openConnection() {
		
		try {
			Class.forName(DRIVER).newInstance();
			connection=DriverManager.getConnection(URL);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
		
	}
	
	
	public static void closeConnection() {
		try {
			if(connection!=null) {
				connection.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
