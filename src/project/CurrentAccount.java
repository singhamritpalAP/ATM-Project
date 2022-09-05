package project;

public class CurrentAccount extends Account{
	private String businessPhone;
	
	public CurrentAccount() {
		super();
	}
	public CurrentAccount(String accountType, int id, String firstName, String lastName, String pin, double balance, String businessPhone) {
		super(accountType, id, firstName, lastName, pin, balance);
		this.businessPhone = businessPhone;
	}

	
	public String getBusinessPhoneNumber() {
		return businessPhone;
	}
	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhone = businessPhoneNumber;
	}
	
	@Override
	public Account showAccountDetails() {
		CurrentAccount account = new CurrentAccount();
		account.setFirstName(getFirstName());
		account.setLastName(getLastName());
		account.setPin(getPin());
		account.setBalance(getBalance());
		account.setBusinessPhoneNumber(getBusinessPhoneNumber());

		return account;	
		}
	
	@Override
	public String toString() {
		return super.toString() + "\nBusiness Phone = " + businessPhone;
	}
}
