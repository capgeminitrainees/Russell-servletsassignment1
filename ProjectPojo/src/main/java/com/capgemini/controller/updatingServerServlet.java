package com.capgemini.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.model.Product;
import com.capgemini.service.ProductService;
import com.capgemini.service.ProductServiceImpl;


public class updatingServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productservice = new ProductServiceImpl();
		Product product = new Product();
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String prodType = request.getParameter("prodType");
		String expiryDate = request.getParameter("expiryDate");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProdType(prodType);
		product.setDescription(description);
		product.setExpiryDate(expiryDate);
		product.setQuantity(quantity);
		product.setPrice(price);
		
		productservice.startUpdatingServer(product);
		response.sendRedirect("listServlet");
	}

}
