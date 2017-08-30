package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dao.ProductDao;
import com.capgemini.dao.ProductDaoImpl;
import com.capgemini.model.Product;


public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productdao = new ProductDaoImpl();
		List<Product> products = productdao.getAllProducts();
		
		PrintWriter out = response.getWriter();
		out.println("<table>");
		
		out.println("<tr><th>ProductId</th> <th> Product Name</th><th>Product Type</th><th>Description</th><th>Expiry Date</th> <th>Quantity</th><th>price</th></tr>");
		for(Product p:products){
			out.println("<tr>");
			out.println("<td>");
			out.println(p.getProductId());
			out.println("</td>");
			out.println("<td>");
			out.println(p.getProductName());
			out.println("</td>");
			out.println("<td>");
			out.println(p.getProdType());
			out.println("</td>");
			out.println("<td>");
			out.println(p.getDescription());
			out.println("</td>");
			out.println("<td>");
			out.println(p.getExpiryDate());
			out.println("</td>");
			out.println("<td>");
			out.println(p.getQuantity());
			out.println("</td>");
			out.println("<td>");
			out.println(p.getPrice());
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='deleteServlet?productId="+p.getProductId()+"'>Delete</a>");
			out.println("</td>");
			out.println("<td>");
			out.println("<a href='updateServlet?productId="+p.getProductId()+"' target='mainFrm'>Update</a>");
			out.println("</td>");
		}
		out.println("</table>");
		
	}


	

}
