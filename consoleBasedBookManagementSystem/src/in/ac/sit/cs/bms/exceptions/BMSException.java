package in.ac.sit.cs.bms.exceptions;

public class BMSException extends Exception{
	
	private String details;

	public BMSException(String details) {
		super();
		this.details = details;
	}

	public String getDetails() {
		return details;
	}
}
