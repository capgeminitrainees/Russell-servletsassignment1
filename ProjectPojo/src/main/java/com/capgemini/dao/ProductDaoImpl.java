package com.capgemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.model.Product;

public class ProductDaoImpl implements ProductDao {

	private static int counter=0;
	public void saveProduct(Product product) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection =null;
		PreparedStatement ps = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","C@pgemin!");
			 
			
				String sql = "insert into products( productName, prodType, description, expiryDate, quantity, price) values(?,?,?,?,?,?)";				
				ps = connection.prepareStatement(sql);
				
				ps.setString(1, product.getProductName());
				ps.setString(2, product.getProdType());
				ps.setString(3, product.getDescription());
				ps.setString(4, product.getExpiryDate());
				ps.setString(5, product.getQuantity());
				ps.setString(6, product.getPrice());
				ps.executeUpdate();
				


		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
				try {
					
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
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
			 
			
				String sql = "select * from products";				
				ps = connection.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while(rs.next()){
					Product p = new Product();
					p.setProductId(rs.getInt("productId"));
					p.setProductName(rs.getString("productName"));
					p.setProdType(rs.getString("prodType"));
					p.setDescription(rs.getString("description"));
					p.setExpiryDate(rs.getString("expiryDate"));
					p.setQuantity(rs.getString("quantity"));
					p.setPrice(rs.getString("price"));
					products.add(p);
				}
				


		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
				try {
					
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		return products;
		
	}

	public void deleteProduct(int productId) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection =null;
		PreparedStatement ps = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","C@pgemin!");
			 
			
				String sql = "delete from products where productId=?";				
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1, productId);
			
				ps.executeUpdate();
				


		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
				try {
					
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		
	}
	
	public Product updateProduct(int productId) {
		Product p = new Product();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","C@pgemin!");
			 
			
				String sql = "select * from products where productId=?";				
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1, productId);
				
				rs = ps.executeQuery();
				
				while(rs.next()){
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString("productName"));
				p.setProdType(rs.getString("prodType"));
				p.setDescription(rs.getString("description"));
				p.setExpiryDate(rs.getString("expiryDate"));
				p.setQuantity(rs.getString("quantity"));
				p.setPrice(rs.getString("price"));
				}


		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
				try {
					
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		return p;
	}

	public void updateServer(Product product) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection =null;
		PreparedStatement ps = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","C@pgemin!");
			 
			
				String sql = "update products set productName ='?', prodType='?', description='?', expiryDate='?', quantity='?', price='?', where productId=?";				
				ps = connection.prepareStatement(sql);
				
				ps.setString(1, product.getProductName());
				ps.setString(2, product.getProdType());
				ps.setString(3, product.getDescription());
				ps.setString(4, product.getExpiryDate());
				ps.setString(5, product.getQuantity());
				ps.setString(6, product.getPrice());
				ps.setInt(7, product.getProductId());
				
				ps.executeUpdate();
				


		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
				try {
					
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		
	}

}
