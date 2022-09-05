package project;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		ATM atm = new ATM();


		ReadData readData = new ReadData();

		List<Account> accountList = new ArrayList<>();
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("//home//npci-admin//Downloads//account.txt", "r");
			accountList = readData.readAccount(raf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("**Welcome to ATM**"); 
		try { 
			Thread.sleep(1000); 
		} catch(Exception e) {} 
		System.out.println("login to perform operations"); 
		System.out.println("Please Enter the Id and Pin"); 
		System.out.println("Enter id : "); 
		int id = scanner.nextInt(); 
		int count = 0; 
		
		while(count < 3) { 
			count++;
			
			System.out.println("Enter pin:"); 
			String pin = scanner.next(); 
			
			if(atm.checkPin(id, pin, accountList)){ 
				while(true){ 
					System.out.println();
					System.out.println("1. Withdraw");
					System.out.println("2. Deposit");
					System.out.println("3. Change Pin");
					System.out.println("4. Check Balance");
					System.out.println("5. Exit");
					System.out.println();
					System.out.print("Enter your choice ");


					int option = scanner.nextInt();
					scanner.nextLine();
					System.out.println();



					switch(option){
					case 1:
						System.out.println("Withdraw Amount"); 
						Double amountWithdraw = scanner.nextDouble();
						if(amountWithdraw % 100 == 0){
							String withdrawMessage = atm.withdraw(id, amountWithdraw, accountList);
							System.out.println(withdrawMessage);
						}
						else{
							try {
								throw new InvalidAmountException();
							} catch (InvalidAmountException e) {
								e.printStackTrace();
							}
						}
						break;

					case 2:
						System.out.println("Deposit Amount"); 
						Double amountDeposit = scanner.nextDouble();
						if(amountDeposit % 100 == 0){
							String depositMessage = atm.deposit(id, amountDeposit,accountList); 
							System.out.println(depositMessage);
						}
						else{
							try {
								throw new InvalidAmountException();
							} catch (InvalidAmountException e) {
								e.printStackTrace();
							}
						}
						break;

					case 3: 
						System.out.println("Enter Current & New Pin"); 
						String currentPin = scanner.next();
						String newPin = scanner.next();
						if(newPin.length() == 4){
							String changePinMessage = atm.changePin(id, currentPin, newPin, accountList);
							System.out.println(changePinMessage);
						}
						else
							System.out.println("Pin should be of 4 digits.");
						break; 

					case 4:
						String checkBalanceMessage = atm.checkBalance(id, accountList);
						System.out.println(checkBalanceMessage);
						break; 


					case 5: 
						atm.writeData(id, accountList);
						System.exit(0);
						break;

					default: 
						System.out.println("Invalid Option!!!");
						break;
					}
				}
			}
			else System.out.println("Invalid login credentials" + "\n" + (3-count) + " attempts left"); 
		}
		if(count == 3) 
			System.out.println("Your account is locked for 24 hours");
	} 

}


