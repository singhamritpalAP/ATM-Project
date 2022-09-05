package project;

public class InvalidAmountException extends Exception{
	String message;

	public InvalidAmountException() {
		super();
		this.message = "Amount must be a multiple of 100";
	}

	@Override
	public String toString() {
		return message;
	}
	
	
}
