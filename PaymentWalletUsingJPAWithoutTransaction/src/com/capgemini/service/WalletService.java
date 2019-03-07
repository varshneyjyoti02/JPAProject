package com.capgemini.service;

import java.math.BigDecimal;
import java.util.List;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Transaction;
import com.capgemini.exception.DuplicateIdentityException;
import com.capgemini.exception.InsufficientAmountException;
import com.capgemini.exception.MobileNumberNotExistException;

public interface WalletService {
	public Customer createAccount(String name,String mobileNumber,BigDecimal amount) throws DuplicateIdentityException, MobileNumberNotExistException;
	public Customer showBalance(String mobileNumber) throws MobileNumberNotExistException;
	public Customer fundTransfer(String sourceMobileNumber,String targetMobileNumber,BigDecimal amount) throws MobileNumberNotExistException, InsufficientAmountException, DuplicateIdentityException ;
	public Customer depositAmount(String mobileNumber,BigDecimal amount) throws MobileNumberNotExistException;
	public Customer withdrawAmount(String mobileNumber,BigDecimal amount) throws MobileNumberNotExistException, InsufficientAmountException;
	public List<Transaction> showTransaction(String mobileNumber);
	
	
	
}
