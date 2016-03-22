package eg.edu.guc.yugioh.gui;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;


public class CardsImages extends JLabel {
	JLabel deck;


	public  CardsImages(String s){
		super();
		//PlayerDeck=d;
		
		    deck=new JLabel();
			deck.setSize(100,120);
			switch(s){
			
			case "Red-Eyes Black Dragon" :deck.setName("Red-Eyes Black Dragon"); deck.setIcon(new ImageIcon("Red-Eyes Black Dragon2.png")); break;
			case "Blue-Eyes White Dragon" :deck.setName("Blue-Eyes White Dragon"); deck.setIcon(new ImageIcon("Blue-Eyes White Dragon2.png")); break;
			case "Cosmo Queen" :deck.setName("Cosmo Queen"); deck.setIcon(new ImageIcon("CosmoQueen2.png")); break;
			case "Dark Magician" :deck.setName("Dark Magician"); deck.setIcon(new ImageIcon("Dark Magician2.png"));break;
			case "Gaia The Fierce Knight" :deck.setName("Gaia The Fierce Knight"); deck.setIcon(new ImageIcon("Gaia The Fierce Knight2.png"));break;
			case "Summoned Skull" : deck.setName("Summoned Skull");deck.setIcon(new ImageIcon("Summoned Skull2.png"));break;
			case "Dark Magician Girl" : deck.setName("Dark Magician Girl");deck.setIcon(new ImageIcon("Dark Magician Girl2.png"));break;
			case "Curse Of Dragon" :deck.setName("Curse Of Dragon"); deck.setIcon(new ImageIcon("Curse Of Dragon2.png"));break;
			case "Alexandrite Dragon" :deck.setName("Alexandrite Dragon"); deck.setIcon(new ImageIcon("Alexandrite Dragon2.png"));break;
			case "Vorse Raider" : deck.setName("Vorse Raider"); deck.setIcon(new ImageIcon("Vorse Raider2.png"));break;
			case "Gemini Elf" : deck.setName("Gemini Elf");deck.setIcon(new ImageIcon("Gemini Elf2.png"));break;
			case "Fence Guard Apprentice" : deck.setName("Fence Guard Apprentice" );deck.setIcon(new ImageIcon("Fence Guard Apprentice2.png"));break;
			case "Beta The Magnet Warrior" :deck.setName("Beta The Magnet Warrior"); deck.setIcon(new ImageIcon("Beta The Magnet Warrior2.png"));break;
			case "Alligator Sword" :deck.setName("Alligator Sword"); deck.setIcon(new ImageIcon("Alligator Sword2.png"));break;
			case "Gamma The Magnet Warrior" :deck.setName("Gamma The Magnet Warrior"); deck.setIcon(new ImageIcon("Gamma The Magnet Warrior2.png"));break;
			case "Celtic Guardian" : deck.setName("Celtic Guardian");deck.setIcon(new ImageIcon("Celtic Guardian2.png"));break;
			case "Alpha The Magnet Warrior" :deck.setName("Alpha The Magnet Warrior"); deck.setIcon(new ImageIcon("Alpha The Magnet Warrior2.png"));break;
			case "Harpie Lady" : deck.setName("Harpie Lady");deck.setIcon(new ImageIcon("Harpie Lady2.png"));break;
			case "Big Shield Gardna" :deck.setName("Big Shield Gardna"); deck.setIcon(new ImageIcon("Big Shield Gardna2.png"));break;
			case "Witty Phantom" :deck.setName( "Witty Phantom"); deck.setIcon(new ImageIcon("Witty Phantom2.png"));break;
			case "Baby Dragon" :deck.setName("Baby Dragon"); deck.setIcon(new ImageIcon("Baby Dragon2.png"));break;
			case "Cyber Jar" :deck.setName("Cyber Jar"); deck.setIcon(new ImageIcon("Cyber Jar2.png"));break;
			case "Clown Zombie" :deck.setName("Clown Zombie" ); deck.setIcon(new ImageIcon("Clown Zombie2.png"));break;
			case "Time Wizard" :deck.setName("Time Wizard"); deck.setIcon(new ImageIcon("Time Wizard2.png"));break;
			case "Man-Eater Bug" :deck.setName("Man-Eater Bug"); deck.setIcon(new ImageIcon("Man-Eater Bug2.png"));break;
			case "Kuriboh" :deck.setName("Kuriboh"); deck.setIcon(new ImageIcon("Kuriboh2.png"));break;
			case "Mokey Mokey" :deck.setName("Mokey Mokey"); deck.setIcon(new ImageIcon("Mokey Mokey2.png"));break;
			case "Fence Guard Dragon":deck.setName("Fence Guard Dragon"); deck.setIcon(new ImageIcon("Fence Guard Dragon2.jpg"));break;
			case "Fence Guard Magician":deck.setName("Fence Guard Magician"); deck.setIcon(new ImageIcon("Fence Guard Magician2.jpg"));break;
			case "Fence Guard":deck.setName("Fence Guard"); deck.setIcon(new ImageIcon("Fence Guard2.jpg"));break;
			
				case "Card Destruction": deck.setName("Card Destruction");deck.setIcon(new ImageIcon("Card Destruction2.png"));break;
				case "Change Of Heart":deck.setName("Change Of Heart"); deck.setIcon(new ImageIcon("Change Of Heart2.png"));break;
				case "Dark Hole":deck.setName("Dark Hole"); deck.setIcon(new ImageIcon("Dark Hole2.jpg"));break;
				case "Graceful Dice": deck.setName("Graceful Dice");deck.setIcon(new ImageIcon("Graceful Dice2.png"));break;
				case "Harpie's Feather Duster": deck.setName("Harpie's Feather Duster");deck.setIcon(new ImageIcon("Harpie's Feather Duster2.png"));break;
				case "Heavy Storm":deck.setName("Heavy Storm"); deck.setIcon(new ImageIcon("Heavy Storm2.png"));break;
				case "Mage Power":deck.setName("Mage Power"); deck.setIcon(new ImageIcon("Mage Power2.png"));break;
				case "Monster Reborn": deck.setName("Monster Reborn");deck.setIcon(new ImageIcon("Monster Reborn2.jpg"));break;
				case "Pot of Greed": deck.setName("Pot of Greed");deck.setIcon(new ImageIcon("Pot of Greed2.png"));break;
				case "Raigeki": deck.setName("Raigeki");deck.setIcon(new ImageIcon("Raigeki2.png"));break;
				case "Hatem": deck.setIcon(new ImageIcon("Face_Down_Defense_Position.png"));break;
				case "Defence": deck.setIcon(new ImageIcon("downCard.jpg"));break;
			}
			
		
	}

	public JLabel getDeck() {
		return deck;
	}

	

}

