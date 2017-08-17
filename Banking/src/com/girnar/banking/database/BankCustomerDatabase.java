package com.girnar.banking.database;

import java.util.ArrayList;
import com.girnar.banking.details.CustomerDetails;

/**
 * This is for hard code for the Customer , we need to access some account so
 * while running there is if their is no data so that for access form run time
 * purpose this hard copy is defined.
 * 
 * This is based on the template of the CustomnerDetails.
 *
 */
public class BankCustomerDatabase {

	private static ArrayList<CustomerDetails> sbiCustomersList = new ArrayList<CustomerDetails>();
	private static ArrayList<CustomerDetails> hdfcCustomersList = new ArrayList<CustomerDetails>();
	private static ArrayList<CustomerDetails> iciciCustomersList = new ArrayList<CustomerDetails>();
	private static ArrayList<CustomerDetails> ubiCustomersList = new ArrayList<CustomerDetails>();

	static {
		sbiCustomersList.add(new CustomerDetails(1, "Hari", "male", 10000, true, "10000 rupees deposited"));
		sbiCustomersList.add(new CustomerDetails(2, "Jai", "male", 20000, true, "20000 rupees deposite"));
		sbiCustomersList.add(new CustomerDetails(3, "Ram", "male", 100000, true, "100000 rupees deposited"));
		sbiCustomersList.add(new CustomerDetails(4, "Mani", "Female", 2500, true, "2500 rupees deposited"));
		hdfcCustomersList.add(new CustomerDetails(1, "karan", "male", 25000, true, "25000 rupees deposited"));
		hdfcCustomersList.add(new CustomerDetails(2, "abhi", "male", 5000, true, "5000 rupees deposited"));
		hdfcCustomersList.add(new CustomerDetails(3, "kalyan", "male", 35000, true, "35000 rupees deposited"));
		hdfcCustomersList.add(new CustomerDetails(4, "Mouli", "Female", 34000, true, "34000 rupees deposited"));
		iciciCustomersList.add(new CustomerDetails(1, "koti", "male", 2300, true, "2300 rupees deposited"));
		iciciCustomersList.add(new CustomerDetails(2, "ramji", "male", 10000, true, "10000 rupees deposited"));
		iciciCustomersList.add(new CustomerDetails(3, "dinu", "male", 81000, true, "81000 rupees deposited"));
		iciciCustomersList.add(new CustomerDetails(4, "gandi", "Female", 4000, true, "4000 rupees deposited"));
		ubiCustomersList.add(new CustomerDetails(1, "sudheer", "male", 3600, true, "3600 rupees deposited"));
		ubiCustomersList.add(new CustomerDetails(2, "kotesh", "male", 4000, true, "4000 rupees deposited"));
		ubiCustomersList.add(new CustomerDetails(3, "Ramulu", "male", 12000, true, "12000 rupees deposited"));
		ubiCustomersList.add(new CustomerDetails(4, "pawan", "Female", 10000, true, "10000 rupees deposited"));
	}

	public CustomerDetails getCustomerById(String bankName, int customerId) {

		switch (bankName) {
		case "SBI":
			for (CustomerDetails customerDetails : sbiCustomersList) {
				if (customerDetails.getId() == customerId) {
					return customerDetails;
				}
			}
			return null;
		case "HDFC":
			for (CustomerDetails customerDetails : hdfcCustomersList) {
				if (customerDetails.getId() == customerId) {
					return customerDetails;
				}
			}
			return null;
		case "ICICI":
			for (CustomerDetails customerDetails : iciciCustomersList) {
				if (customerDetails.getId() == customerId) {
					return customerDetails;
				}
			}
			return null;
		case "UBI":
			for (CustomerDetails customerDetails : ubiCustomersList) {
				if (customerDetails.getId() == customerId) {
					return customerDetails;
				}
			}
			return null;
		}
		return null;
	}

	public boolean updateCustomerDetails(String bankName, CustomerDetails customerDetails) {
		switch (bankName) {
		case "SBI":
			for (CustomerDetails customer : sbiCustomersList) {
				if (customer.getId() == customerDetails.getId()) {
					customer.setName(customerDetails.getName());
					customer.setGender(customerDetails.getGender());
					customer.setAccountBalance(customerDetails.getAccountBalance());
					customer.setTransactionHistory(customerDetails.getTransactionHistory());
					return true;
				}
			}
			return false;
		case "HDFC":
			for (CustomerDetails customer : hdfcCustomersList) {
				if (customer.getId() == customerDetails.getId()) {
					customer.setName(customerDetails.getName());
					customer.setGender(customerDetails.getGender());
					customer.setAccountBalance(customerDetails.getAccountBalance());
					customer.setTransactionHistory(customerDetails.getTransactionHistory());
					return true;
				}
			}
			return false;
		case "ICICI":
			for (CustomerDetails customer : iciciCustomersList) {
				if (customer.getId() == customerDetails.getId()) {
					customer.setName(customerDetails.getName());
					customer.setGender(customerDetails.getGender());
					customer.setAccountBalance(customerDetails.getAccountBalance());
					customer.setTransactionHistory(customerDetails.getTransactionHistory());
					return true;
				}
			}
			return false;
		case "UBI":
			for (CustomerDetails customer : ubiCustomersList) {
				if (customer.getId() == customerDetails.getId()) {
					customer.setName(customerDetails.getName());
					customer.setGender(customerDetails.getGender());
					customer.setAccountBalance(customerDetails.getAccountBalance());
					customer.setTransactionHistory(customerDetails.getTransactionHistory());
					return true;
				}
			}
			return false;
		}
		return false;
	}

