package com.capgemini.repository;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Transaction;
import com.capgemini.exception.MobileNumberNotExistException;
import com.capgemini.util.EntityManagerLoader;

public class WalletRepoImpl implements WalletRepo {

	LinkedList<Customer> l = new LinkedList<>();
	LinkedList<Transaction> tl= new LinkedList<>();
	static EntityManager entityManager= EntityManagerLoader.loader();
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		 l.add(customer);
		 EntityTransaction transaction=entityManager.getTransaction();
		 transaction.begin();
		 entityManager.persist(customer);
		 transaction.commit();
		 return true;
	}

	@Override
	public Customer findOne(String mobilenumber) throws MobileNumberNotExistException {
		// TODO Auto-generated method stub
		Customer customer=entityManager.find(Customer.class, mobilenumber);
		return customer;
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=entityManager.getTransaction();
		 transaction.begin();
		 Customer customer1=entityManager.find(Customer.class, customer.getMobileNumber());
		 customer1.setWallet(customer.getWallet());
		 transaction.commit();
		return true;
	}

	@Override
	public boolean saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		EntityTransaction transaction1=entityManager.getTransaction();
		 transaction1.begin();
		 entityManager.persist(transaction);
		 transaction1.commit();
		 
		return tl.add(transaction); 
	}

	@Override
	public List<Transaction> findAll(String mobileNumber) {
		// TODO Auto-generated method stub
		LinkedList <Transaction> l1= new LinkedList<>();
		for(Transaction entry:tl)
		{
			if(entry.getMobileNumber().equals(mobileNumber))
			{
				l1.add(entry);
			}
		}
		return l1;
		
		
	}
	
	

}
