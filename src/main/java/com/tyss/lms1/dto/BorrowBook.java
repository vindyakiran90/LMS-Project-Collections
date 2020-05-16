package com.tyss.lms1.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6408830624353387192L;
	private int borrowId;
	private int bookId;
	private int userId;
	private int noOfBooksBorrowed;
	private LocalDate dateOfBorrowed;
	private LocalDate dateOfReturn;
	private double fees;
	
	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
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

	public int getNoOfBooksBorrowed() {
		return noOfBooksBorrowed;
	}

	public void setNoOfBooksBorrowed(int noOfBooksBorrowed) {
		this.noOfBooksBorrowed = noOfBooksBorrowed;
	}

	public LocalDate getDateOfBorrowed() {
		return dateOfBorrowed;
	}

	public void setDateOfBorrowed(LocalDate dateOfBorrowed) {
		this.dateOfBorrowed = dateOfBorrowed;
	}

	public LocalDate getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(LocalDate dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-20s %-20s %-20s %-10s", borrowId, userId, bookId, noOfBooksBorrowed, 
				dateOfBorrowed, dateOfReturn, fees);
	}
}
