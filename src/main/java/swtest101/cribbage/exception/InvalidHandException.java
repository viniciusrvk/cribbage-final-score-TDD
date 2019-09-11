package swtest101.cribbage.exception;

public class InvalidHandException extends InputParseException {

	private static final long serialVersionUID = -3531387261589027287L;

	public InvalidHandException(String errorMsg) {
		super(errorMsg);
	}

}
