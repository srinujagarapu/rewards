package com.reward.model;

import java.util.Date;

public class Transaction {
	
	private Long transactionId;
	
	private Double purchaseAmt;
	
	private Date transactionDate;
	
	private Long transactionRewards;
	
	
	
	
	public Transaction( Long transactionId, Double purchaseAmt, Date transactionDate) {
		
		this.transactionId=transactionId;
		this.purchaseAmt=purchaseAmt;
		this.transactionDate=transactionDate;
		
	}


	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public Double getPurchaseAmt() {
		return purchaseAmt;
	}


	public void setPurchaseAmt(Double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public Long getTransactionRewards() {
        this.transactionRewards = 0l;
		
		if (this.purchaseAmt > 50 && this.purchaseAmt <= 100) {
			this.transactionRewards += (this.purchaseAmt.intValue() - 50) * 1;
			
		} 
		
		if (this.purchaseAmt > 100) {
			this.transactionRewards += 50;  
			this.transactionRewards += (this.purchaseAmt.intValue() - 100) * 2;  
		
		}
		return this.transactionRewards;
	}




	

}
