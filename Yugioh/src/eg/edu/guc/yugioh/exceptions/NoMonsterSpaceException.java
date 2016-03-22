package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException {
static String s="You Cannot summon this Monster becaue there is no Space";
	public NoMonsterSpaceException() {
		super(s);
	}

	public NoMonsterSpaceException(String arg0) {
		super(arg0);
	}

}
