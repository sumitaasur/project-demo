package com.girnar.banking.details;

/**
 * It is Extends of Details Class so that it is uses Details Class entities
 * also. so hear we are using this as EmployeeDetails as template or like data
 * type.
 * 
 */
public class EmployeeDetails extends Details {

	private String employeeDesignation;

	public EmployeeDetails(int id, String name, String gender, String employeeDesignation, boolean isActive) {
		super(id, name, gender, isActive);
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
}
