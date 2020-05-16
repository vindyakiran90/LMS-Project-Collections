package com.tyss.lms1.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.ValidationException;

import com.tyss.lms1.dto.UserBean;
import com.tyss.lms1.exception.LMSException;
import com.tyss.lms1.factory.RegisterationLoginFactory;
import com.tyss.lms1.service.RegisterationLoginService;
import com.tyss.lms1.validation.Validation;

public class Registeration {

	Validation validation = new Validation();
	RegisterationLoginService registerationLoginService = RegisterationLoginFactory.getRegisterationLoginService();
	public static int getRandomNumberInts(int min, int max){
		Random random = new Random();
		return random.ints(min,(max+1)).findFirst().getAsInt();
	}

	public void register() {

		try(Scanner scanner = new Scanner(System.in);BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
			boolean flag = false;
			System.out.println("Welcome to Registration");
			UserBean bean1 = new UserBean();
			do {
				try {
					System.out.println("Enter First Name");
					String regFirstName = scanner.next();
					if(validation.validateFirstName(regFirstName)) {
						bean1.setFirstName(regFirstName);
						flag = true;
					} 
				} catch (InputMismatchException e) {
					flag = false;
					scanner.nextLine();
					System.err.println("Invalid first name");
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage());
				}   
			}while(!flag);

			do {
				try {
					System.out.println("Enter Last Name");
					String regLastName = scanner.next();
					if(validation.validateLastName(regLastName)) {
						bean1.setLastName(regLastName);
						flag = true;
					}
				} catch (InputMismatchException e) {
					flag = false;
					scanner.nextLine();
					System.err.println("Invalid last name");
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage());
				}
			}while(!flag);

			do { 
				try { 
					int userId = Registeration.getRandomNumberInts(10000, 20000);
					if(validation.validateId(userId)) {
						bean1.setUserId(userId); 
						flag = true; 
					}
				} catch (InputMismatchException e) {
					flag = false; 
					scanner.nextLine();
					System.err.println("Invalid User Id"); 
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage()); 
				}
			}while(!flag);

			do {
				try {
					System.out.println("Enter Role");
					String role = scanner.next();
					if(validation.validateFirstName(role)) {
						bean1.setRole(role);
						flag = true;
					}
				} catch (InputMismatchException e) {
					flag = false;
					scanner.nextLine();
					System.err.println("Invalid Role");
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage());
				}
			}while(!flag);

			do {
				try {
					System.out.println("Enter Phone Number");
					long phoneNo = scanner.nextLong();
					if(validation.validatephoneNo(phoneNo)) {
						bean1.setPhoneNo(phoneNo);
						flag = true;
					}
				} catch (InputMismatchException e) {
					flag = false;
					scanner.nextLine();
					System.err.println("Invalid Phone number");
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage());
				}
			}while(!flag);

			do {
				try {
					System.out.println("Enter Email Id");
					String emailId = scanner.next();
					if(validation.validateEmail(emailId)) {
						bean1.setEmail(emailId);
						flag = true;
					}
				} catch (InputMismatchException e) {
					flag = false;
					scanner.nextLine();
					System.err.println("Invalid Email Id");
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage());
				}
			}while(!flag);

			do {
				try {
					System.out.println("Enter Password");
					String regPassword = scanner.next();
					if(validation.validatePassword(regPassword)) {
						bean1.setPassword(regPassword);
						flag = true;
					}
				} catch (InputMismatchException e) {
					scanner.nextLine();
					flag = false;
					System.err.println("Invalid password");
				} catch (ValidationException e) {
					flag = false;
					scanner.nextLine();
					System.err.println(e.getMessage());
				}
			}while(!flag);

			boolean check = registerationLoginService.register(bean1);
			if(check) {
				System.out.println("Registered successfully");
			} else {
				System.out.println("Email already exist");
			}

			String args[] = {"Welcome to Main Controller"}; 
			MainController.main(args);	

		} catch (IOException e) {
			throw new LMSException("Invalid registeration");
		}
	}
}