package com.billsearch.bean;

public class Payer {
	
	String payerName;
	String payerAddress;
	int dueDate;
	int accountNumber;
	int amount;
	
	
	public Payer(String payerName, String payerAddress, int dueDate, int accountNumber, int amount) {
		super();
		this.payerName = payerName;
		this.payerAddress = payerAddress;
		this.dueDate = dueDate;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public Payer(String payerName) {
		super();
		this.payerName = payerName;
	}
	
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerAddress() {
		return payerAddress;
	}
	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}
	public int getDueDate() {
		return dueDate;
	}
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
