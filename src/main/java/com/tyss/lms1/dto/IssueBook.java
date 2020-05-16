package com.tyss.lms1.dto;

import java.io.Serializable;
import java.time.LocalDate;


public class IssueBook implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7954119888426874813L;
	private int issueId;
	private int bookId;
	private int userId;
	private LocalDate issueDate;
	private LocalDate returnDate;
	
	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-15s %-15s", issueId, bookId, issueDate, returnDate, userId);
	}

	
}
