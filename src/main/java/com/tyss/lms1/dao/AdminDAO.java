package com.tyss.lms1.dao;

import java.util.List;

import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.IssueBook;
import com.tyss.lms1.dto.RequestBook;
import com.tyss.lms1.dto.UserBean;

public interface AdminDAO {
	 
	boolean addBook(BookBean bean);
	boolean deleteBook(int bookId);
	boolean issueBook(int userId, int bookId);
	boolean updateBook(String bookTitle, int numberOfBooks);
	List<RequestBook> showRequest();
	List<UserBean> showStudentUsers();
	List<IssueBook> issuedBooks();
	boolean bookReturn(int userId, int bookId);
}
