package com.reward.model;

import java.util.List;

public class Customer {
	
	private Integer customerId;

	private String customerName;
	
	private Long totalRewards;
	
	private List<Transaction> transactions;
	
	
	public Customer(Integer customerId, String customerName,  List<Transaction> transactions) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		
		this.transactions = transactions;
	}


	public Customer() {
		
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Long getTotalRewards() {
		
   if (transactions == null || transactions.isEmpty()) return 0l;
		
		return transactions.stream().map(x -> x.getTransactionRewards().intValue()).reduce(0, (a,b) -> a + b).longValue();
		
	}


	public void setTotalRewards(Long totalRewards) {
		this.totalRewards = totalRewards;
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
