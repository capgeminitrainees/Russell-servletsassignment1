package com.capgemini.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.service.ProductService;
import com.capgemini.service.ProductServiceImpl;

public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService productservice = new ProductServiceImpl();
		productservice.startDelete(Integer.parseInt(request.getParameter("productId")));
		
		request.getRequestDispatcher("listServlet").forward(request, response);
		
	}

}
