package com.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reward.model.Customer;
import com.reward.model.Transaction;
import com.reward.service.RewardService;

@RestController
@RequestMapping("/rewards")
public class ReviewControler {
	
	@Autowired
	private RewardService rewardService;
	
	
	@GetMapping("/transactions")
	public List<Transaction> findAllTransactions() {
		return rewardService.getAllTransactions();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerRewardDetails(@PathVariable Integer id) {
		Customer customer = rewardService.findCustomer(id);
		if (customer == null) return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
