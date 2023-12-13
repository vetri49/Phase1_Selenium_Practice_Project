package com.simpilearn.seleniumtest.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionTest {
private final static String DB_URL ="jdbc:mysql://localhost:3306/estore_zone-db";
	

	static Connection con;
	static Statement statement;
	static ResultSet rst;
	public static void main(String[] args) {
		
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("1.Register Driver class");
			con=DriverManager.getConnection(DB_URL,"root","Root@999");
			
			System.out.println("2.Connection is created");
			statement=con.createStatement();
			System.out.println("3.Statement is created"+statement );
			String query="SELECT * FROM eproducts";
			rst=statement.executeQuery(query);
			System.out.println("4.Query is executed");
		}catch(ClassNotFoundException e) {
			
			System.out.println("Exception occured: "+e.getClass());
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Exception occured: "+e.getClass());
			e.printStackTrace();
		}
			finally {
				try {
					statement.close();
					con.close();
					rst.close();
					System.out.println("5.connection is closed");
					}catch(SQLException e) {
						System.out.println("Exception occured: "+e.getClass());
					}
		
	}

}
}