package com.tyss.lms1.dao;

import com.tyss.lms1.db.Database;
import com.tyss.lms1.dto.UserBean;
import com.tyss.lms1.exception.LMSException;

public class RegisterationLoginDAOImplementation implements RegisterationLoginDAO {

	@Override
	public UserBean login(String email, String password) {
		for(UserBean bean:Database.USERBEAN) {
			if(bean.getEmail().equals(email) && bean.getPassword().equals(password)) {
				return bean;
			}
		}
		throw new LMSException("Invalid user");
	}

	@Override
	public boolean register(UserBean bean) {
		for(UserBean bean1:Database.USERBEAN) {
			if(bean1.getEmail().equals(bean.getEmail())) {
				return false;
			}
		}
		Database.USERBEAN.add(bean);
		return true;
	}
}
