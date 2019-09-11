package swtest101.cribbage.exception;

public class InvalidCardException extends InputParseException {

	private static final long serialVersionUID = 6172871302984532796L;

	public InvalidCardException(String errorMsg) {
		super(errorMsg);
	}

}
