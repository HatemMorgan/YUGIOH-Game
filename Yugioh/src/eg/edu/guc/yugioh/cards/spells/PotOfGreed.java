package eg.edu.guc.yugioh.cards.spells;

import java.io.IOException;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class PotOfGreed extends SpellCard {

	public PotOfGreed(String name, String description) {
		super(name, description);
	
	}
public void action(MonsterCard monster){

	int i=0;
	while(i<2){
		if(!Card.getBoard().getActivePlayer().getField().getDeck().getDeck().isEmpty()){
		Card.getBoard().getActivePlayer().getField().addCardToHand();
		i++;
	}else{
		Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		break;
	}
}
	
}
public static void main(String[] args) throws IOException, UnexpectedFormatException {
	Board b= new Board();
	Player p1= new Player("Hatem");
	Player p2= new Player("tag");
	b.startGame(p1, p2);
	PotOfGreed pg= new PotOfGreed("Pot of Greed", "Draw 2 extra cards.");
	b.getActivePlayer().getField().getHand().add(pg);
	System.out.println(b.getActivePlayer().getField().getHand());
	b.getActivePlayer().activateSpell(pg, null);
	System.out.println(b.getActivePlayer().getField().getHand());
}
}

