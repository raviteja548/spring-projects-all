package com.mkyong.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.mkyong.customer.dao.CustomerDAO;
import com.mkyong.customer1.dao.Customer1DAO;
 
@Component
public class CustomerService 
{
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	Customer1DAO customer1dao;
 
	@Override
	public String toString() {
		return "CustomerService [customerDAO=" + customerDAO + "]"+customer1dao;
	}
	
	public int print(){
		return customerDAO.print();
	}
	
	
}
