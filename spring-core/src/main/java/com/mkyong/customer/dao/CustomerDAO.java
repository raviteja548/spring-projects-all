package com.mkyong.customer.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO 
{
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";
	}	
	
	
	public int print(){
		return this.hashCode();
	}
	
}
