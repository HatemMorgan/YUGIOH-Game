package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {
static String s= "You cannot add this Spell because there is No Space";
	public NoSpellSpaceException() {
		super(s);
	}

	public NoSpellSpaceException(String arg0) {
		super(arg0);
	}

}
