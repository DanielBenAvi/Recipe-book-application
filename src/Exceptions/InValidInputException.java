package Exceptions;

public class InValidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InValidInputException(String message) {
		super(message);
	}
	
	public InValidInputException() {
		super("Please Enter Valid Value");
	}
}
