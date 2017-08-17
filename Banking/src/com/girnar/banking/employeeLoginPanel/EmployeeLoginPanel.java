package com.girnar.banking.employeeLoginPanel;

import com.girnar.banking.details.EmployeeDetails;
import com.girnar.banking.services.CustomerService;
import com.girnar.banking.services.EmployeeServices;
import com.girnar.banking.validation.Validation;

/**
 * This is all about banking services like crating of CUSTOMER and EMPLOYEE,
 * login pages ,balance operations like withdraw , diposite and transation
 * history. Like wise options of view customer details and editing.
 * 
 * almost all basic thing which bank will do are in this part.
 * 
 * @author Harish
 *
 */
public class EmployeeLoginPanel {

	private static Validation validation = new Validation();
	private EmployeeServices employeeServices = new EmployeeServices();
	private CustomerService customerService = new CustomerService();

	public static void main(String[] args) {
		EmployeeLoginPanel employeeLoginPanel = new EmployeeLoginPanel();
		while (true) {
			System.out.println("Choose your Bank\n");
			System.out.println("1. SBI");
			System.out.println("2. ICICI");
			System.out.println("3. HDFC");
			System.out.println("4. UBI");
			System.out.println("5. Exit\n");
			System.out.println("Enter your choice");
			int choice = validation.validationForIntegerValues();
			switch (choice) {
			case 1:
				System.out.println("Welcome to SBI\n");
				employeeLoginPanel.employeeLoginProcess("SBI");
				break;
			case 2:
				System.out.println("Welcome to ICICI\n");
				employeeLoginPanel.employeeLoginProcess("ICICI");
				break;
			case 3:
				System.out.println("Welcome to HDFC\n");
				employeeLoginPanel.employeeLoginProcess("HDFC");
				break;
			case 4:
				System.out.println("Welcome to UBI\n");
				employeeLoginPanel.employeeLoginProcess("UBI");
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice");
				continue;
			}
		}
	}

	/**
	 * this will give login page for employee based on the banks and bank employee
	 * will login using id as access .
	 * 
	 * @param bankName
	 */
	public void employeeLoginProcess(String bankName) {
		// EmployeeServices employeeServices = new EmployeeServices();
		EmployeeDetails selectedEmployee = null;
		System.out.println("please Enter EmployeeId");
		while (true) {
			int employeeId = validation.validationForIntegerValues();
			selectedEmployee = employeeServices.getSelectedEmployeeDetails(bankName, employeeId);
			if (selectedEmployee != null) {
				switch (selectedEmployee.getEmployeeDesignation()) {

				case "Salesman":
					salesManProcess(bankName);
					System.out.println("Sussessfully Logout");
					return;
				case "Employee":
					employeeProcess(bankName);
					System.out.println("Sussessfully Logout");
					return;
				case "Cashier":
					cashierProcess(bankName);
					System.out.println("Sussessfully Logout");
					return;
				case "Manager":
					mangerProcess(bankName);
					System.out.println("Sussessfully Logout");
					return;
				}
			} else {
				System.out.println("please Enter valid ID");
				continue;
			}
		}

	}

	/**
	 * Based on employee designation the process of work will changes from employee
	 * to employee in mean while salesman will work of credit card selling and forms
	 * uploading so the requirement up to document uploads
	 * 
	 * @param bankName
	 */
	public void salesManProcess(String bankName) {
		customerService.documentUploadProcess(bankName);
	}

	/**
	 * Employee can do profile managing or handing like profile editing, balance
	 * checking .
	 * 
	 * @param bankName
	 */
	public void employeeProcess(String bankName) {

		while (true) {
			System.out.println("1. View Details of customer  ");
			System.out.println("2. Edit the details of customer");
			System.out.println("3. Check the Balance of customer");
			System.out.println("4. Create Account");
			System.out.println("5. Disable Customer");
			System.out.println("6. Enable Customer");
			System.out.println("7. Exit\n");

			System.out.println("Enter your Choice ");
			int choice = validation.validationForIntegerValues();
			switch (choice) {
			case 1:
				customerService.viewDetailsProcess(bankName);
				break;
			case 2:
				customerService.editDetailsProcess(bankName);
				break;
			case 3:
				customerService.showAccountBalance(bankName);
				break;
			case 4:
				customerService.addCustomer(bankName);
				break;
			case 5:
				customerService.disableCustomerService(bankName);
				break;
			case 6:
				customerService.enableCustomerService(bankName);
				break;
			case 7:
				return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	/**
	 * Casher main is withdraw and deposition. and meanwhile he check our
	 * transaction. this is done hear.
	 * 
	 * @param bankName
	 */

	public void cashierProcess(String bankName) {
		
		customerService.balanceProcess(bankName);
	}

	/**
	 * Manger can do anything which all employee do.He have that access and either
	 * than that he can handle a bank staff.
	 * 
	 * @param bankName
	 */
	public void mangerProcess(String bankName) {
		while (true) {
			System.out.println("1. Document uploads");
			System.out.println("2. View Details of Customer  ");
			System.out.println("3. Edit details of Customer");
			System.out.println("4. Edit details of Employee ");
			System.out.println("5. Check the Balance of customer");
			System.out.println("6. Balance operation");
			System.out.println("7. Create New Employee");
			System.out.println("8. Create New Customer");
			System.out.println("9. Disable Employee");
			System.out.println("10. Enable Employee");
			System.out.println("11. Disable Customer");
			System.out.println("12. Enable Customer");
			System.out.println("13. Exit\n");

			System.out.println("Enter your choice ");
			int choice = validation.validationForIntegerValues();
			switch (choice) {
			case 1: {
				customerService.documentUploadProcess(bankName);
				break;
			}
			case 2: {
				customerService.viewDetailsProcess(bankName);
				break;
			}
			case 3: {
				customerService.editDetailsProcess(bankName);
				break;
			}
			case 4:
				break;
			case 5: {
				customerService.showAccountBalance(bankName);
				break;
			}
			case 6: {
				customerService.balanceProcess(bankName);
				break;
			}
			case 7:
				employeeServices.addEmployee(bankName);
				break;
			case 8:
				customerService.addCustomer(bankName);
				break;
			case 9:
				employeeServices.disableEmployeeService(bankName);
				break;
			case 10:
				employeeServices.enableEmployeeService(bankName);
				break;
			case 11:
				customerService.disableCustomerService(bankName);
				break;
			case 12:
				customerService.enableCustomerService(bankName);
				break;
			case 13:
				return;
			default: {
				System.out.println("Invalied choice");
				continue;
			}
			}
		}
	}
}
