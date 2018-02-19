package exceptions;

public class ApostaFechadaException extends Exception {

	
	
	private static final long serialVersionUID = -181446372742692686L;

	
	
	public ApostaFechadaException() {
		super();
	}

	
	
	public ApostaFechadaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	
	
	public ApostaFechadaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApostaFechadaException(String message) {
		super(message);
	}

	
	
	public ApostaFechadaException(Throwable cause) {
		super(cause);
	}

}
