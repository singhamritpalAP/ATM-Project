package project;


public class SavingAccount extends Account{
	private String personalPhoneNumber;

	public SavingAccount() {
		super();
	}
	public SavingAccount(String accountType, int id, String firstName, String lastName, String pin, double balance, String personalPhoneNumber) {
		super(accountType, id, firstName, lastName, pin, balance);
		this.personalPhoneNumber = personalPhoneNumber;
	}

	public String getPersonalPhoneNumber() {
		return personalPhoneNumber;
	}
	public void setPersonalPhoneNumber(String personalPhoneNumber) {
		this.personalPhoneNumber = personalPhoneNumber;
	}


	@Override
	public Account showAccountDetails() {
		SavingAccount account = new SavingAccount();
		account.setFirstName(getFirstName());
		account.setLastName(getLastName());
		account.setPin(getPin());
		account.setBalance(getBalance());
		account.setPersonalPhoneNumber(getPersonalPhoneNumber());

		return account;
	}
	@Override
	public String toString() {
		return super.toString() +"\nPersonal PhoneNumber = " + personalPhoneNumber;
	}

}
