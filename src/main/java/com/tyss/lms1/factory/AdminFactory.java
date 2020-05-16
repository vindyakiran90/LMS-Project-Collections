package com.tyss.lms1.factory;

import com.tyss.lms1.dao.AdminDAO;
import com.tyss.lms1.dao.AdminDAOImplementation;
import com.tyss.lms1.service.AdminService;
import com.tyss.lms1.service.AdminServiceImplementation;

public class AdminFactory {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImplementation();
	}
	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}
	
}
