package com.tyss.lms1.dao;

import com.tyss.lms1.dto.UserBean;

public interface RegisterationLoginDAO {
	UserBean login(String email, String password);
	boolean register(UserBean bean);
}
