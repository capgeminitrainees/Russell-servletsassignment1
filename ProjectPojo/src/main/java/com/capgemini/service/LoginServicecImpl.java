package com.capgemini.service;

import com.capgemini.dao.LoginDao;
import com.capgemini.dao.LoginDaoImpl;
import com.capgemini.model.Login;

public class LoginServicecImpl implements LoginService{

	public boolean isValidUser(Login login) {
		
		LoginDao logindao = new LoginDaoImpl();
		
		return logindao.isValidLogin(login);
			
		
	}

		
}
