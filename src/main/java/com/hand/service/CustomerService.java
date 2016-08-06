package com.hand.service;

import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;

public class CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	
	public boolean existFirstName(String firstName){
		return customerDao.existFirstName(firstName);
	}
	
}
