package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

class ATM {

	public  String deposit(int id, double amount,  List<Account> accountList) {


		for(Account account : accountList) {
			if(account.getId() == id) {
				System.out.println("Name: " + account.getFirstName() + " " + account.getLastName());
				System.out.println("Deposit Amount: " + amount);
				account.setBalance(account.getBalance() + amount);
				System.out.println("Available Balance: " + account.getBalance());

				return "Transaction Successful";

			}

		}
		return "Invalid Account";

	}

	public String withdraw(int id, double amount, List<Account> accountList){
		for(Account account : accountList) {
			if(account.getId() == id) {
				if(account.getAccountType().equals("S")){
					if(amount <= 10000){
						if(account.getBalance() > amount) {
							System.out.println("Name: " + account.getFirstName() + " " + account.getLastName());
							System.out.println("Withdraw Amount : " + amount);
							account.setBalance(account.getBalance() - amount);
							System.out.println("Available Balance: " + account.getBalance());
							return "Transaction Successful";
						}
						else {
							try {
								throw new InsufficientBalanceException();
							} catch (InsufficientBalanceException e) {
								e.printStackTrace();
							}
						}
					}
					else {
						return "Savings Account withdraw amount limited to 10000 only";
					}
				}
			}
			else {
				if(amount <= 15000){
					if(account.getBalance() > amount) {
						System.out.println("Name: " + account.getFirstName() + " " + account.getLastName());
						System.out.println("Withdraw Amount : " + amount);
						account.setBalance(account.getBalance() - amount);
						System.out.println("Available Balance: " + account.getBalance());
						return "Transaction Successful";
					}
					else {
						try {
							throw new InsufficientBalanceException();
						} catch (InsufficientBalanceException e) {
							e.printStackTrace();
						}
					}
				}
				else {
					return "Current Account withdraw amount limited to 15000 only";
				}
			}
		}

		return "Invalid Account";
	}


	public String checkBalance(int id, List<Account> accountList) { 
		String message = ""; 
		for(Account account : accountList) {
			if(account.getId() == id) { 
				message = "Account No: " + account.getId() + "\nName: " + account.getFirstName() 
				+ " " + account.getLastName() + "\nBalance: " + account.getBalance();
			} 
		} 
		return message; 
	}

	public Boolean checkPin(int id, String pin, List<Account> accountList){

		for(Account account: accountList) { 
			if(account.getId() == id) {
				if(account.getPin().equals(pin)){
					return true;
				}
				return false;
			}
		}
		return false;
	}


	public String changePin(int id, String currentPin, String newPin, List<Account> accountList) { 
		for(Account account: accountList) { 
			if(account.getId() == id) { 
				if(account.getPin().equals(currentPin)){
					account.setPin(newPin); 
					return "pin changed successfully"; 
				}
				return "Current Pin is not correct";
			} 
		} 
		return "account does not exist"; 
	} 
	public void writeData(int id, List<Account> accountList){

		File oldFile = new File("//home//npci-admin//Downloads//account.txt");
		File newFile = new File("//home//npci-admin//Downloads//temp.txt");
		String accountType = ""; String fName = ""; String lName = ""; String pin = ""; String phone = ""; 
		int tempId = 0;
		double balance = 0.0;
		try{

			FileWriter fw = new FileWriter("//home//npci-admin//Downloads//temp.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner x = new Scanner(new File("//home//npci-admin//Downloads//account.txt"));
			x.useDelimiter("[;\n]");

			while(x.hasNext()){
				accountType = x.next();
				tempId = x.nextInt();
				fName = x.next();
				lName = x.next();
				pin = x.next();
				balance = x.nextDouble();
				phone = x.next();
				if(tempId == id){
					for(Account account : accountList){
						if(account.getId() == id) { 
							pw.println(accountType+ ";" + tempId + ";" + fName
									+ ";" + lName + ";" + account.getPin() + ";" + account.getBalance() +";" + phone);
						}
					}
				}
				else 
					pw.println(accountType + ";" + tempId + ";" + fName + ";" + lName + ";" + pin + ";" + balance +";" + phone);
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File("//home//npci-admin//Downloads//account.txt");
			newFile.renameTo(dump);

		} catch(Exception e) {
			System.out.println(e);
		}

	}


}
