package com.capgemini.repository;

import java.util.List;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Transaction;
import com.capgemini.exception.MobileNumberNotExistException;

public interface WalletRepo {
	
	public boolean save(Customer customer);
	public Customer findOne(String mobilenumber) throws MobileNumberNotExistException;
	public boolean saveTransaction(Transaction transaction);
	public List<Transaction> findAll(String mobileNumber);
	public boolean update(Customer customer);

}
