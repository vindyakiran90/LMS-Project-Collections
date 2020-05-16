package com.tyss.lms1.service;

import com.tyss.lms1.dao.RegisterationLoginDAO;
import com.tyss.lms1.dto.UserBean;
import com.tyss.lms1.factory.RegisterationLoginFactory;

public class RegisterationLoginServiceImplementaion implements RegisterationLoginService {

	RegisterationLoginDAO dao = RegisterationLoginFactory.getRegisterationLoginDAO();
	
	@Override
	public UserBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean register(UserBean bean) {
		return dao.register(bean);
	}
}

