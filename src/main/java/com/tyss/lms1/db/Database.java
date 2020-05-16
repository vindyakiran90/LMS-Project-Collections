package com.tyss.lms1.db;

import java.util.ArrayList;
import java.util.List;

import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.BorrowBook;
import com.tyss.lms1.dto.IssueBook;
import com.tyss.lms1.dto.RequestBook;
import com.tyss.lms1.dto.UserBean;


public class Database {
	public static final List<UserBean> USERBEAN = new ArrayList<UserBean>();
	
	public static final List<BookBean> BOOKBEAN = new ArrayList<BookBean>();

	public static final List<IssueBook> ISSUEBOOK = new ArrayList<IssueBook>();
	
	public static final List<RequestBook> REQUESTBOOK = new ArrayList<RequestBook>(); 
	
	public static final List<BorrowBook> BORROWBOOK = new ArrayList<BorrowBook>();
}
