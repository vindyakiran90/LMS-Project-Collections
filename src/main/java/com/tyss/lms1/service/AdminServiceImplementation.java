package com.tyss.lms1.service;

import java.util.List;

import com.tyss.lms1.dao.AdminDAO;
import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.IssueBook;
import com.tyss.lms1.dto.RequestBook;
import com.tyss.lms1.dto.UserBean;
import com.tyss.lms1.factory.AdminFactory;

public class AdminServiceImplementation implements AdminService {

	AdminDAO dao = AdminFactory.getAdminDAO();

	@Override
	public boolean addBook(BookBean bean) {
		return dao.addBook(bean);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public boolean issueBook(int userId, int bookId) {
		return dao.issueBook(userId, bookId);
	}

	@Override
	public boolean updateBook(String bookTitle, int copies) {
		return dao.updateBook(bookTitle, copies);
	}

	@Override
	public List<UserBean> showStudentUsers() {
		return dao.showStudentUsers();
	}

	
	@Override
	public List<RequestBook> showRequest() {
		return dao.showRequest();
	}

	@Override
	public boolean bookReturn(int user_Id, int book_Id) {
		return dao.bookReturn(user_Id, book_Id);
	}

	@Override
	public List<IssueBook> issuedBooks() {
		return dao.issuedBooks();
	}

}
