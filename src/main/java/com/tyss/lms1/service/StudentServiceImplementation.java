package com.tyss.lms1.service;

import java.util.List;

import com.tyss.lms1.dao.StudentDAO;
import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.BorrowBook;
import com.tyss.lms1.factory.StudentFactory;

public class StudentServiceImplementation implements StudentService {

	private StudentDAO dao = StudentFactory.getStudentDAO();

	@Override
	public boolean bookRequest(int userId, int bookId) {
		return dao.bookRequest(userId, bookId);
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		return dao.bookReturn(userId, bookId);
	}

	@Override
	public BookBean searchBookById(int bookId) {
		return dao.searchBookById(bookId);
	}
	
	@Override
	public BookBean searchBookByTitle(String bookTitle) {
		return dao.searchBookByTitle(bookTitle);
	}

	@Override
	public BookBean searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public List<BookBean> getAllBookInfo() {
		return dao.getAllBookInfo();
	}

	@Override
	public List<BorrowBook> borrowedBook(int userId) {
		return dao.borrowedBook(userId);
	}

}
