package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class WrongPhaseException extends RuntimeException {
static String s ="Wrong Phase ";
	public WrongPhaseException() {
		super(s);
	}

	public WrongPhaseException(String message) {
		super(message);
	}

}
