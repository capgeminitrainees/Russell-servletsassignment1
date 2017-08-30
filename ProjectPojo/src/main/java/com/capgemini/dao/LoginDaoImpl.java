package com.capgemini.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.capgemini.model.Login;
import java.sql.PreparedStatement;


public class LoginDaoImpl implements LoginDao{
	
	boolean res = false;
	
	public boolean isValidLogin(Login login) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection =null;
		 PreparedStatement ps = null;
			ResultSet rs = null;
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","C@pgemin!");
			 
			
				String sql = "select * from login where userName=? and password=?";
				ps = connection.prepareStatement(sql);
				ps.setString(1, login.getUserName());
				ps.setString(2, login.getUserPassword());
				
				rs = ps.executeQuery();
				System.out.println(rs.toString());
				if(rs.next()){
					res = true;
				}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
				try {
					rs.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		
		return res;
	}

}
