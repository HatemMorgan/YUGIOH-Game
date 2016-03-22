package eg.edu.guc.yugioh.exceptions;

public class WrongAddedCardToField extends RuntimeException {
 static String s="You cannot add a Spell Card into Monster Area";
public WrongAddedCardToField(){
	super(s);
}
public WrongAddedCardToField(String s){
	super(s);
}
}
