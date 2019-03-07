package com.capgemini.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.beans.Transaction;
import com.capgemini.exception.DuplicateIdentityException;
import com.capgemini.exception.InsufficientAmountException;
import com.capgemini.exception.MobileNumberNotExistException;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class WalletMainApp {

	private static WalletService walletService = new WalletServiceImpl();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws MobileNumberNotExistException, InsufficientAmountException,
	DuplicateIdentityException {
		display();
	}

	private static void display() throws MobileNumberNotExistException, InsufficientAmountException, DuplicateIdentityException {
		int choice;
		System.out.println("*************Payment Wallet Application************");
		while (true) {
			System.out.println("1.Create a new account");
			System.out.println("2.Show Balance");
			System.out.println("3.Fund Transfer");
			System.out.println("4.Deposit Amount");
			System.out.println("5.Withdraw Amount");
			System.out.println("6.Print Transactions.");
			System.out.println("7.Exit.");

			System.out.print("Enter your choice : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				showBalance();
				break;
			case 3:
				fundTransfer();
				break;
			case 4:
				depositAmount();
				break;
			case 5:
				withdrawAmount();
				break;
			case 6:
				printTransaction();
				break;
			case 7: System.exit(0);
			break;
			default:
				System.out.println("Invalid choice.");

			}
		}

	}

	private static void createAccount()
			throws DuplicateIdentityException, MobileNumberNotExistException {
		String mobileNumber="12";
		String Name="12";
		String amount;

		while(mobileNumber.length()!=10) {
			System.out.println("Enter a 10 Digit number:");
			mobileNumber = sc.next();
		}

		while(Pattern.compile("[0-9]").matcher(Name).find()) 
		{
			System.out.println("Enter a Name without Any Digit");
			Name = sc.next();
		}

		System.out.print("Enter amount : ");
		amount = sc.next();

		BigDecimal amount1 = new BigDecimal(amount);
		walletService.createAccount(Name, mobileNumber, amount1);
		System.out.println("Account is Successfully Created\n");
	}

	private static void showBalance() throws MobileNumberNotExistException {
		String mobileNumber;
		System.out.print("Enter your valid mobile number : ");
		mobileNumber = sc.next();
		System.out
				.println("Your Account Balance is " + walletService.showBalance(mobileNumber).getWallet().getBalance());
	}

	private static void fundTransfer() throws MobileNumberNotExistException, InsufficientAmountException, DuplicateIdentityException {
		String senderMobileNumber;
		String receiverMobileNumber;
		String amount;
		System.out.print("Enter your valid mobile number : ");
		senderMobileNumber = sc.next();

		System.out.print("Enter other one valid mobile number : ");
		receiverMobileNumber = sc.next();

		System.out.print("Enter amount : ");
		amount = sc.next();

		BigDecimal amount1 = new BigDecimal(amount);
		walletService.fundTransfer(senderMobileNumber, receiverMobileNumber, amount1);
		System.out.println("Fund is Transfered From:" + senderMobileNumber + "    To:" + receiverMobileNumber
				+ "    Amount:" + amount);
	}

	private static void depositAmount() throws MobileNumberNotExistException {
		String mobileNumber;
		String amount;

		System.out.print("Enter your valid mobile number : ");
		mobileNumber = sc.next();

		System.out.print("Enter amount : ");
		amount = sc.next();

		BigDecimal amount1 = new BigDecimal(amount);
		walletService.depositAmount(mobileNumber, amount1);
		System.out.println("Amount- " + amount + " is Deposited to" + mobileNumber);
	}

	private static void withdrawAmount() throws MobileNumberNotExistException, InsufficientAmountException {
		String mobileNumber;
		String amountString;
		System.out.print("Enter your valid mobile number : ");
		mobileNumber = sc.next();
		System.out.print("Enter amount : ");
		amountString = sc.next();

		BigDecimal amount = new BigDecimal(amountString);
		walletService.withdrawAmount(mobileNumber, amount);
		System.out.println("Amount- " + amount + " is Withdrawn from" + mobileNumber);
	}

  private static void printTransaction() {
	// TODO Auto-generated method stub
	// Printing Transactions List
	System.out.println("Enter the Mobile number: ");
	String mobileNumber=sc.next();
			List<Transaction> l = walletService.showTransaction(mobileNumber);
			if (l.size() != 0) {
				ListIterator<Transaction> it = l.listIterator();
				while (it.hasNext()) {
					Transaction transaction = it.next();
					if (transaction.getWithdrawMobileNumber() == null) {
						System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Deposit"
								+ "  Deposit Mobile Number:" + transaction.getDepositMobileNumber() + "  Deposited Amount:"
								+ transaction.getAmount());
					} else if (transaction.getDepositMobileNumber() == null) {
						System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Withdraw"
								+ "  Withdraw Mobile Number:" + transaction.getWithdrawMobileNumber()
								+ "  Withdrawn Amount:" + transaction.getAmount());
					} else {
						if (transaction.getDepositMobileNumber() == transaction.getMobileNumber()) {
							System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Fund Tranfered"
									+ "  Sender Mobile Number:" + transaction.getDepositMobileNumber()
									+ "  Receiver Mobile Number:" + transaction.getWithdrawMobileNumber()
									+ " Transferred Amount:" + transaction.getAmount());
						} else {
							System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Fund Received"
									+ "  Sender Mobile Number:" + transaction.getDepositMobileNumber()
									+ "  Receiver Mobile Number:" + transaction.getWithdrawMobileNumber()
									+ " Received Amount:" + transaction.getAmount());
						}
					}
				}
			}
				else {
					System.out.println("No Transaction happened so far.");
			}
	
}
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*WalletService walletService = new WalletServiceImpl();

		walletService.createAccount("Ravi", "1", new BigDecimal("10000.0"));
		walletService.createAccount("piliwali", "2", new BigDecimal("50000"));
		
		 System.out.println(walletService.showBalance("1").getWallet().getBalance());
		 System.out.println(walletService.showBalance("2").getWallet().getBalance());
		
		 walletService.depositAmount("1",new BigDecimal("30000"));
		 walletService.depositAmount("2",new BigDecimal("40000"));
		//
		// System.out.println(walletService.showBalance("1").getWallet().getBalance());
		// System.out.println(walletService.showBalance("2").getWallet().getBalance());
		//
		// walletService.withdrawAmount("1",new BigDecimal("20000"));
		// walletService.withdrawAmount("2",new BigDecimal("20000"));
		//
		// System.out.println(walletService.showBalance("1").getWallet().getBalance());
		// System.out.println(walletService.showBalance("2").getWallet().getBalance());
		//
		// walletService.fundTransfer("1", "2",new BigDecimal("2000"));
		//
		// System.out.println(walletService.showBalance("1").getWallet().getBalance());
		// System.out.println(walletService.showBalance("2").getWallet().getBalance());

		// Printing Transactions List
		List<Transaction> l = walletService.showTransaction("2");
		if (l.size() != 0) {
			ListIterator<Transaction> it = l.listIterator();
			while (it.hasNext()) {
				Transaction transaction = it.next();
				if (transaction.getWithdrawMobileNumber() == null) {
					System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Deposit"
							+ "  Deposit Mobile Number:" + transaction.getDepositMobileNumber() + "  Deposited Amount:"
							+ transaction.getAmount());
				} else if (transaction.getDepositMobileNumber() == null) {
					System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Withdraw"
							+ "  Withdraw Mobile Number:" + transaction.getWithdrawMobileNumber()
							+ "  Withdrawn Amount:" + transaction.getAmount());
				} else {
					if (transaction.getDepositMobileNumber() == transaction.getMobileNumber()) {
						System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Fund Tranfered"
								+ "  Sender Mobile Number:" + transaction.getDepositMobileNumber()
								+ "  Receiver Mobile Number:" + transaction.getWithdrawMobileNumber()
								+ " Transferred Amount:" + transaction.getAmount());
					} else {
						System.out.println("Id: " + transaction.getId() + "  Transaction Type:" + "Fund Received"
								+ "  Sender Mobile Number:" + transaction.getDepositMobileNumber()
								+ "  Receiver Mobile Number:" + transaction.getWithdrawMobileNumber()
								+ " Received Amount:" + transaction.getAmount());
					}

				}
			}
		} else {
			System.out.println("No Transaction happened so far.");
		}

	}

}*/
