package com.girnar.banking.details;

import java.util.ArrayList;
/**
 * It is Extends of Details Class so that it is uses Details Class entities also.
 * so hear we are using this as CustomerDetails as template or like data type.
 * 
 *hear we used one array list for transaction history purpose.
 */
public class CustomerDetails extends Details {

	private int accountBalance;
	private ArrayList<String> transactionHistory = new ArrayList<String>();

	public CustomerDetails(int id, String name, String gender, int accountBalance, boolean isActive, String history) {
		super(id, name, gender, isActive);
		this.accountBalance = accountBalance;
		setValues(history);
	}

	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<String> transectionHistory) {
		this.transactionHistory = transectionHistory;
	}

	public void setValues(String history) {
		transactionHistory.add(history);
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
}
