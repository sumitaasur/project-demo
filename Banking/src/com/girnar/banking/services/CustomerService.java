package com.girnar.banking.services;

import java.util.ArrayList;
import com.girnar.banking.database.BankCustomerDatabase;
import com.girnar.banking.details.CustomerDetails;
import com.girnar.banking.validation.Validation;

/**
 * Customers of the bank for them we require some operations that are to be in
 * this CustomerService class.Hear will get all services of customer.
 */
public class CustomerService {

	private CustomerDetails customerDetails;
	private Validation validation = new Validation();
	private BankCustomerDatabase bankCustomerDatabase = new BankCustomerDatabase();

	public CustomerDetails getSelectedCustomerDetails(int customerid) {

		CustomerDetails selectedCustomerDetails = null;
		if (customerid > 0 && customerid < 5) {
			for (int index = 0; index < 4; index++) {
				if (customerid == customerDetails.getId()) {
					selectedCustomerDetails = customerDetails;
					return selectedCustomerDetails;
				}
			}
		}
		return selectedCustomerDetails;
	}

	public CustomerDetails getSelectedEmployeeDetails(String bankName, int customerId) {
		CustomerDetails customerDetails = bankCustomerDatabase.getCustomerById(bankName, customerId);
		if (customerDetails != null) {
			return customerDetails;
		}
		return null;
	}

	/**
	 * addCustomer is likewise employee creating , hear customer account
	 * creating.This is mainly for create new account.
	 */
	public void addCustomer(String bankName) {
		int id = 0;
		String name;
		String gender;
		int accountBalance;
		String transectionHistory;
		boolean isActive = true;
		System.out.println("Please Enter Name");
		name = validation.validationForStringValues();
		while (true) {
			System.out.println("Please Enter gender male/female");
			gender = validation.validationForStringValues().toLowerCase();
			if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
				break;
			} else {
				continue;
			}
		}
		while (true) {
			System.out.println("For account creation you need to deposite minimum ₹500\n ");
			System.out.println("Enter amount for deposite");
			accountBalance = validation.validationForIntegerValues();
			if (accountBalance >= 500) {
				transectionHistory = accountBalance + " rupees deposite";
				break;

			} else {
				System.out.println("Invalid Amount");
				continue;
			}
		}
		int newCustomerId = bankCustomerDatabase.insertCustomerInDatabase(bankName, new CustomerDetails(id, name, gender, accountBalance, isActive, transectionHistory));

