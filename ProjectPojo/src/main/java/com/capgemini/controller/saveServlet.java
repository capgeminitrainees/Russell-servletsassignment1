package com.capgemini.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.model.Product;
import com.capgemini.service.ProductService;
import com.capgemini.service.ProductServiceImpl;


public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String prodType = request.getParameter("prodType");
		String expiryDate = request.getParameter("expiryDate");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		
		Product product = new Product();
		product.setProductName(productName);
		product.setProdType(prodType);
		product.setExpiryDate(expiryDate);
		product.setDescription(description);
		product.setQuantity(quantity);
		product.setPrice(price);
		
		ProductService productservice = new ProductServiceImpl();
		productservice.startSave(product);
		
		response.sendRedirect("productCreate.html");
		
	}

}