	/**
	 * Insert a customer that is new customer option is their means we need to add
	 * it in the array list so that purpose this method is used.
	 */
	public int insertCustomerInDatabase(String bankName, CustomerDetails customerDetails) {
		switch (bankName) {
		case "SBI":

			if (customerDetails != null && customerDetails.getId() == 0) {
				customerDetails.setId(sbiCustomersList.size() + 1);
				sbiCustomersList.add(customerDetails);
				return sbiCustomersList.size();
			}
			return 0;

		case "HDFC":
			if (customerDetails != null && customerDetails.getId() == 0) {
				customerDetails.setId(hdfcCustomersList.size() + 1);
				hdfcCustomersList.add(customerDetails);
				return hdfcCustomersList.size();
			}

			return 0;
		case "ICICI":
			if (customerDetails != null && customerDetails.getId() == 0) {
				customerDetails.setId(iciciCustomersList.size() + 1);
				iciciCustomersList.add(customerDetails);
				return iciciCustomersList.size();
			}

			return 0;
		case "UBI":
			if (customerDetails != null && customerDetails.getId() == 0) {
				customerDetails.setId(ubiCustomersList.size() + 1);
				ubiCustomersList.add(customerDetails);
				return ubiCustomersList.size();
			}

			return 0;
		}
		return 0;
	}

	/**
	 * from the customer service will come hear this is for return process is
	 * status. so we need this for confirmation.
	 * 
	 * @param bankName
	 * @param customerId
	 * @return
	 */
	public String disableCustomer(String bankName, int customerId) {
		switch (bankName) {
		case "SBI":
			for (CustomerDetails customer : sbiCustomersList) {
				if (customer.getId() == customerId) {
					if (customer.getIsActive()) {
						customer.setIsActive(false);
						return "success";
					} else {
						System.out.println("is already inactive ");
						return null;
					}
				}
			}
			return "failure";
		case "HDFC":
			for (CustomerDetails customer : hdfcCustomersList) {
				if (customer.getId() == customerId) {
					if (customer.getIsActive()) {
						customer.setIsActive(false);
						return "success";
					} else {
						System.out.println("is already inactive ");
						return null;
					}
				}
			}
			return "failure";
		case "ICICI":
			for (CustomerDetails customer : iciciCustomersList) {
				if (customer.getIsActive()) {
					customer.setIsActive(false);
					return "success";
				} else {
					System.out.println("is already inactive ");
					return null;
				}
			}

			return "failure";
		case "UBI":
			for (CustomerDetails customer : ubiCustomersList) {
				if (customer.getIsActive()) {
					customer.setIsActive(false);
					return "success";
				} else {
					System.out.println("is already inactive ");
					return null;
				}
			}

			return "failure";
		}
		return "failure";
	}

	/**
	 * from the customer service will come hear this is for return process is
	 * status. so we need this for confirmation.
	 * 
	 * @param bankName
	 * @param employeeId
	 * @return
	 */
	public String enableCustomer(String bankName, int employeeId) {
		switch (bankName) {
		case "SBI":
			for (CustomerDetails customer : sbiCustomersList) {
				if (customer.getId() == employeeId) {
					if (!customer.getIsActive()) {
						customer.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active Customer");
						return null;
					}
				}
			}
			return "failure";
		case "HDFC":
			for (CustomerDetails customer : hdfcCustomersList) {
				if (customer.getId() == employeeId) {
					if (!customer.getIsActive()) {
						customer.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active Customer");
						return null;
					}
				}
			}
			return "failure";
		case "ICICI":
			for (CustomerDetails customer : iciciCustomersList) {
				if (customer.getId() == employeeId) {
					if (!customer.getIsActive()) {
						customer.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active Customer");
						return null;
					}
				}
			}
			return "failure";
		case "UBI":
			for (CustomerDetails customer : ubiCustomersList) {
				if (customer.getId() == employeeId) {
					if (!customer.getIsActive()) {
						customer.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active Customer");
						return null;
					}
				}
			}
			return "failure";
		}
		return "failure";
	}

	public ArrayList<CustomerDetails> getSbiCustomersList() {
		return sbiCustomersList;
	}

	public ArrayList<CustomerDetails> getHdfcCustomersList() {
		return hdfcCustomersList;
	}

	public ArrayList<CustomerDetails> getIciciCustomersList() {
		return iciciCustomersList;
	}

	public ArrayList<CustomerDetails> getUbiCustomersList() {
		return ubiCustomersList;
	}
}
