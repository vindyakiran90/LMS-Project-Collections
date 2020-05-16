package com.tyss.lms1.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.tyss.lms1.db.Database;
import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.BorrowBook;
import com.tyss.lms1.dto.RequestBook;
import com.tyss.lms1.dto.UserBean;
import com.tyss.lms1.exception.LMSException;

public class StudentDAOImplementation implements StudentDAO {
	AdminDAO adminDao = new AdminDAOImplementation();
	
	@Override
	public BookBean searchBookById(int bookId) {
		for(BookBean bookBean:Database.BOOKBEAN) {
			if(bookBean.getBookId() == bookId) {
				return bookBean;
			}
		}
		return null;
	}

	@Override
	public BookBean searchBookByTitle(String bookTitle) {
		for(BookBean bean:Database.BOOKBEAN) {
			if(bean.getBookTitle().equals(bookTitle)) {
				return bean;
			}
		}
		return null;
	}

	@Override
	public BookBean searchBookByAuthor(String author) {
		for(BookBean bean:Database.BOOKBEAN) {
			if(bean.getAuthor().equals(author)) {
				return bean;
			}
		}		return null;
	}

	@Override
	public List<BookBean> getAllBookInfo() {
		List<BookBean> bookBean = new LinkedList<BookBean>();
		for(BookBean bookBean1:Database.BOOKBEAN) {
			bookBean.add(bookBean1);
		} 
		return bookBean;
	}


	@Override
	public boolean bookRequest(int userId, int bookId) {
		for(UserBean userbean1 : Database.USERBEAN) {
			if(userbean1.getUserId() == userId) {
				for(BookBean bookBean1 : Database.BOOKBEAN) {
					if(bookBean1.getBookId() == bookId) {
						for(RequestBook requestBook : Database.REQUESTBOOK) {
							if(requestBook.getBookId() == bookId && requestBook.getUserId() == userId) {
								
								if(bookBean1.getNumberOfAvailableBooks() != 0) {
									RequestBook requestBook1 = new RequestBook();
								
									requestBook1.setBookId(bookId);
									requestBook1.setBookTitle(bookBean1.getBookTitle());
									requestBook1.setFirstName(userbean1.getFirstName());
									requestBook1.setLastName(userbean1.getLastName());
									requestBook1.setUserId(userId);

									Random random = new Random();
									requestBook1.setRequestId(random.nextInt());
									Database.REQUESTBOOK.add(requestBook1);
									return true;
								}else {
									throw new LMSException("Book is not in stock");
								}
							} else {
								throw new LMSException("Book is already requested, cannot request the same book");
							}
						}
					}else {
						throw new LMSException("Book doesn't exist");
					}
				}
			} else {
				throw new LMSException("User doesn't exist");
			}
		}
		return false;
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		return false;
	}

	@Override
	public List<BorrowBook> borrowedBook(int userId) {
		List<BorrowBook> borrowBook = new LinkedList<BorrowBook>();
		for(BorrowBook borrowBook1:Database.BORROWBOOK) {
			borrowBook.add(borrowBook1);
		}
		return borrowBook;
	}
}
