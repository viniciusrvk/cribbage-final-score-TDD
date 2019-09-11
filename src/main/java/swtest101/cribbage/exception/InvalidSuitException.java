package swtest101.cribbage.exception;

public class InvalidSuitException extends InputParseException {

	private static final long serialVersionUID = 2958526588785165853L;

	public InvalidSuitException(String errorMsg) {
		super(errorMsg);
	}

}
