package Exceptions;

public class EmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyException(String message) {
		super(message);
	}
	
	public EmptyException() {
		super("Please Enteer Value");
	}
	
}
