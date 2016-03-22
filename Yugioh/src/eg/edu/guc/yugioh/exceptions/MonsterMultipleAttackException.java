package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException {
static String s="You cannot Attack by the same Monster per Turn";
	public MonsterMultipleAttackException() {
	super(s);
	}

	public MonsterMultipleAttackException(String message) {
		super(message);
	}

}
