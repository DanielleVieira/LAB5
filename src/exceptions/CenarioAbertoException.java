package exceptions;

public class CenarioAbertoException extends Exception {

	
	
	private static final long serialVersionUID = 642840389307655029L;



	public CenarioAbertoException(String message) {
		super(message);
	}

	
	
	public CenarioAbertoException(Throwable cause) {
		super(cause);
	}

	
	
	public CenarioAbertoException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
	public CenarioAbertoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
