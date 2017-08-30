package com.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dao.LoginDao;
import com.capgemini.dao.LoginDaoImpl;
import com.capgemini.model.Login;
import com.capgemini.service.LoginServicecImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext servletcontext;
	private String email;

	@Override
	public void init(ServletConfig config) throws ServletException {
		servletcontext = config.getServletContext();
		email = config.getInitParameter("email");
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println("email: "+email);
		System.out.println("servlet context for company name: "+ servletcontext.getInitParameter("companyName"));
		
		
		Login login = new Login();
		login.setUserName(userName);
		login.setUserPassword(userPassword);
		
		LoginServicecImpl loginservice = new LoginServicecImpl();
		
		if(loginservice.isValidUser(login)){
			//response.sendRedirect("product.html");
			request.getRequestDispatcher("product.html").forward(request,response );
		}else{
			//response.sendRedirect("home.html");
			request.getRequestDispatcher("home.html").include(request, response);
		}
	}

}
