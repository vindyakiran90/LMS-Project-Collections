package com.tyss.lms1.factory;

import com.tyss.lms1.dao.StudentDAO;
import com.tyss.lms1.dao.StudentDAOImplementation;
import com.tyss.lms1.service.StudentService;
import com.tyss.lms1.service.StudentServiceImplementation;

public class StudentFactory {

	public static StudentDAO getStudentDAO() {
		return new StudentDAOImplementation();
	}
	public static StudentService getStudentService() {
		return new StudentServiceImplementation();
	}
}
