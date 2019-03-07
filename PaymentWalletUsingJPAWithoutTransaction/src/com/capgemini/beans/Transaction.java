package com.capgemini.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@Column(name="Transaction_Id",length=10)
	private int id;
	@Column(name="Mobile_Number",length=10)
	private String mobileNumber;
	@Column(name="Deposit_Mobile_Number",length=10)
	private String depositMobileNumber;
	@Column(name="Withdraw_Mobile_Number",length=10)
	private String withdrawMobileNumber;
	@Column(name="Amount",length=10)
	private BigDecimal amount;
	public Transaction(int id, String mobileNumber, String depositMobileNumber, String withdrawMobileNumber,
			BigDecimal amount) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.depositMobileNumber = depositMobileNumber;
		this.withdrawMobileNumber = withdrawMobileNumber;
		this.amount = amount;
	}
	public Transaction() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDepositMobileNumber() {
		return depositMobileNumber;
	}
	public void setDepositMobileNumber(String depositMobileNumber) {
		this.depositMobileNumber = depositMobileNumber;
	}
	public String getWithdrawMobileNumber() {
		return withdrawMobileNumber;
	}
	public void setWithdrawMobileNumber(String withdrawMobileNumber) {
		this.withdrawMobileNumber = withdrawMobileNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", mobileNumber=" + mobileNumber + ", depositMobileNumber="
				+ depositMobileNumber + ", withdrawMobileNumber=" + withdrawMobileNumber + ", amount=" + amount + "]";
	}
	
	
	
	

}
