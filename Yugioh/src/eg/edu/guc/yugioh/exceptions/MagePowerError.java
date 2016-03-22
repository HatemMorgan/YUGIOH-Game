package eg.edu.guc.yugioh.exceptions;


public class MagePowerError extends RuntimeException {
	static String s="There is no SpellCards in the Field";
	public MagePowerError(){
		super(s);
	}
}
