package com.girnar.banking.details;

/**
 * This is like template for information purpose.
 * It used hear as a parent class for CustomerDetails and EmployeeDetails.
 * so for it is used as data type.
 * @author gspl
 *
 */
public class Details {

	private int id;
	private String name;
	private String gender;
	private boolean isActive;

	public Details(int id, String name, String gender, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.setIsActive(isActive);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
