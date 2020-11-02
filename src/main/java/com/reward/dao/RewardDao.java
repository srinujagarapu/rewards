package com.reward.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.reward.model.Customer;
import com.reward.model.Transaction;

@Service
public class RewardDao {
	
	private static List<Customer> customers = new ArrayList<>();
	
	private static List<Transaction> transListOne= new ArrayList<>();
	
	private static List<Transaction> transListTwo= new ArrayList<>();
	
	private static List<Transaction> transListThree= new ArrayList<>();
	
	private static List<Transaction> transactions= new ArrayList<>();
	
	private static long transId;
	
	private static int custId;
	
	
	static {
		transListOne.add( new Transaction(transId++, 110.0, new Date()));
		transListOne.add( new Transaction(transId++, 115.0, new Date()));
		transListOne.add( new Transaction(transId++, 120.0, new Date()));
		transListOne.add( new Transaction(transId++, 50.0, new Date()));
		
		transListTwo.add( new Transaction(transId++, 110.0, new Date()));
		transListTwo.add( new Transaction(transId++, 115.0, new Date()));
		transListTwo.add( new Transaction(transId++, 120.0, new Date()));
		transListTwo.add( new Transaction(transId++, 50.0, new Date()));
		
		transListThree.add( new Transaction(transId++, 110.0, new Date()));
		transListThree.add( new Transaction(transId++, 115.0, new Date()));
		transListThree.add( new Transaction(transId++, 120.0, new Date()));
		transListThree.add( new Transaction(transId++, 50.0, new Date()));
		
		customers.add(new Customer(custId++,"srinu",transListOne));
		customers.add(new Customer(custId++,"vasu",transListTwo));
		customers.add(new Customer(custId++,"mahi",transListThree));
		transactions.addAll(transListOne);
		transactions.addAll(transListTwo);
		transactions.addAll(transListThree);
		
	}
	
	
	public List<Transaction> getTransactio(){
	
		return transactions ;
		
	}
	
	public Customer getCustomer(int id) {
		return customers.stream().filter(x ->x.getCustomerId().intValue()==id).findFirst().orElse(null);
	}
	
	public Customer getCustmerlastThreeMonths(int id) {
		  Customer customer = new Customer();
		  List<Transaction> transactions = new ArrayList<>();
		  Customer cust=  customers.stream().filter(x ->x.getCustomerId().intValue()==id).findFirst().orElse(null);
		  
		  if(cust!=null) {
	        for(int i=0; i<3; i++) {
	           
	        	int j=i;
				List<Transaction> filteredList =  cust.getTransactions().stream().filter(trans -> trans.getTransactionDate().getMonth() == (new Date()).getMonth() - j).collect(Collectors.toList());
				transactions.addAll(filteredList);
	        }
	        
	        customer.setCustomerId(cust.getCustomerId());
	        customer.setCustomerName(cust.getCustomerName());
	        customer.setTransactions(transactions);
	        return customer;
		  }
		  else {
			  return null;
		  }
	    }
	

}
