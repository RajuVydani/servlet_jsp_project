package com.servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

	public String getUserCredentials(String userName) {
		
		String userPassword = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			String uri = "jdbc:mysql://localhost:3306/javatrainers";
			String dbUserName = "root";
			String dbPassword = "prasad";

			Connection con = DriverManager.getConnection(uri, dbUserName, dbPassword);

			PreparedStatement pstmt = con.prepareStatement("select * from user where userName = ?");

			pstmt.setString(1, userName);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userPassword = rs.getString(2);
			}	

			con.close();

			System.out.println("User :: " + userName + " :: Password :: " + userPassword);

		} catch (Exception e) {

			System.out.println(e);

		}
		
		return userPassword;

	}

}
