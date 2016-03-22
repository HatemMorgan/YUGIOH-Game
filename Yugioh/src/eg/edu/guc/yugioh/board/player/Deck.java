package eg.edu.guc.yugioh.board.player;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {

	private static ArrayList<Card> monsters;
	private static ArrayList<Card> spells;

	private static String monstersPath = "Database-Monsters.csv";
	private static String spellsPath = "Database-Spells.csv";

	private final ArrayList<Card> deck;
	int trials = 0;

	public Deck() throws IOException, NumberFormatException,
			UnexpectedFormatException {

		if ((monsters == null) || (spells == null)) {

			Scanner sc = new Scanner(System.in);

			while (true) {

				try {

					monsters = loadCardsFromFile(Deck.getMonstersPath());
					spells = loadCardsFromFile(Deck.getSpellsPath());
					break;

				} catch (UnexpectedFormatException e) {

					if (trials >= 3) {
						sc.close();
						throw e;
					}

					System.out.println("Error in reading from file "
							+ e.getSourceFile() + " at line "
							+ e.getSourceLine());
					System.out.println(e.getMessage());
					System.out.println("Please enter another path:");

					trials++;

					if (e.getSourceFile().equalsIgnoreCase(
							Deck.getMonstersPath())) {
						Deck.setMonstersPath(sc.nextLine());
					}
					if (e.getSourceFile()
							.equalsIgnoreCase(Deck.getSpellsPath())) {
						Deck.setSpellsPath(sc.nextLine());
					}

				} catch (FileNotFoundException e) {

					if (trials >= 3) {
						sc.close();
						throw e;
					}

					String s = (monsters == null) ? Deck.getMonstersPath()
							: Deck.getSpellsPath();

					System.out.println("The file \"" + s + "\" is not found.");
					System.out.println("Please enter another path:");

					trials++;
					String path = sc.nextLine();

					if (monsters == null)
						Deck.setMonstersPath(path);
					else
						Deck.setSpellsPath(path);

				}

			}

			sc.close();

		}

		deck = new ArrayList<Card>();
		buildDeck(monsters, spells);
		shuffleDeck();

	}

	public ArrayList<Card> loadCardsFromFile(String path) throws IOException,
			UnexpectedFormatException {

		ArrayList<Card> temp = new ArrayList<Card>();

		String line;

		BufferedReader br = new BufferedReader(new FileReader(path));

		int lineNumber = 0;

		while ((line = br.readLine()) != null) {

			lineNumber++;

			String[] cardInfo = line.split(",");

			if (cardInfo.length == 0) {

				br.close();
				throw new MissingFieldException(
						"The number of fields in the line did not match the expected.",
						path, lineNumber);

			} else {

				if (cardInfo[0].equalsIgnoreCase("Monster")
						&& cardInfo.length != 6) {

					br.close();
					throw new MissingFieldException(
							"The number of fields in the line did not match the expected.",
							path, lineNumber);

				} else if (cardInfo[0].equalsIgnoreCase("Spell")
						&& cardInfo.length != 3) {

					br.close();
					throw new MissingFieldException(
							"The number of fields in the line did not match the expected.",
							path, lineNumber);

				}

			}

			for (int i = 0; i < cardInfo.length; i++)
				if (cardInfo[i].equals("") || cardInfo[i].equals(" ")) {

					br.close();
					throw new EmptyFieldException("Empty Field.", path,
							lineNumber, i + 1);

				}

			if (cardInfo[0].equalsIgnoreCase("Monster")) {

				temp.add(new MonsterCard(cardInfo[1], cardInfo[2], Integer
						.parseInt(cardInfo[5]), Integer.parseInt(cardInfo[3]),
						Integer.parseInt(cardInfo[4])));

			} else {

				if (!cardInfo[0].equalsIgnoreCase("Spell")) {

					br.close();
					throw new UnknownCardTypeException("Unknown Card type.",
							path, lineNumber, cardInfo[0]);

				}

				switch (cardInfo[1]) {

				case "Card Destruction":
					temp.add(new CardDestruction(cardInfo[1], cardInfo[2]));
					break;
				case "Change Of Heart":
					temp.add(new ChangeOfHeart(cardInfo[1], cardInfo[2]));
					break;
				case "Dark Hole":
					temp.add(new DarkHole(cardInfo[1], cardInfo[2]));
					break;
				case "Graceful Dice":
					temp.add(new GracefulDice(cardInfo[1], cardInfo[2]));
					break;
				case "Harpie's Feather Duster":
					temp.add(new HarpieFeatherDuster(cardInfo[1], cardInfo[2]));
					break;
				case "Heavy Storm":
					temp.add(new HeavyStorm(cardInfo[1], cardInfo[2]));
					break;
				case "Mage Power":
					temp.add(new MagePower(cardInfo[1], cardInfo[2]));
					break;
				case "Monster Reborn":
					temp.add(new MonsterReborn(cardInfo[1], cardInfo[2]));
					break;
				case "Pot of Greed":
					temp.add(new PotOfGreed(cardInfo[1], cardInfo[2]));
					break;
				case "Raigeki":
					temp.add(new Raigeki(cardInfo[1], cardInfo[2]));
					break;
				default:
					throw new UnknownSpellCardException("Unknown Spell card",
							path, lineNumber, cardInfo[1]);

				}

			}

		}

		br.close();

		return (temp);

	}

	private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) {

		ArrayList<Card> temp1 = new ArrayList<Card>();

		for (int i = 0; i < monsters.size(); i++) {
			MonsterCard x = (MonsterCard) monsters.get(i);
			MonsterCard y = new MonsterCard(x.getName(), x.getDescription(),
					x.getLevel(), x.getAttackPoints(), x.getDefensePoints());
			temp1.add(y);
		}

		for (int k = 0; k < 15; k++) {
			if (temp1.isEmpty())
				break;
			int index = (int) (Math.random() * temp1.size());
			if (index != -1) {
				MonsterCard temp = (MonsterCard) temp1.remove(index);
				temp.setLocation(Location.DECK);
				deck.add(temp);

			} else {
				break;
			}
		}
		ArrayList<Card> temp2 = new ArrayList<Card>();
		for (int l = 0; l < spells.size(); l++) {
			switch (spells.get(l).getName()) {
			case "Card Destruction":
				temp2.add(new CardDestruction(spells.get(l).getName(), spells
						.get(l).getDescription()));
				break;
			case "Change Of Heart":
				temp2.add(new ChangeOfHeart(spells.get(l).getName(), spells
						.get(l).getDescription()));
				break;
			case "Dark Hole":
				temp2.add(new DarkHole(spells.get(l).getName(), spells.get(l)
						.getDescription()));
				;
				break;
			case "Graceful Dice":
				temp2.add(new GracefulDice(spells.get(l).getName(), spells.get(
						l).getDescription()));
				;
				break;
			case "Harpie's Feather Duster":
				temp2.add(new HarpieFeatherDuster(spells.get(l).getName(),
						spells.get(l).getDescription()));
				;
				break;
			case "Heavy Storm":
				temp2.add(new HeavyStorm(spells.get(l).getName(), spells.get(l)
						.getDescription()));
				;
				break;
			case "Mage Power":
				temp2.add(new MagePower(spells.get(l).getName(), spells.get(l)
						.getDescription()));
				;
				break;
			case "Monster Reborn":
				temp2.add(new MonsterReborn(spells.get(l).getName(), spells
						.get(l).getDescription()));
				;
				break;
			case "Pot of Greed":
				temp2.add(new PotOfGreed(spells.get(l).getName(), spells.get(l)
						.getDescription()));
				;
				break;
			case "Raigeki":
				temp2.add(new Raigeki(spells.get(l).getName(), spells.get(l)
						.getDescription()));
				;
				break;
			default:
				break;
			}
		}

		for (int j = 0; j < 5; j++) {
			if (temp2.isEmpty())
				break;
			int index = (int) (Math.random() * temp2.size());
			SpellCard t = (SpellCard) temp2.remove(index);
			deck.add(t);
			t.setLocation(Location.DECK);

		}
	}

	private void shuffleDeck() {

		Collections.shuffle(deck);

	}

	public ArrayList<Card> drawNCards(int n) {

		ArrayList<Card> cards = new ArrayList<Card>(n);

		for (int i = 0; i < n; i++)
			cards.add(deck.remove(0));

		return (cards);

	}

	public Card drawOneCard() {

		return (deck.remove(0));

	}

	public static ArrayList<Card> getMonsters() {
		return monsters;
	}

	public static void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}

	public static ArrayList<Card> getSpells() {
		return spells;
	}

	public static void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public static String getMonstersPath() {
		return monstersPath;
	}

	public static void setMonstersPath(String monstersPath) {
		Deck.monstersPath = monstersPath;
	}

	public static String getSpellsPath() {
		return spellsPath;
	}

	public static void setSpellsPath(String spellsPath) {
		Deck.spellsPath = spellsPath;
	}

}
