package com.tyss.lms1.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.tyss.lms1.db.Database;
import com.tyss.lms1.dto.BookBean;
import com.tyss.lms1.dto.BorrowBook;
import com.tyss.lms1.dto.IssueBook;
import com.tyss.lms1.dto.RequestBook;
import com.tyss.lms1.dto.UserBean;
import com.tyss.lms1.exception.LMSException;

public class AdminDAOImplementation implements AdminDAO {

	@Override
	public boolean addBook(BookBean bean) {
		for(BookBean bookBean:Database.BOOKBEAN) {
			if(bookBean.getBookTitle().equals(bean.getBookTitle()) &&
					bookBean.getAuthor().equals(bean.getAuthor())) {
				return false; 
			}
		}
		Database.BOOKBEAN.add(bean);
		return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		for(BookBean bookBean:Database.BOOKBEAN) {
			if(bookBean.getBookId() == bookId){
				Database.BOOKBEAN.remove(bookBean);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<UserBean> showStudentUsers() {
		List<UserBean> user = new LinkedList<UserBean>();
		for(UserBean userBean:Database.USERBEAN) {
			if(userBean.getRole().equalsIgnoreCase("student")) {
				user.add(userBean);
			}
		}
		return user;
	}

	@Override
	public boolean updateBook(String bookTitle, int numberOfBooks) {
		for(BookBean bean:Database.BOOKBEAN) {
			if(bean.getBookTitle().equals(bookTitle)) {
				bean.setNumberOfBooks(bean.getNumberOfBooks()+numberOfBooks);
				bean.setNumberOfAvailableBooks(bean.getNumberOfAvailableBooks() + numberOfBooks);
			}
			return true;
		}
		return false;
	}


	@Override
	public boolean issueBook(int userId, int bookId) {
		int count = 0;
		for(UserBean userbean1 : Database.USERBEAN) {
			if(userbean1.getUserId() == userId) {
				for(BookBean bookBean1 : Database.BOOKBEAN) {
					if(bookBean1.getBookId() == bookId) {
						if(bookBean1.getNumberOfAvailableBooks() != 0) {
							if((userbean1.getUserId() == userId) && (bookBean1.getBookId() == bookId)) {
								for(IssueBook issueBook : Database.ISSUEBOOK) {
									if(issueBook.getBookId() == bookId && issueBook.getUserId() == userId ) {
										for(RequestBook requestBook : Database.REQUESTBOOK) {
											if(requestBook.getBookId() == bookId && requestBook.getUserId() == userId) {
												for(BorrowBook borrowBook : Database.BORROWBOOK) {
													if(borrowBook.getUserId() == userId) {
														count += count++;
														
														Random random = new Random();
														LocalDate currentDate = LocalDate.now();
														LocalDate returnDate = LocalDate.now().plusDays(10);
														
														IssueBook issueBook1 = new IssueBook();
														issueBook1.setBookId(bookId);
														issueBook1.setIssueId(random.nextInt());
														issueBook1.setUserId(userId);
														issueBook1.setIssueDate(currentDate);
														issueBook1.setReturnDate(returnDate);
														List<IssueBook> issueBook2 = new LinkedList<IssueBook>();
														issueBook2.add(issueBook1);
														
														BorrowBook borrowBook1 = new BorrowBook();
														borrowBook1.setBorrowId(random.nextInt());
														borrowBook1.setBookId(bookId);
														borrowBook1.setUserId(userId);
														borrowBook1.setFees(borrowBook1.getFees() + 5);
														borrowBook1.setDateOfBorrowed(currentDate);
														borrowBook1.setDateOfReturn(returnDate);
														
														List<BorrowBook> borrowBook2 = new LinkedList<BorrowBook>();
														borrowBook2.add(borrowBook1);
														
														Database.REQUESTBOOK.remove(requestBook);
														
														return true;
																
													} else {
														throw new LMSException("Number of books borrowed limit exceeded");
													}
												}
											} else {
												throw new LMSException("Book is already requested, cannot request the same book");
											}
										}
									} else {
										throw new LMSException("Book is already issued to the user");
									}
								}
							} else {
								throw new LMSException("Book is not requested from the user");
							}
						}else {
							throw new LMSException("Book is not in stock");
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
	public List<RequestBook> showRequest() {
		LinkedList<RequestBook> requestBook = new LinkedList<RequestBook>();
		for(RequestBook requestBook1:Database.REQUESTBOOK) {
			requestBook.add(requestBook1);
		}
		return requestBook;
	}

	@Override
	public List<IssueBook> issuedBooks() {
		List<IssueBook> issueBook = new LinkedList<IssueBook>();
		for(IssueBook issueBook1:Database.ISSUEBOOK) {
			issueBook.add(issueBook1);
		}
		return issueBook;
	}

	@Override
	public boolean bookReturn(int userId, int bookId) {
		// TODO Auto-generated method stub
		return false;
	}


}
