package com.girnar.banking.database;

import java.util.ArrayList;

import com.girnar.banking.details.EmployeeDetails;

/**
 * This is for hard code for the Employee , we need to access some account so
 * while running there is if their is no data so that for access form run time
 * purpose this hard copy is defined.
 * 
 * This is based on the template of the CustomnerDetails.
 *
 */
public class BankEmployeeDatabase {
	private static ArrayList<EmployeeDetails> sbiEmployeesList = new ArrayList<EmployeeDetails>();
	private static ArrayList<EmployeeDetails> hdfcEmployeesList = new ArrayList<EmployeeDetails>();
	private static ArrayList<EmployeeDetails> ubiEmployeesList = new ArrayList<EmployeeDetails>();
	private static ArrayList<EmployeeDetails> iciciEmployeesList = new ArrayList<EmployeeDetails>();

	static {
		sbiEmployeesList.add(new EmployeeDetails(1, "Hari", "male", "Salesman", true));
		sbiEmployeesList.add(new EmployeeDetails(2, "Jai", "male", "Employee", true));
		sbiEmployeesList.add(new EmployeeDetails(3, "Ram", "male", "Cashier", true));
		sbiEmployeesList.add(new EmployeeDetails(4, "Mani", "Female", "Manager", true));
		hdfcEmployeesList.add(new EmployeeDetails(1, "karan", "male", "Salesman", true));
		hdfcEmployeesList.add(new EmployeeDetails(2, "abhi", "male", "Employee", true));
		hdfcEmployeesList.add(new EmployeeDetails(3, "kalyan", "male", "Cashier", true));
		hdfcEmployeesList.add(new EmployeeDetails(4, "Mouli", "Female", "Manager", true));
		iciciEmployeesList.add(new EmployeeDetails(1, "koti", "male", "Salesman", true));
		iciciEmployeesList.add(new EmployeeDetails(2, "ramji", "male", "Employee", true));
		iciciEmployeesList.add(new EmployeeDetails(3, "dinu", "male", "Cashier", true));
		iciciEmployeesList.add(new EmployeeDetails(4, "gandi", "Female", "Manager", true));
		ubiEmployeesList.add(new EmployeeDetails(1, "sudheer", "male", "Salesman", true));
		ubiEmployeesList.add(new EmployeeDetails(2, "kotesh", "male", "Employee", true));
		ubiEmployeesList.add(new EmployeeDetails(3, "Ramulu", "male", "Cashier", true));
		ubiEmployeesList.add(new EmployeeDetails(4, "pawan", "Female", "Manager", true));
	}

	public int insertEmployeeInDb(String bankName, EmployeeDetails employeeDetails) {
		switch (bankName) {
		case "SBI":

			if (employeeDetails != null && employeeDetails.getId() == 0) {
				employeeDetails.setId(sbiEmployeesList.size() + 1);
				sbiEmployeesList.add(employeeDetails);
				return sbiEmployeesList.size();
			}
			return 0;

		case "HDFC":
			if (employeeDetails != null && employeeDetails.getId() == 0) {
				employeeDetails.setId(hdfcEmployeesList.size() + 1);
				hdfcEmployeesList.add(employeeDetails);
				return hdfcEmployeesList.size();
			}

			return 0;
		case "ICICI":
			if (employeeDetails != null && employeeDetails.getId() == 0) {
				employeeDetails.setId(iciciEmployeesList.size() + 1);
				iciciEmployeesList.add(employeeDetails);
				return iciciEmployeesList.size();
			}

			return 0;
		case "UBI":
			if (employeeDetails != null && employeeDetails.getId() == 0) {
				employeeDetails.setId(ubiEmployeesList.size() + 1);
				ubiEmployeesList.add(employeeDetails);
				return ubiEmployeesList.size();
			}

			return 0;

		}
		return 0;
	}

	/**
	 * get a details of Employee by id is done hear.so that access in this.
	 * 
	 * @param bankName
	 * @param employeeId
	 * @return
	 */
	public EmployeeDetails getEmployeeById(String bankName, int employeeId) {

		switch (bankName) {
		case "SBI":
			for (EmployeeDetails employeeDetails : sbiEmployeesList) {
				if (employeeDetails.getId() == employeeId) {
					return employeeDetails;
				}
			}
			return null;
		case "HDFC":
			for (EmployeeDetails employeeDetails : hdfcEmployeesList) {
				if (employeeDetails.getId() == employeeId) {
					return employeeDetails;
				}
			}
			return null;
		case "ICICI":
			for (EmployeeDetails employeeDetails : iciciEmployeesList) {
				if (employeeDetails.getId() == employeeId) {
					return employeeDetails;
				}
			}
			return null;
		case "UBI":
			for (EmployeeDetails employeeDetails : ubiEmployeesList) {
				if (employeeDetails.getId() == employeeId) {
					return employeeDetails;
				}
			}
			return null;

		}
		return null;
	}

