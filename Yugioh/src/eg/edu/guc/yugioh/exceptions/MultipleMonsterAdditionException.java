package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MultipleMonsterAdditionException extends RuntimeException {
static String s="You Cannot summon more than one Monster per Turn";
	public MultipleMonsterAdditionException() {
		super(s);
	}

	public MultipleMonsterAdditionException(String message) {
		super(message);
	}

}
