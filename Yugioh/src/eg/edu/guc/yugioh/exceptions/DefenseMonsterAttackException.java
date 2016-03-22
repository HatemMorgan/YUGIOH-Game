package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException {
  static String s="You cannot Attack by a Monster in Defence Mode";
	public DefenseMonsterAttackException() {
		super(s);
	}

	public DefenseMonsterAttackException(String message) {
		super(message);
	}
	
}
