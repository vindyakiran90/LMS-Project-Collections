package com.tyss.lms1.factory;

import com.tyss.lms1.dao.RegisterationLoginDAO;
import com.tyss.lms1.dao.RegisterationLoginDAOImplementation;
import com.tyss.lms1.service.RegisterationLoginService;
import com.tyss.lms1.service.RegisterationLoginServiceImplementaion;

public class RegisterationLoginFactory {
	public static RegisterationLoginDAO getRegisterationLoginDAO() {
		return new RegisterationLoginDAOImplementation();
	}
	public static RegisterationLoginService getRegisterationLoginService() {
		return new RegisterationLoginServiceImplementaion();
	}
}
