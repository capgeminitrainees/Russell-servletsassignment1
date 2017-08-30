package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.model.Product;
import com.capgemini.service.ProductService;
import com.capgemini.service.ProductServiceImpl;


public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productservice = new ProductServiceImpl();
		
		Product p = productservice.startUpdate(Integer.parseInt(request.getParameter("productId")));
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<script src='script/jsfile.js'></script>");
		out.println("<body>"
				+ "<form method='post' action='updatingServerServlet' onsubmit='return validate()'>"
				+ "<div>"
				+ "<table>"
				+ "<tr>"
				+ "<td></td>"
				+ "<td><input type='hidden' name ='productId' id='productId' value='"+p.getProductId()+"'>"
				+ "</td>"
				+ "<td><div id='prodNameDiv'></div></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Product Name</td>"
				+ "<td><input type='text' id ='productName' name = 'productName' value='"+p.getProductName()+"'>"
				+ "</td>"
				+ "<td><div id='prodNameDiv'></div></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Product Type</td>"
				+ "<td><select id='prodType' name='prodType' value='"+p.getProdType()+"'><option label='mobile' value='mobile'></option><option label='TV' value='TV'></option></select></td>"
				+ "<td><div id='prodTypeDiv'></div></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Expiry Date</td>"
				+ "<td><input type='date' id='expiryDate' name = 'expiryDate' value='"+p.getExpiryDate()+"'></td>"
				+ "<td><div id='expiryDateDiv'></div></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Description</td>"
				+ "<td><textarea name = 'description' id='description' rows='5' cols='20'>"+p.getDescription()+"</textarea></td>"
				+ "<td><div id='descriptionDiv'></div></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Quantity</td>"
				+ "<td><input type='number' id='quantity' name='quantity' value='"+p.getQuantity()+"'></td>"
				+ "<td><div id='quantityDiv'></div></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Price</td>"
				+ "<td><input type='number' id='price' name='price' value='"+p.getPrice()+"'></td>"
				+ "<td><div id='priceDiv'></div></td>"
				+ "</tr>"
				+ "</table>"
				+ "<input type='submit' value='Update' >"
				+ "<input type='reset' value='Clear'>"
				+ "</div>"
				+ "</form></body></html>");
		
		
		//request.getRequestDispatcher("listServlet").forward(request, response);
	}

}
