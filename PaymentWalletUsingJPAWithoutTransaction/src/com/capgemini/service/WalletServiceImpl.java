package com.capgemini.service;

import java.math.BigDecimal;
import java.util.List;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Transaction;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateIdentityException;
import com.capgemini.exception.InsufficientAmountException;
import com.capgemini.exception.MobileNumberNotExistException;
import com.capgemini.repository.WalletRepo;
import com.capgemini.repository.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {

	WalletRepo walletRepo = new WalletRepoImpl();
	static int id = 0;

	public WalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer createAccount(String name, String mobileNumber, BigDecimal amount)
			throws DuplicateIdentityException, MobileNumberNotExistException {
		// TODO Auto-generated method stub
		Wallet wallet = new Wallet(amount);
		Customer customer = new Customer(name, mobileNumber, wallet);
		if (walletRepo.findOne(mobileNumber) != null) {
			throw new DuplicateIdentityException();
		}
		walletRepo.save(customer);

		return customer;
	}

	@Override
	public Customer showBalance(String mobileNumber) throws MobileNumberNotExistException {
		// TODO Auto-generated method stub
		if (walletRepo.findOne(mobileNumber) == null) {
			throw new MobileNumberNotExistException();
		}

		return walletRepo.findOne(mobileNumber);
	}

	@Override
	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber, BigDecimal amount)
			throws MobileNumberNotExistException, InsufficientAmountException, DuplicateIdentityException {

		// Withdrawing the Amount
		if (walletRepo.findOne(sourceMobileNumber)== walletRepo.findOne(targetMobileNumber)) {
			throw new DuplicateIdentityException();
		}

		Customer customer = walletRepo.findOne(sourceMobileNumber);
		Wallet wallet = customer.getWallet();

		int a = amount.compareTo(wallet.getBalance());
		if (a == 1) {
			throw new InsufficientAmountException();
		}
		wallet.setBalance(wallet.getBalance().subtract(amount));
		walletRepo.update(customer);
		Transaction transaction = new Transaction(id, sourceMobileNumber, sourceMobileNumber, targetMobileNumber,
				amount);
		walletRepo.saveTransaction(transaction);
		
		// Depositing the Amount

		customer = walletRepo.findOne(targetMobileNumber);
		wallet = customer.getWallet();
		wallet.setBalance(wallet.getBalance().add(amount));
		customer.setWallet(wallet);
		walletRepo.update(customer);
		transaction = new Transaction(id++, targetMobileNumber, sourceMobileNumber, targetMobileNumber, amount);
		walletRepo.saveTransaction(transaction);

		return walletRepo.findOne(sourceMobileNumber);
	}

	@Override
	public Customer depositAmount(String mobileNumber, BigDecimal amount) throws MobileNumberNotExistException {
		// TODO Auto-generated method stub
		Customer customer = walletRepo.findOne(mobileNumber);
		Wallet wallet = customer.getWallet();
		wallet.setBalance(wallet.getBalance().add(amount));
		customer.setWallet(wallet);
		walletRepo.update(customer);
		Transaction transaction = new Transaction(id++, mobileNumber, mobileNumber, null, amount);
		walletRepo.saveTransaction(transaction);

		return customer;
	}

	@Override
	public Customer withdrawAmount(String mobileNumber, BigDecimal amount)
			throws MobileNumberNotExistException, InsufficientAmountException {
		// TODO Auto-generated method stub
		Customer customer = walletRepo.findOne(mobileNumber);
		Wallet wallet = customer.getWallet();

		int a = amount.compareTo(wallet.getBalance());
		if (a == 1) {
			throw new InsufficientAmountException();
		}
		wallet.setBalance(wallet.getBalance().subtract(amount));
		walletRepo.update(customer);
		Transaction transaction = new Transaction(id++, mobileNumber, null, mobileNumber, amount);
		walletRepo.saveTransaction(transaction);
		return customer;
	}

	@Override
	public List<Transaction> showTransaction(String mobileNumber) {
		// TODO Auto-generated method stub
		return walletRepo.findAll(mobileNumber);
	}

}
