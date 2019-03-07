package com.capgemini.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Wallet {
	@Column(name="Account_Balance",length=10)
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [balance=" + balance + "]";
	}

	public Wallet() {
		super();
	}
	
	
	

}
