package exceptions;

public class CenarioEncerradoException extends Exception {

	
	
	private static final long serialVersionUID = 9057029143423051322L;



	public CenarioEncerradoException(String message) {
		super(message);
	}

	
	
	public CenarioEncerradoException(Throwable cause) {
		super(cause);
	}

	
	
	public CenarioEncerradoException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
	public CenarioEncerradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