		if (newCustomerId != 0) {
			System.out.println("Successfully Created\n");
			System.out.println("Customer Id : " + newCustomerId + "\nCustomer Name : "+name+"\n");
		}
	}

	/**
	 * this for sales operation purpose . The r6equirement of sales man is to upload
	 * form.so it is up to that.
	 * 
	 * @param bankName
	 */
	public void documentUploadProcess(String bankName) {
		while (true) {
			System.out.println("choose the Document to upload");
			System.out.println("1. Credit Card Form");
			System.out.println("2. PAN Card Document");
			System.out.println("3. Adhaar card Document");
			System.out.println("4. Exit");

			System.out.println("Enter your Choice ");
			int choice = validation.validationForIntegerValues();

			switch (choice) {

			case 1:
				System.out.println("Credit Card Form uploaded sussessfully\n");
				break;
			case 2:
				System.out.println("PAN Card Doc uploaded sussessfully\n");
				break;
			case 3:
				System.out.println("Adhaar card Doc uploaded sussessfully\n");
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid Choice");
				continue;
			}
		}
	}

	/**
	 * this is the thing for employee of the bank.he can just access the customer
	 * profile and he can create the customer. The process can is view Details ,
	 * edit,disable,enable and create.
	 */
	public void viewDetailsProcess(String bankName) {
		while (true) {
			System.out.println("Enter the Your Customer ID");
			int customerId = validation.validationForIntegerValues();
			CustomerDetails selectedCustomerDetails = bankCustomerDatabase.getCustomerById(bankName, customerId);

			if (selectedCustomerDetails != null) {
				System.out.println("Customer Details :\n");
				System.out.println("id:" + selectedCustomerDetails.getId());
				System.out.println("Name:" + selectedCustomerDetails.getName());
				System.out.println("Gender:" + selectedCustomerDetails.getGender() + "\n");
				return;
			} else {
				System.out.println("Invalid customer id");
				continue;
			}
		}
	}

	/*
	 * this is the thing for employee of the bank.he can just access the customer
	 * profile and he can create the customer. The process can is view Details ,
	 * edit,disable,enable and create.
	 */
	public void editDetailsProcess(String bankName) {
		while (true) {
			System.out.println("Enter the Your Customer ID");
			int customerId = validation.validationForIntegerValues();
			CustomerDetails selectedCustomerDetails = bankCustomerDatabase.getCustomerById(bankName, customerId);

			if (selectedCustomerDetails != null) {
				while (true) {
					System.out.println("Which Details you want to Edit");
					System.out.println("1.Name \n2.Gender \n");
					System.out.println("Enter your choice");
					int choice = validation.validationForIntegerValues();

					switch (choice) {
					case 1:
						System.out.println("Please enter new name");
						String name = validation.validationForStringValues();// scanner.nextLine();

						if (!name.equals(selectedCustomerDetails.getName())) {
							selectedCustomerDetails.setName(name);
							bankCustomerDatabase.updateCustomerDetails(bankName, selectedCustomerDetails);
							System.out.println("Changed successFully\n");
							return;
						} else {
							System.out.println("previous name current changing name both are same\n");
							return;
						}
					case 2:
						System.out.println("Please enter new gender");
						String gender = validation.validationForStringValues();// scanner.nextLine();
						if (gender != selectedCustomerDetails.getName()
								&& (gender.toLowerCase() == "male" || gender.toLowerCase() == "Female")) {
							selectedCustomerDetails.setName(gender);
							bankCustomerDatabase.updateCustomerDetails(bankName, selectedCustomerDetails);
							System.out.println("Changed successFully");
							return;
						} else {
							System.out.println("No changes occuered");
							return;
						}
					default:
						System.out.println("Invalid Choice");
						continue;
					}
				}
			} else {
				System.out.println("Invalid customer id");
				continue;
			}
		}
	}

	/**
	 * this is the thing for employee of the bank.he can just access the employee
	 * profile and he can create the customer. hear can check only banace either
	 * than that he can't. The process can is view Deatisls , edit,disable,enable
	 * and create.
	 */
	public void showAccountBalance(String bankName) {
		System.out.println("Enter the Your Customer ID");
		int customerId = validation.validationForIntegerValues();
		CustomerDetails selectedCustomerDetails = bankCustomerDatabase.getCustomerById(bankName, customerId);

		if (selectedCustomerDetails != null) {
			System.out.println("Account balance:" + selectedCustomerDetails.getAccountBalance() + "\n");
		} else {
			System.out.println("Invalid customer id");
		}
	}

	/**
	 * this is the process of casher he can do withdraw, deposit and can check the
	 * transaction history.
	 * 
	 * @param bankName
	 */
	public void balanceProcess(String bankName) {
		String transactionHistory;
		while (true) {
			System.out.println("Enter the Your Customer ID");
			int customerId = validation.validationForIntegerValues();
			CustomerDetails selectedCustomerDetails = bankCustomerDatabase.getCustomerById(bankName, customerId);

			if (selectedCustomerDetails != null) {
				while (true) {
					System.out.println("Account Balance Oparetion");
					System.out.println("1.Withdraw");
					System.out.println("2.Deposite");
					System.out.println("3.Transaction History");
					System.out.println("4.Exit");
					System.out.println("Enter your choice ");
					int choice = validation.validationForIntegerValues();

					switch (choice) {
					case 1:
						while (true) {
							System.out.println("Your current Balnace :" + selectedCustomerDetails.getAccountBalance());
							System.out.println("Enter how much you want withdraw ");
							int withdrawAmount = validation.validationForIntegerValues();
							if (withdrawAmount <= selectedCustomerDetails.getAccountBalance() && withdrawAmount > 100) {
								int remaingBalance = selectedCustomerDetails.getAccountBalance() - withdrawAmount;
								selectedCustomerDetails.setAccountBalance(remaingBalance);
								System.out.println(
										"Your current Balnace :" + selectedCustomerDetails.getAccountBalance());
								System.out.println("Withdraw Successful");
								transactionHistory = selectedCustomerDetails.getAccountBalance() + " rupees withdrawal";
								selectedCustomerDetails.setValues(transactionHistory);
								bankCustomerDatabase.updateCustomerDetails(bankName, selectedCustomerDetails);
								break;
							} else {
								System.out.println(
										"Withdrawal amount should be morethan 100 and it shouldn't cross your balance limit ");
								continue;
							}
						}
					case 2:
						while (true) {
							System.out.println("Your current Balnace :" + selectedCustomerDetails.getAccountBalance());
							System.out.println("How much amount want to deposite");
							int depositingAmount = validation.validationForIntegerValues();
							if (depositingAmount > 0 && depositingAmount < 50000) {
								int currentBalance = selectedCustomerDetails.getAccountBalance() + depositingAmount;
								selectedCustomerDetails.setAccountBalance(currentBalance);
								System.out.println(
										"Your current Balnace :" + selectedCustomerDetails.getAccountBalance());
								transactionHistory = selectedCustomerDetails.getAccountBalance() + " rupees deposited";
								selectedCustomerDetails.setValues(transactionHistory);
								bankCustomerDatabase.updateCustomerDetails(bankName, selectedCustomerDetails);
								System.out.println("Deposite Successful");
								break;
							} else {
								System.out.println("Enter the amount below 50000");
								continue;
							}
						}
					case 3:
						transactionHistory(bankName, customerId);
						break;
					case 4:
						return;
					default:
						System.out.println("Invalid Choice");
						continue;
					}
				}
			} else {
				System.out.println("Invalid customer id");
				continue;
			}
		}
	}

	/**
	 * based on the bank name and customer id the operation of the transaction
	 * history is defined. this is ;method used in casher operation process.
	 * 
	 * @param bankName
	 * @param customerId
	 */
	public void transactionHistory(String bankName, int customerId) {
		ArrayList<CustomerDetails> customersList;
		// System.out.println("please enter cusotomer id");
		if (bankName.equals("SBI")) {
			customersList = bankCustomerDatabase.getSbiCustomersList();
			for (CustomerDetails customer : customersList) {
				if (customer.getId() == customerId) {
					for (String transaction : customer.getTransactionHistory()) {
						System.out.println(transaction + "\n");
					}
					break;
				}
			}
		}
		if (bankName.equals("ICICI")) {
			customersList = bankCustomerDatabase.getIciciCustomersList();
			for (CustomerDetails customer : customersList) {
				if (customer.getId() == customerId) {
					for (String transaction : customer.getTransactionHistory()) {
						System.out.println(transaction + "\n");
					}
					break;
				}
			}
		}
		if (bankName.equals("HDFC")) {
			customersList = bankCustomerDatabase.getHdfcCustomersList();
			for (CustomerDetails customer : customersList) {
				if (customer.getId() == customerId) {
					for (String transaction : customer.getTransactionHistory()) {
						System.out.println(transaction + "\n");
					}
					break;
				}
			}
		}
		if (bankName.equals("UBI")) {
			customersList = bankCustomerDatabase.getUbiCustomersList();
			for (CustomerDetails customer : customersList) {
				if (customer.getId() == customerId) {
					for (String transaction : customer.getTransactionHistory()) {
						System.out.println(transaction + "\n");
					}
					break;
				}
			}
		}
	}

	/**
	 * this for the enable the customer who are disabled.
	 * 
	 * @param bankName
	 */
	public void enableCustomerService(String bankName) {
		ArrayList<CustomerDetails> customerList = null;
		if (bankName.equals("SBI")) {
			customerList = bankCustomerDatabase.getSbiCustomersList();
			System.out.println("please pick id of customer wants to enable");
			for (CustomerDetails customer : customerList) {
				if (!customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}

			}
		} else if (bankName.equals("ICICI")) {
			customerList = bankCustomerDatabase.getIciciCustomersList();
			System.out.println("please pick id of customer wants to enable");
			for (CustomerDetails customer : customerList) {
				if (!customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		} else if (bankName.equals("HDFC")) {
			customerList = bankCustomerDatabase.getHdfcCustomersList();
			System.out.println("please pick id of customer wants to enable");
			for (CustomerDetails customer : customerList) {
				if (!customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		} else {
			customerList = bankCustomerDatabase.getUbiCustomersList();
			System.out.println("please pick id of customer wants to enable");
			for (CustomerDetails customer : customerList) {
				if (!customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		}
		while (true) {
			System.out.println("Enter your Choice");
			int customerId = validation.validationForIntegerValues();
			String flag = bankCustomerDatabase.enableCustomer(bankName, customerId);
			if (flag == "success") {
				System.out.println("Successfully enabled\n");
				return;

			} else if (flag == "failure") {
				System.out.println("with this id thier was no customer exist");
				continue;
			} else {
				return;
			}
		}
	}

	/**
	 * This is for temporary deactivate the account, so that the customer account
	 * will not access till the enable option is activate.
	 */
	public void disableCustomerService(String bankName) {
		ArrayList<CustomerDetails> customerList = null;
		if (bankName.equals("SBI")) {
			customerList = bankCustomerDatabase.getSbiCustomersList();
			System.out.println("please pick id of customer wants to disable");
			for (CustomerDetails customer : customerList) {
				if (customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		} else if (bankName.equals("ICICI")) {
			customerList = bankCustomerDatabase.getIciciCustomersList();
			System.out.println("please pick id of customer wants to disable");
			for (CustomerDetails customer : customerList) {
				if (customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		} else if (bankName.equals("HDFC")) {
			customerList = bankCustomerDatabase.getHdfcCustomersList();
			System.out.println("please pick id of customer wants to disable");
			for (CustomerDetails customer : customerList) {
				if (customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		} else {
			customerList = bankCustomerDatabase.getUbiCustomersList();
			System.out.println("please pick id of customer wants to disable");
			for (CustomerDetails customer : customerList) {
				if (customer.getIsActive()) {
					System.out.println("Customer Id:" + customer.getId() + "\n Customer Name:" + customer.getName());
				}
			}
		}
		while (true) {
			System.out.println("Enter your Choice");
			int customerId = validation.validationForIntegerValues();
			String flag = bankCustomerDatabase.disableCustomer(bankName, customerId);
			if (flag == "success") {
				System.out.println("Successfully disabled\n");
				return;

			} else if (flag == "failure") {
				System.out.println("with this id thier was no customer exist");
				continue;
			} else {
				return;
			}
		}
	}

}
