package com.tyss.lms1.dao;

import java.util.List;

import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.BorrowBook;

public interface StudentDAO {
	
	BookBean searchBookById(int bookId);
	BookBean searchBookByTitle(String bookTitle);
	BookBean searchBookByAuthor(String author);
	List<BookBean> getAllBookInfo();
	boolean bookRequest(int userId, int bookId);
	boolean bookReturn(int userId, int bookId);
	List<BorrowBook> borrowedBook(int userId);
}