	/**
	 * from the customer service will come hear this is for return process is
	 * status. so we need this for confirmation.
	 * 
	 * @param bankName
	 * @param employeeId
	 * @return
	 */
	public String disableEmployee(String bankName, int employeeId) {
		switch (bankName) {
		case "SBI":
			for (EmployeeDetails employee : sbiEmployeesList) {
				if (employee.getId() == employeeId) {
					if (employee.getIsActive()) {
						employee.setIsActive(false);
						return "success";
					} else {
						System.out.println("is a already inactive employee");
						return null;
					}

				}
			}
			return "failure";
		case "HDFC":
			for (EmployeeDetails employee : hdfcEmployeesList) {
				if (employee.getId() == employeeId) {
					if (employee.getIsActive()) {
						employee.setIsActive(false);
						return "success";
					} else {
						System.out.println("is a already inactive employee");
						return null;
					}

				}
			}
			return "failure";
		case "ICICI":
			for (EmployeeDetails employee : iciciEmployeesList) {
				if (employee.getId() == employeeId) {
					if (employee.getIsActive()) {
						employee.setIsActive(false);
						return "success";
					} else {
						System.out.println("is a already inactive employee");
						return null;
					}

				}
			}
			return "failure";
		case "UBI":
			for (EmployeeDetails employee : ubiEmployeesList) {
				if (employee.getId() == employeeId) {
					if (employee.getIsActive()) {
						employee.setIsActive(false);
						return "success";
					} else {
						System.out.println("is a already inactive employee");
						return null;
					}

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
	public String enableEmployee(String bankName, int employeeId) {
		switch (bankName) {
		case "SBI":
			for (EmployeeDetails employee : sbiEmployeesList) {
				if (employee.getId() == employeeId) {
					if (!employee.getIsActive()) {
						employee.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active employee");
						return null;
					}

				}
			}
			return "failure";
		case "HDFC":
			for (EmployeeDetails employee : hdfcEmployeesList) {
				if (employee.getId() == employeeId) {
					if (!employee.getIsActive()) {
						employee.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active employee");
						return null;
					}

				}
			}
			return "failure";
		case "ICICI":
			for (EmployeeDetails employee : iciciEmployeesList) {
				if (employee.getId() == employeeId) {
					if (!employee.getIsActive()) {
						employee.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active employee");
						return null;
					}

				}
			}
			return "failure";
		case "UBI":
			for (EmployeeDetails employee : ubiEmployeesList) {
				if (employee.getId() == employeeId) {
					if (!employee.getIsActive()) {
						employee.setIsActive(true);
						return "success";
					} else {
						System.out.println("is a already active employee");
						return null;
					}

				}
			}
			return "failure";
		}
		return "failure";
	}

	public boolean updatedEmployeeDetails(String bankName, EmployeeDetails employeeDetails) {
		switch (bankName) {
		case "SBI":
			for (EmployeeDetails employee : sbiEmployeesList) {
				if (employee.getId() == employeeDetails.getId()) {
					employee.setName(employeeDetails.getName());
					employee.setGender(employeeDetails.getGender());
					employee.setEmployeeDesignation(employeeDetails.getEmployeeDesignation());
					return true;
				}
			}
			return false;
		case "HDFC":
			for (EmployeeDetails employee : hdfcEmployeesList) {
				if (employee.getId() == employeeDetails.getId()) {
					employee.setName(employeeDetails.getName());
					employee.setGender(employeeDetails.getGender());
					employee.setEmployeeDesignation(employeeDetails.getEmployeeDesignation());
					return true;
				}
			}
			return false;
		case "ICICI":
			for (EmployeeDetails employee : iciciEmployeesList) {
				if (employee.getId() == employeeDetails.getId()) {
					employee.setName(employeeDetails.getName());
					employee.setGender(employeeDetails.getGender());
					employee.setEmployeeDesignation(employeeDetails.getEmployeeDesignation());
					return true;
				}
			}
			return false;
		case "UBI":
			for (EmployeeDetails employee : ubiEmployeesList) {
				if (employee.getId() == employeeDetails.getId()) {
					employee.setName(employeeDetails.getName());
					employee.setGender(employeeDetails.getGender());
					employee.setEmployeeDesignation(employeeDetails.getEmployeeDesignation());
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public ArrayList<EmployeeDetails> getSbiEmployeesList() {
		return sbiEmployeesList;
	}

	public ArrayList<EmployeeDetails> getHdfcEmployeesList() {
		return hdfcEmployeesList;
	}

	public ArrayList<EmployeeDetails> getUbiEmployeesList() {
		return ubiEmployeesList;
	}

	public ArrayList<EmployeeDetails> getIciciEmployeesList() {
		return iciciEmployeesList;
	}

}
