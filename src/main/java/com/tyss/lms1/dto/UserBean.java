package com.tyss.lms1.dto;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1206688428691036548L;
	private int userId;
	private String firstName;
	private String lastName;
	private String role;
	private long phoneNo;
	private String email;
	private String password;
	
	
	/*@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName" + lastName + ", userId" + userId + ", role" + role + ", phoneNo" + phoneNo + ", email" + email + ", password" + password +"]";
	}*/
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return String.format("%-15s %-15s %-10s %-15s %-12s %-20s %-10s", userId, firstName, 
				lastName, role, phoneNo, email, password);
	}
}