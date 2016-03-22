package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard {
	public CardDestruction(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster) {
		int n1 = Card.getBoard().getActivePlayer().getField().getHand().size();
		while (Card.getBoard().getActivePlayer().getField().getHand().size() != 0) {

			Card.getBoard()
					.getActivePlayer()
					.getField()
					.getGraveyard()
					.add(Card.getBoard().getActivePlayer().getField().getHand()
							.remove(0));
		}
		for (int j = 0; j < n1; j++) {
			if (!Card.getBoard().getActivePlayer().getField().getDeck()
					.getDeck().isEmpty()) {
				Card.getBoard().getActivePlayer().getField().addCardToHand();
			} else {
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
				break;
			}
		}

		// Card.getBoard().getActivePlayer().getField().addNCardsToHand(n1);

		int n2 = Card.getBoard().getOpponentPlayer().getField().getHand()
				.size();
		while (Card.getBoard().getOpponentPlayer().getField().getHand().size() != 0) {
			Card.getBoard()
					.getOpponentPlayer()
					.getField()
					.getGraveyard()
					.add(Card.getBoard().getOpponentPlayer().getField()
							.getHand().remove(0));
		}
		for (int i = 0; i < n2; i++) {
			if (!(Card.getBoard().getOpponentPlayer().getField().getDeck()
					.getDeck().isEmpty())) {
				Card.getBoard().getOpponentPlayer().getField().addCardToHand();
			} else {
				Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
				break;
			}
		}
	}

	
}
