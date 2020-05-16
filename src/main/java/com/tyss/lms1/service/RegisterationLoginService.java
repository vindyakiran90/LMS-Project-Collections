package com.tyss.lms1.service;

import com.tyss.lms1.dto.UserBean;

public interface RegisterationLoginService {
	UserBean login(String email, String password);
	boolean register(UserBean bean);
}
