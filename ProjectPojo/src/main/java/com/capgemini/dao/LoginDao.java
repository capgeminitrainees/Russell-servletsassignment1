package com.capgemini.dao;

import com.capgemini.model.Login;

public interface LoginDao {

	public boolean isValidLogin(Login login);
}
