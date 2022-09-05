package project;
public class InsufficientBalanceException extends Exception { 
	String message;
	public InsufficientBalanceException() {
		this.message = "Insufficient Balance";
	}
	public InsufficientBalanceException(String message) { 
		super(message); 
		
	}
	@Override
	public String toString() {
		return message;
	}

} 