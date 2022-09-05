package project;


public abstract class Account {
	private int id;
	private String accountType;
	private String firstName;
	private String lastName;
	private String pin;
	private double balance;
	
	public Account() {	}

	public Account(String accountType, int id, String firstName, String lastName, String address, double balance) {
		super();
		this.accountType = accountType;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = address;
		this.balance = balance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String address) {
		this.pin = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public abstract Account showAccountDetails();

	@Override
	public String toString() {
		return "Account = " + id + "\nFirst Name = " + firstName + "\nLast Name = " + lastName + "\nBalance = " + balance;
	}

}
