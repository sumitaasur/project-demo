package com.girnar.banking.services;

import java.util.ArrayList;

import com.girnar.banking.database.BankEmployeeDatabase;
import com.girnar.banking.details.EmployeeDetails;
import com.girnar.banking.validation.Validation;

/**
 * hear the total services of the Employee will be done. Like disable, enable,
 * creating and employee list. all requirements of employee service are to be
 * done hear.
 *
 */
public class EmployeeServices {
	private Validation validation = new Validation();
	// private CustomerService customerService = new CustomerService();
	private BankEmployeeDatabase bankEmployeeDatabase = new BankEmployeeDatabase();

	/**
	 * addEmployee this is the method for create a new employee purpose. this is can
	 * handle by only a manger so that it is called at manger process.
	 * 
	 */
	public void addEmployee(String bankName) {
		int id = 0;
		String name;
		String gender;
		String designation;
		boolean isActive = true;
		System.out.println("Please Enter Name");
		name = validation.validationForStringValues();
		while (true) {
			System.out.println("Please Enter gender male/female");
			gender = validation.validationForStringValues();
			if (gender.toLowerCase().equals("male") || gender.equals("female")) {
				break;
			} else {
				continue;
			}
		}
		while (true) {
			System.out.println("Please pick any one of the following designation\n");
			System.out.println("1.SalesMan");
			System.out.println("2.Employee");
			System.out.println("3.Casher");
			System.out.println("\n enter your choice ");
			int choice = validation.validationForIntegerValues();
			switch (choice) {
			case 1:
				designation = "Salesman";
				break;
			case 2:
				designation = "Employee";
				break;
			case 3:
				designation = "Cashier";
				break;
			default:
				System.out.println("Invalid Choice");
				continue;
			}
			break;
		}
		int newEmployeeId = bankEmployeeDatabase.insertEmployeeInDb(bankName,
				new EmployeeDetails(id, name, gender, designation, isActive));
		if (newEmployeeId != 0) {
			System.out.println("Successfully Created\n");
			System.out.println(
					"Employee Id : " + newEmployeeId + "\nEmployee Name : " + name + "\nDesignation : " + designation);
		}
	}

	/*
	 * this is for temporary disabling a account purpose this method is used.
	 * 
	 */
	public void disableEmployeeService(String bankName) {
		ArrayList<EmployeeDetails> employeesList = null;
		if (bankName.equals("SBI")) {
			employeesList = bankEmployeeDatabase.getSbiEmployeesList();
			System.out.println("please pick id of employee wants to disable");
			for (EmployeeDetails employee : employeesList) {
				if (employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		} else if (bankName.equals("ICICI")) {
			employeesList = bankEmployeeDatabase.getIciciEmployeesList();
			System.out.println("please pick id of employee wants to disable");
			for (EmployeeDetails employee : employeesList) {
				if (employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		} else if (bankName.equals("HDFC")) {
			employeesList = bankEmployeeDatabase.getHdfcEmployeesList();
			System.out.println("please pick id of employee wants to disable");
			for (EmployeeDetails employee : employeesList) {
				if (employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		} else {
			employeesList = bankEmployeeDatabase.getUbiEmployeesList();
			System.out.println("please pick id of employee wants to disable");
			for (EmployeeDetails employee : employeesList) {
				if (employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		}
		while (true) {
			System.out.println("Enter your Choice");
			int employeeId = validation.validationForIntegerValues();
			String flag = bankEmployeeDatabase.disableEmployee(bankName, employeeId);
			if (flag.equals("success")) {
				System.out.println("Successfully disabled\n");
				return;

			} else if (flag.equals("failure")) {
				System.out.println("with this id thier was no employee exist");
				continue;
			}
		}
	}

	/*
	 * Hear the thing is enable the disabled accounts. that means in general some
	 * accounts disable temporary so that there used to have option for enable so
	 * hear the process will done.
	 * 
	 */
	public void enableEmployeeService(String bankName) {
		ArrayList<EmployeeDetails> employeesList = null;
		if (bankName.equals("SBI")) {
			employeesList = bankEmployeeDatabase.getSbiEmployeesList();
			System.out.println("please pick id of employee wants to enable");
			for (EmployeeDetails employee : employeesList) {
				if (!employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		} else if (bankName.equals("ICICI")) {
			employeesList = bankEmployeeDatabase.getIciciEmployeesList();
			System.out.println("please pick id of employee wants to enable");
			for (EmployeeDetails employee : employeesList) {
				if (!employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		} else if (bankName.equals("HDFC")) {
			employeesList = bankEmployeeDatabase.getHdfcEmployeesList();
			System.out.println("please pick id of employee wants to enable");
			for (EmployeeDetails employee : employeesList) {
				if (!employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		} else {
			employeesList = bankEmployeeDatabase.getUbiEmployeesList();
			System.out.println("please pick id of employee wants to enable");
			for (EmployeeDetails employee : employeesList) {
				if (!employee.getIsActive()) {
					System.out.println("EmployeeId:" + employee.getId() + "\n EmployeeName:" + employee.getName());
				}
			}
		}
		while (true) {
			System.out.println("Enter your Choice");
			int employeeId = validation.validationForIntegerValues();
			String flag = bankEmployeeDatabase.enableEmployee(bankName, employeeId);
			if (flag.equals("success")) {
				System.out.println("Successfully enabled\n");
				return;

			} else if (flag.equals("failure")) {
				System.out.println("with this id thier was no employee exist");
				continue;
			}
		}
	}

	/*
	 * this is for background operation of the get a details by enter the id. This
	 * operation used mostly is is checking purpose.
	 */
	public EmployeeDetails getSelectedEmployeeDetails(String bankName, int employeeId) {
		EmployeeDetails employeeDetails = bankEmployeeDatabase.getEmployeeById(bankName, employeeId);
		if (employeeDetails != null) {
			return employeeDetails;
		}
		return null;
	}
	
	/**
	 * this for the edit a profile of the employee.
	 * @param bankName
	 */
	public void editDetailsProcess(String bankName) {
		while (true) {
			System.out.println("Enter the Your Employee ID");
			int employeeId = validation.validationForIntegerValues();
			EmployeeDetails selectedEmplooyeeDetails = bankEmployeeDatabase.getEmployeeById(bankName, employeeId);

			if (selectedEmplooyeeDetails != null) {
				while (true) {
					System.out.println("Which Details you want to Edit");
					System.out.println("1.Name \n2.Gender \n");
					System.out.println("Enter your choice");
					int choice = validation.validationForIntegerValues();

					switch (choice) {
					case 1:
						System.out.println("Please enter new name");
						String name = validation.validationForStringValues();// scanner.nextLine();

						if (!name.equals(selectedEmplooyeeDetails.getName())) {
							selectedEmplooyeeDetails.setName(name);
							bankEmployeeDatabase.updatedEmployeeDetails(bankName, selectedEmplooyeeDetails);
							System.out.println("Changed successFully\n");
							return;
						} else {
							System.out.println("previous name current changing name both are same\n");
							return;
						}
					case 2:
						System.out.println("Please enter new gender");
						String gender = validation.validationForStringValues();// scanner.nextLine();
						if (gender != selectedEmplooyeeDetails.getName()
								&& (gender.toLowerCase() == "male" || gender.toLowerCase() == "Female")) {
							selectedEmplooyeeDetails.setName(gender);
							bankEmployeeDatabase.updatedEmployeeDetails(bankName, selectedEmplooyeeDetails);
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
				System.out.println("Invalid employee id");
				continue;
			}
		}
	}

}
