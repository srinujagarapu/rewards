package com.reward.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.dao.RewardDao;
import com.reward.model.Customer;
import com.reward.model.Transaction;

@Service
public class RewardService {
	
	@Autowired
	private RewardDao rewardDao;
	
	
	public List<Transaction> getAllTransactions(){
		
		return rewardDao.getTransactio();
	}
	
    public Customer findCustomer(int id){
		
		return rewardDao.getCustmerlastThreeMonths(id);
	}

}
