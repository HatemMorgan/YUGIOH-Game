package eg.edu.guc.yugioh.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainGameBoard extends JFrame {
JFrame frame;
JPanel panel;
private ArrayList<HandButtons> handbuttons;
private ArrayList<HandButtons> handbuttons2;
private ArrayList<MonsterButtons> monsterbuttons;
private ArrayList<MonsterButtons> monsterbuttons2;
private ArrayList<SpellButtons> spellbuttons;
private ArrayList<SpellButtons> spellbuttons2;
private ArrayList<PlayerButtons>playerbuttons;
int Handwidth=1400;
int Handwidth2=1400;
int MonsterWidth=600;
int MonsterWidth2=600;
int SpellWidth=600;
int SpellWidth2=600;
private JLabel LargeVeiw;
public static JLabel PlayerName1;
 public static JLabel PlayerName2;
 JLabel Player1LifePoints;
 JLabel Player2LifePoints;
 JLabel PlayerPhase2;
 JLabel PlayerPhase1;
 JLabel numberCardsOfDeck2;
 JLabel numberCardsOfDeck;
public JLabel getNumberCardsOfDeck() {
	return numberCardsOfDeck;
}



public JLabel getNumberCardsOfDeck2() {
	return numberCardsOfDeck2;
}



public JLabel getPlayerPhase2() {
	return PlayerPhase2;
}



public JLabel getPlayerPhase1() {
	return PlayerPhase1;
}



public JLabel getPlayer2LifePoints() {
	return Player2LifePoints;
}



public JLabel getPlayer1LifePoints() {
	return Player1LifePoints;
}



private JLabel MainBackground ;

 PlayerButtons endTurn;
 PlayerButtons endPhase;
 PlayerButtons summonMonster;
 PlayerButtons setMonster;
 PlayerButtons setSpell;
 PlayerButtons activateSpell;
 PlayerButtons switchMode;
 PlayerButtons attackMonster;
 PlayerButtons attackLifePoints;
 GraveYardButton graveyard2;
 GraveYardButton graveyard;
public MainGameBoard(/*ArrayList<JLabel> Hatem,ArrayList<JLabel> Hatem2*/)  {
	frame=new JFrame();
	panel= new JPanel();
	handbuttons=new ArrayList<HandButtons>();
	monsterbuttons=new ArrayList<MonsterButtons>();
	spellbuttons=new ArrayList<SpellButtons>();
	handbuttons2=new ArrayList<HandButtons>();
	monsterbuttons2=new ArrayList<MonsterButtons>();
	spellbuttons2=new ArrayList<SpellButtons>();
	playerbuttons=new ArrayList<PlayerButtons>();
	MainBackground=new JLabel(new ImageIcon("tumblr_m5mlsjjYT31r4dimdo1_1280.jpg"));
	 MainBackground.setSize(2000,1200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     panel.setOpaque(true);
     panel.setLayout(null);
     panel.add(MainBackground);
     frame.add(panel);
     frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
     frame.setSize(300,300);
     frame.setLocationByPlatform(true);
     frame.setVisible(true);
     frame.setTitle("YuGiOh Game");
     frame.validate();
   
    //MonsterImages Hatem=new MonsterImages();
     
     // y = new  JLabel (new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
     LargeVeiw=new JLabel();
     setEnabled(false);
     LargeVeiw.setLocation(0,210);
	     LargeVeiw.setSize(400,580);
	     LargeVeiw.setEnabled(true);
	    
	     MainBackground.add(LargeVeiw);
	     //if(p.equals(Card.getBoard().getActivePlayer())){
     for (int i=0; i<15;i++) {
    	  //  if(Hatem.size()>=(i+1)){
			HandButtons handButton= new HandButtons();
			handButton.setSize(80, 120);
			handButton.setLocationIndex(Handwidth);
		     handButton.setLocation(Handwidth,900);
		
			handButton.setIcon(new ImageIcon("hand.jpg"));
		handButton.setLayout(null);
		handButton.setOpaque(true);
			handbuttons.add(handButton);
			
		    MainBackground.add(handButton);
		    
		//	handButton.add(Hatem.get(i));
			
               	Handwidth= Handwidth-60;
               	handButton.addMouseListener(new MouseListener() {
    				
    				
    			
    				public void mouseReleased(MouseEvent arg0) {
    					
    					
    				}
    			
    				public void mousePressed(MouseEvent arg0) {
    					
    					
    				}
    		
    				public void mouseExited(MouseEvent e) {
    					 HandButtons b = (HandButtons) e.getSource();
    					 b.setLocation(b.getLocationIndex(),900);
    					 LargeVeiw.setEnabled(false);
    					return;
    			//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
    					
    					
    				}
    				
    				@Override
    				public void mouseEntered(MouseEvent e) {
    				
    				 HandButtons b = (HandButtons) e.getSource();
    				 String s= b.getLocationName();
    				
    				
    					 
    				 if(s!=null){
    						 b.setLocation(b.getLocationIndex(),850);
    						 switch(s)
    						   {
    						   case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("Red-Eyes Black Dragon.png")); break;
    	  						
    						    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("Blue-Eyes White Dragon.png")); break;
    							case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("CosmoQueen.png")); break;
    							case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("Dark Magician.png"));break;
    							case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("Gaia The Fierce Knight.png"));break;
    							case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("Summoned Skull.png"));break;
    							case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("Dark Magician Girl.png"));break;
    							case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("Curse Of Dragon.png"));break;
    							case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("Alexandrite Dragon.png"));break;
    							case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("Vorse Raider.png"));break;
    							case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("Gemini Elf.png"));break;
    							case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("Fence Guard Apprentice.png"));break;
    							case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Beta The Magnet Warrior.png"));break;
    							case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("Alligator Sword.png"));break;
    							case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Gamma The Magnet Warrior.png"));break;
    							case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("Celtic Guardian.png"));break;
    							case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Alpha The Magnet Warrior.png"));break;
    							case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("Harpie Lady.png"));break;
    							case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("Big Shield Gardna.png"));break;
    							case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("Witty Phantom.png"));break;
    							case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("Baby Dragon.png"));break;
    							case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("Cyber Jar.png"));break;
    							case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("Clown Zombie.png"));break;
    							case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("Time Wizard.png"));break;
    							case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("Man-Eater Bug.png"));break;
    							case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("Kuriboh.png"));break;
    							case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("Mokey Mokey.png"));break;
    							case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("Fence Guard Dragon.jpg"));break;
    							case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("Fence Guard Magician.jpg"));break;
    							case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("Fence Guard.jpg"));break;
    							case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("Card Destruction.png"));break;
    							case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("Change Of Heart.png"));break;
    							case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("Dark Hole.png"));break;
    							case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("Graceful Dice.png"));break;
    							case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("Harpie's Feather Duster.png"));break;
    							case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("Heavy Storm.png"));break;
    							case "Mage Power": LargeVeiw.setIcon(new ImageIcon("Mage Power.png"));break;
    							case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("Monster Reborn.png"));break;
    							case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("Pot of Greed.png"));break;
    							case "Raigeki": LargeVeiw.setIcon(new ImageIcon("Raigeki.png"));break;
    						   
    						   }

    	    					LargeVeiw.setEnabled(true);
                     
    				}	 
    				
    				
    				}
    			
    				
    				public void mouseClicked(MouseEvent e) {
    					
    					
    				};
    				 
    				
    				/*public void actionPerformed(ActionEvent e) {
    					x.setIcon(handButton.getIcon());;
    					soora.setVisible(true);
    					soora.setSize(200, 200);
    					soora2.add(x);
                        soora.add(soora2);		
                        return;
    					
    				}
    				*/
    			});
    			
    			//this.add(handButton, BorderLayout.CENTER);
    	   // }
    		
	     }
     for (int i=0; i<5;i++) {
 		MonsterButtons monsterButton= new MonsterButtons();
 	 
 		monsterButton.setIcon(new ImageIcon("monster.jpg"));
 		monsterbuttons.add(monsterButton);
 	  //  monsterButton.setLocationName(Hatem.getDeckLabels().get(i).getName());
 		MainBackground.add(monsterButton);
 		monsterButton.setLocation(MonsterWidth,550);
 		monsterButton.setSize(150,150);
 		//monsterButton.add(Hatem.getDeckLabels().get(i));
    	monsterButton.addMouseListener(new MouseListener() {
			
		
			public void mouseReleased(MouseEvent arg0) {
			
				
			}
	
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			//	LargeVeiw.setEnabled(false);
				//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
				 LargeVeiw.setEnabled(false);
		
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			    
				 MonsterButtons b =  (MonsterButtons)e.getSource();
				 String s= b.getLocationName();
		
				 if(s!=null){
					 switch(s)
					   {
					   case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("Red-Eyes Black Dragon.png")); break;
 						
					    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("Blue-Eyes White Dragon.png")); break;
						case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("CosmoQueen.png")); break;
						case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("Dark Magician.png"));break;
						case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("Gaia The Fierce Knight.png"));break;
						case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("Summoned Skull.png"));break;
						case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("Dark Magician Girl.png"));break;
						case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("Curse Of Dragon.png"));break;
						case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("Alexandrite Dragon.png"));break;
						case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("Vorse Raider.png"));break;
						case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("Gemini Elf.png"));break;
						case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("Fence Guard Apprentice.png"));break;
						case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Beta The Magnet Warrior.png"));break;
						case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("Alligator Sword.png"));break;
						case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Gamma The Magnet Warrior.png"));break;
						case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("Desktop\\YUGIOH image icons\\Monsters\\Celtic Guardian.png"));break;
						case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Alpha The Magnet Warrior.png"));break;
						case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("Harpie Lady.png"));break;
						case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("Big Shield Gardna.png"));break;
						case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("Witty Phantom.png"));break;
						case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("Baby Dragon.png"));break;
						case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("Cyber Jar.png"));break;
						case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("Clown Zombie.png"));break;
						case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("Time Wizard.png"));break;
						case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("Man-Eater Bug.png"));break;
						case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("Kuriboh.png"));break;
						case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("Mokey Mokey.png"));break;
						case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("Fence Guard Dragon.jpg"));break;
						case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("Fence Guard Magician.jpg"));break;
						case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("Fence Guard.jpg"));break;
					   }
					 LargeVeiw.setEnabled(true);
				 }
				
			}
			
		
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
 		MonsterWidth+=160;
     }
    
    
 	for (int i=0; i<5;i++) {
		SpellButtons spellButton= new SpellButtons();
		spellButton.setIcon(new ImageIcon("spell.jpg"));
		spellbuttons.add(spellButton);
		 //spellButton.setLocationName(Hatem.getDeckLabels().get(i).getName());
		 
		//spellButton.add(Hatem.getDeckLabels().get(i));
		 spellButton.setSize(150,150);
		 spellButton.setLocation(SpellWidth,710);
		MainBackground.add(spellButton);
        SpellWidth+=160;
        spellButton.addMouseListener(new MouseListener() {
			
	
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			

			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
				
				 LargeVeiw.setEnabled(false);
	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			
				SpellButtons b =   (SpellButtons) e.getSource();
				 String s= b.getLocationName();
					 
					
				 if(s!=null){ 
				 switch(s)
						   {
						   case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("Card Destruction.png"));break;
							case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("Change Of Heart.png"));break;
							case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("Dark Hole.png"));break;
							case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("Graceful Dice.png"));break;
							case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("Harpie's Feather Duster.png"));break;
							case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("Heavy Storm.png"));break;
							case "Mage Power": LargeVeiw.setIcon(new ImageIcon("Mage Power.png"));break;
							case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("Monster Reborn.png"));break;
							case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("Pot of Greed.png"));break;
							case "Raigeki": LargeVeiw.setIcon(new ImageIcon("Raigeki.png"));break;
					        
						   }
				 LargeVeiw.setEnabled(true);
			}
			
				
			}
			
			
			public void mouseClicked(MouseEvent arg0) {
			
				
			}
		});
 	}
 	JLabel deck= new JLabel();
 	deck.setIcon(new ImageIcon("DECK.jpg"));
 	deck.setSize(180,180);
 	deck.setLocation(1700,820);
   MainBackground.add(deck);
   
       
  numberCardsOfDeck= new JLabel("The Deck contains n Cards",JLabel.CENTER); 
  
  numberCardsOfDeck.setSize(200,20);
  numberCardsOfDeck.setLocation(1680,800);
  numberCardsOfDeck.setForeground(Color.RED.brighter());
  numberCardsOfDeck.setFont(new Font(numberCardsOfDeck.getText(),Font.BOLD,13));
  MainBackground.add(numberCardsOfDeck);
  
   graveyard= new GraveYardButton();
  graveyard.setIcon(new ImageIcon("graveyard.jpg"));
  graveyard.setSize(180,180);
  //graveyard.setLocationName(Hatem.getDeckLabels().get(0).getName());
	 
//	graveyard.add(Hatem.getDeckLabels().get(0));
  graveyard.setLocation(1700,600);
  MainBackground.add(graveyard);
  graveyard.addMouseListener(new MouseListener() {
	
	
	public void mouseReleased(MouseEvent e) {
		
		
	}
	

	public void mousePressed(MouseEvent e) {
	
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
		 LargeVeiw.setEnabled(false);
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		 GraveYardButton b =  (GraveYardButton) e.getSource();
		 String s= b.getLocationName();
		 //System.out.println(b.getName());
		
			 
			
		 if(s!=null){
				 switch(s)
				   {
				   case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("Red-Eyes Black Dragon.png")); break;
						
				    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("Blue-Eyes White Dragon.png")); break;
					case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("CosmoQueen.png")); break;
					case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("Dark Magician.png"));break;
					case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("Gaia The Fierce Knight.png"));break;
					case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("Summoned Skull.png"));break;
					case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("Dark Magician Girl.png"));break;
					case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("Curse Of Dragon.png"));break;
					case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("Alexandrite Dragon.png"));break;
					case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("Vorse Raider.png"));break;
					case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("Gemini Elf.png"));break;
					case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("Fence Guard Apprentice.png"));break;
					case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Beta The Magnet Warrior.png"));break;
					case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("Alligator Sword.png"));break;
					case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Gamma The Magnet Warrior.png"));break;
					case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("Desktop\\YUGIOH image icons\\Monsters\\Celtic Guardian.png"));break;
					case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Alpha The Magnet Warrior.png"));break;
					case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("Harpie Lady.png"));break;
					case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("Big Shield Gardna.png"));break;
					case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("Witty Phantom.png"));break;
					case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("Baby Dragon.png"));break;
					case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("Cyber Jar.png"));break;
					case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("Clown Zombie.png"));break;
					case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("Time Wizard.png"));break;
					case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("Man-Eater Bug.png"));break;
					case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("Kuriboh.png"));break;
					case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("Mokey Mokey.png"));break;
					case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("Fence Guard Dragon.jpg"));break;
					case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("Fence Guard Magician.jpg"));break;
					case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("Fence Guard.jpg"));break;
					case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("Card Destruction.png"));break;
					case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("Change Of Heart.png"));break;
					case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("Dark Hole.png"));break;
					case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("Graceful Dice.png"));break;
					case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("Harpie's Feather Duster.png"));break;
					case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("Heavy Storm.png"));break;
					case "Mage Power": LargeVeiw.setIcon(new ImageIcon("Mage Power.png"));break;
					case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("Monster Reborn.png"));break;
					case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("Pot of Greed.png"));break;
					case "Raigeki": LargeVeiw.setIcon(new ImageIcon("Raigeki.png"));break;
				   
				   }
				 LargeVeiw.setEnabled(true);
	}
	}
	

	public void mouseClicked(MouseEvent e) {
		
		
	}
});
  // Player2
  for (int i=0; i<15;i++) {
	 // if(Hatem2.size()>=(i+1)){
			HandButtons handButton= new HandButtons();
			handButton.setSize(100, 120);
			handButton.setLocationIndex(Handwidth2);
		     handButton.setLocation(Handwidth2,0);
		   //  handButton.setLocationName(Hatem2.get(i).getName());
			handButton.setIcon(new ImageIcon("hand.jpg"));
			//handButton.setLocationName(Hatem.getDeckLabels().get(i).getName());
			handbuttons2.add(handButton);
		    MainBackground.add(handButton);
		//	handButton.add(Hatem2.get(i));
			//handButton.add(Hatem.getDeckLabels().get(i));
             	Handwidth2= Handwidth2-60;
             	handButton.addMouseListener(new MouseListener() {
  				
  				
  			
  				public void mouseReleased(MouseEvent arg0) {
  			
  					
  				}
  				
  				
  				public void mousePressed(MouseEvent arg0) {
  				
  					
  				}
  				
  				@Override
  				public void mouseExited(MouseEvent e) {
  					 HandButtons b = (HandButtons) e.getSource();
  					 b.setLocation(b.getLocationIndex(),0);
  					 LargeVeiw.setEnabled(false);
					
  		     //	LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
  					
  					
  				}
  				
  				@Override
  				public void mouseEntered(MouseEvent e) {
  				
  				 HandButtons b = (HandButtons) e.getSource();
  				
  				 String s= b.getLocationName();
  				 //System.out.println(b.getName());
  				if(s!=null){
  				
  						 b.setLocation(b.getLocationIndex(),20);
  						 switch(s)
  						   {
  						 case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("Red-Eyes Black Dragon.png")); break;
  						
  						    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("Blue-Eyes White Dragon.png")); break;
  							case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("CosmoQueen.png")); break;
  							case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("Dark Magician.png"));break;
  							case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("Gaia The Fierce Knight.png"));break;
  							case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("Summoned Skull.png"));break;
  							case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("Dark Magician Girl.png"));break;
  							case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("Curse Of Dragon.png"));break;
  							case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("Alexandrite Dragon.png"));break;
  							case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("Vorse Raider.png"));break;
  							case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("Gemini Elf.png"));break;
  							case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("Fence Guard Apprentice.png"));break;
  							case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Beta The Magnet Warrior.png"));break;
  							case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("Alligator Sword.png"));break;
  							case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Gamma The Magnet Warrior.png"));break;
  							case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("Desktop\\YUGIOH image icons\\Monsters\\Celtic Guardian.png"));break;
  							case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Alpha The Magnet Warrior.png"));break;
  							case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("Harpie Lady.png"));break;
  							case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("Big Shield Gardna.png"));break;
  							case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("Witty Phantom.png"));break;
  							case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("Baby Dragon.png"));break;
  							case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("Cyber Jar.png"));break;
  							case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("Clown Zombie.png"));break;
  							case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("Time Wizard.png"));break;
  							case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("Man-Eater Bug.png"));break;
  							case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("Kuriboh.png"));break;
  							case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("Mokey Mokey.png"));break;
  							case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("Fence Guard Dragon.jpg"));break;
							case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("Fence Guard Magician.jpg"));break;
							case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("Fence Guard.jpg"));break;
  							case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("Card Destruction.png"));break;
  							case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("Change Of Heart.png"));break;
  							case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("Dark Hole.png"));break;
  							case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("Graceful Dice.png"));break;
  							case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("Harpie's Feather Duster.png"));break;
  							case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("Heavy Storm.png"));break;
  							case "Mage Power": LargeVeiw.setIcon(new ImageIcon("Mage Power.png"));break;
  							case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("Monster Reborn.png"));break;
  							case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("Pot of Greed.png"));break;
  							case "Raigeki": LargeVeiw.setIcon(new ImageIcon("Raigeki.png"));break;
  						 
  						   }
  						LargeVeiw.setEnabled(true);
  				}
  		
                    
                   
  					 
  				
  				
  				}
  				@Override
  				public void mouseClicked(MouseEvent arg0) {
  					// TODO Auto-generated method stub
  					
  				};
  				 
  				
  				/*public void actionPerformed(ActionEvent e) {
  					x.setIcon(handButton.getIcon());;
  					soora.setVisible(true);
  					soora.setSize(200, 200);
  					soora2.add(x);
                      soora.add(soora2);		
                      return;
  					
  				}
  				*/
  			});
  			
  		
	//  }
  		}
  for (int i=0; i<5;i++) {
		MonsterButtons monsterButton= new MonsterButtons();
	 
		monsterButton.setIcon(new ImageIcon("monster.jpg"));
		monsterbuttons2.add(monsterButton);
	  //  monsterButton.setLocationName(Hatem.getDeckLabels().get(i).getName());
		MainBackground.add(monsterButton);
		monsterButton.setLocation(MonsterWidth2,330);
		monsterButton.setSize(150,150);
		//monsterButton.add(Hatem.getDeckLabels().get(i));
  	monsterButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				 LargeVeiw.setEnabled(false);
				
		//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				 MonsterButtons b =  (MonsterButtons)e.getSource();
				 String s= b.getLocationName();
				 if(s!=null){
					 
					 switch(s)
					   {
					   case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("Red-Eyes Black Dragon.png")); break;
 						
					    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("Blue-Eyes White Dragon.png")); break;
						case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("CosmoQueen.png")); break;
						case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("Dark Magician.png"));break;
						case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("Gaia The Fierce Knight.png"));break;
						case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("Summoned Skull.png"));break;
						case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("Dark Magician Girl.png"));break;
						case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("Curse Of Dragon.png"));break;
						case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("Alexandrite Dragon.png"));break;
						case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("Vorse Raider.png"));break;
						case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("Gemini Elf.png"));break;
						case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("Fence Guard Apprentice.png"));break;
						case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Beta The Magnet Warrior.png"));break;
						case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("Alligator Sword.png"));break;
						case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Gamma The Magnet Warrior.png"));break;
						case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("Desktop\\YUGIOH image icons\\Monsters\\Celtic Guardian.png"));break;
						case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Alpha The Magnet Warrior.png"));break;
						case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("Harpie Lady.png"));break;
						case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("Big Shield Gardna.png"));break;
						case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("Witty Phantom.png"));break;
						case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("Baby Dragon.png"));break;
						case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("Cyber Jar.png"));break;
						case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("Clown Zombie.png"));break;
						case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("Time Wizard.png"));break;
						case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("Man-Eater Bug.png"));break;
						case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("Kuriboh.png"));break;
						case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("Mokey Mokey.png"));break;
						case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("Fence Guard Dragon.jpg"));break;
						case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("Fence Guard Magician.jpg"));break;
						case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("Fence Guard.jpg"));break;
					   
					   }
					 LargeVeiw.setEnabled(true);
			}
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		MonsterWidth2+=160;
   }
  for (int i=0; i<5;i++) {
		SpellButtons spellButton= new SpellButtons();
		spellButton.setIcon(new ImageIcon("spell.jpg"));
		spellbuttons2.add(spellButton);
		 //spellButton.setLocationName(Hatem.getDeckLabels().get(i).getName());
		 
		//spellButton.add(Hatem.getDeckLabels().get(i));
		 spellButton.setSize(150,150);
		 spellButton.setLocation(SpellWidth2,170);
		MainBackground.add(spellButton);
      SpellWidth2+=160;
      spellButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
				 LargeVeiw.setEnabled(false);
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			
				SpellButtons b =   (SpellButtons) e.getSource();
				 String s= b.getLocationName();
					 
		if(s!=null){
						 
				 switch(s)
						   {
						   case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("Card Destruction.png"));break;
							case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("Change Of Heart.png"));break;
							case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("Dark Hole.png"));break;
							case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("Graceful Dice.png"));break;
							case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("Harpie's Feather Duster.png"));break;
							case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("Heavy Storm.png"));break;
							case "Mage Power": LargeVeiw.setIcon(new ImageIcon("Mage Power.png"));break;
							case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("Monster Reborn.png"));break;
							case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("Pot of Greed.png"));break;
							case "Raigeki": LargeVeiw.setIcon(new ImageIcon("Raigeki.png"));break;
					     
						   }
				 LargeVeiw.setEnabled(true);
		}
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	JLabel deck2= new JLabel();
 	deck2.setIcon(new ImageIcon("DECK.jpg"));
 	deck2.setSize(180,180);
 	deck2.setLocation(1700,0);
   MainBackground.add(deck2);
   
       
  numberCardsOfDeck2= new JLabel("The Deck contains n Cards",JLabel.CENTER); 
  
  numberCardsOfDeck2.setSize(200,20);
  numberCardsOfDeck2.setLocation(1680,185);
  numberCardsOfDeck2.setForeground(Color.RED.brighter());
  numberCardsOfDeck2.setFont(new Font(numberCardsOfDeck2.getText(),Font.BOLD,13));
  MainBackground.add(numberCardsOfDeck2);
  
 graveyard2= new GraveYardButton();
  graveyard2.setIcon(new ImageIcon("graveyard.jpg"));
  graveyard2.setSize(180,180);
  //graveyard2.setLocationName(Hatem.getDeckLabels().get(0).getName());
	 
//	graveyard2.add(Hatem.getDeckLabels().get(0));
  graveyard2.setLocation(1700,210);
  MainBackground.add(graveyard2);
  graveyard2.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		//LargeVeiw.setIcon(new ImageIcon("ed6f7a3b3c9dc081b4216409c2319.jpg"));
		 LargeVeiw.setEnabled(false);
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		LargeVeiw.setEnabled(true);
		 GraveYardButton b =  (GraveYardButton) e.getSource();
		 String s= b.getLocationName();
		 //System.out.println(b.getName());
		
			 
		 if(s!=null){
				 
				 switch(s)
				   {
				   case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("Red-Eyes Black Dragon.png")); break;
						
				    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("Blue-Eyes White Dragon.png")); break;
					case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("CosmoQueen.png")); break;
					case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("Dark Magician.png"));break;
					case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("Gaia The Fierce Knight.png"));break;
					case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("Summoned Skull.png"));break;
					case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("Dark Magician Girl.png"));break;
					case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("Curse Of Dragon.png"));break;
					case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("Alexandrite Dragon.png"));break;
					case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("Vorse Raider.png"));break;
					case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("Gemini Elf.png"));break;
					case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("Fence Guard Apprentice.png"));break;
					case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Beta The Magnet Warrior.png"));break;
					case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("Alligator Sword.png"));break;
					case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Gamma The Magnet Warrior.png"));break;
					case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("Desktop\\YUGIOH image icons\\Monsters\\Celtic Guardian.png"));break;
					case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("Alpha The Magnet Warrior.png"));break;
					case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("Harpie Lady.png"));break;
					case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("Big Shield Gardna.png"));break;
					case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("Witty Phantom.png"));break;
					case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("Baby Dragon.png"));break;
					case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("Cyber Jar.png"));break;
					case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("Clown Zombie.png"));break;
					case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("Time Wizard.png"));break;
					case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("Man-Eater Bug.png"));break;
					case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("Kuriboh.png"));break;
					case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("Mokey Mokey.png"));break;
					case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("Fence Guard Dragon.jpg"));break;
					case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("Fence Guard Magician.jpg"));break;
					case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("Fence Guard.jpg"));break;
					case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("Card Destruction.png"));break;
					case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("Change Of Heart.png"));break;
					case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("Dark Hole.png"));break;
					case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("Graceful Dice.png"));break;
					case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("Harpie's Feather Duster.png"));break;
					case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("Heavy Storm.png"));break;
					case "Mage Power": LargeVeiw.setIcon(new ImageIcon("Mage Power.png"));break;
					case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("Monster Reborn.png"));break;
					case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("Pot of Greed.png"));break;
					case "Raigeki": LargeVeiw.setIcon(new ImageIcon("Raigeki.png"));break;
				    
				   }
				 LargeVeiw.setEnabled(true);
	}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
});
  
  endTurn = new PlayerButtons(new ImageIcon("Slide1.jpg"));
  endTurn.setSize(50,200 );
  endTurn.setLocation(450,800);
   MainBackground.add(endTurn);
   playerbuttons.add(endTurn);
   
  
   endPhase = new PlayerButtons(new ImageIcon("Slide2.jpg"));
  endPhase.setSize(50,200 );
  endPhase.setLocation(450,600);
  MainBackground.add(endPhase);
  playerbuttons.add(endPhase);
  
  
  
   activateSpell =new PlayerButtons(new ImageIcon("Slide7.jpg"));
  activateSpell.setSize(50,200 );
  activateSpell.setLocation(450,400);
  MainBackground.add(activateSpell);
  playerbuttons.add(activateSpell);
  
   switchMode =new PlayerButtons(new ImageIcon("Slide5.jpg"));
  switchMode.setSize(50,200 );
  switchMode.setLocation(450,200);
  MainBackground.add(switchMode);
  playerbuttons.add(switchMode);
  
   attackMonster=new PlayerButtons(new ImageIcon("Slide3.jpg"));
  attackMonster.setSize(50,200 );
  attackMonster.setLocation(450,0);
  MainBackground.add(attackMonster);
  playerbuttons.add(attackMonster);
  
 
  
   PlayerPhase2= new JLabel("Phase Main1");
  PlayerPhase2.setSize(200,100);
  PlayerPhase2.setLocation(0,140);
  PlayerPhase2.setFont(new Font(PlayerPhase2.getText(),Font.BOLD,20));
  PlayerPhase2.setForeground(Color.RED);
  MainBackground.add(PlayerPhase2);
  
  PlayerName2= new JLabel("Player Name");
  PlayerName2.setSize(300,100);
  PlayerName2.setLocation(0,0);
  PlayerName2.setFont(new Font(PlayerName2.getText(),Font.BOLD,20));
  PlayerName2.setForeground(Color.RED);
  MainBackground.add(PlayerName2);
  
 Player2LifePoints= new JLabel("Player LifePoints=8000");
  Player2LifePoints.setSize(300,100);
  Player2LifePoints.setLocation(0,70);
  Player2LifePoints.setFont(new Font(Player2LifePoints.getText(),Font.BOLD,20));
  Player2LifePoints.setForeground(Color.RED);
  MainBackground.add(Player2LifePoints);
  
  PlayerPhase1= new JLabel("Phase Main1");
  PlayerPhase1.setSize(200,100);
  PlayerPhase1.setLocation(0,800);
  PlayerPhase1.setFont(new Font(PlayerPhase1.getText(),Font.BOLD,20));
  PlayerPhase1.setForeground(Color.RED);
  MainBackground.add(PlayerPhase1);
  
  PlayerName1= new JLabel("Player Name");
  PlayerName1.setSize(300,100);
  PlayerName1.setLocation(0,920);
  PlayerName1.setFont(new Font(PlayerName1.getText(),Font.BOLD,20));
  PlayerName1.setForeground(Color.RED);
  MainBackground.add(PlayerName1);
  
 Player1LifePoints= new JLabel("Player LifePoints=8000");
  Player1LifePoints.setSize(300,100);
  Player1LifePoints.setLocation(0,870);
  Player1LifePoints.setFont(new Font(Player1LifePoints.getText(),Font.BOLD,20));
  Player1LifePoints.setForeground(Color.RED);
  MainBackground.add(Player1LifePoints);
}


 
public JFrame getFrame() {
	return frame;
}




public static JLabel getPlayerName1() {
	return PlayerName1;
}


public static JLabel getPlayerName2() {
	return PlayerName2;
}


public ArrayList<HandButtons> getHandbuttons() {
	return handbuttons;
}



public ArrayList<MonsterButtons> getMonsterbuttons() {
	return monsterbuttons;
}


public ArrayList<SpellButtons> getSpellbuttons() {
	return spellbuttons;
}

public ArrayList<PlayerButtons> getPlayerbuttons() {
	return playerbuttons;
}


public JPanel getPanel() {
	return panel;
}


public int getHandwidth() {
	return Handwidth;
}


public int getHandwidth2() {
	return Handwidth2;
}


public int getMonsterWidth() {
	return MonsterWidth;
}


public int getMonsterWidth2() {
	return MonsterWidth2;
}


public int getSpellWidth() {
	return SpellWidth;
}


public int getSpellWidth2() {
	return SpellWidth2;
}







public PlayerButtons getEndTurn() {
	return endTurn;
}


public PlayerButtons getEndPhase() {
	return endPhase;
}


public PlayerButtons getSummonMonster() {
	return summonMonster;
}


public PlayerButtons getSetMonster() {
	return setMonster;
}


public PlayerButtons getSetSpell() {
	return setSpell;
}


public PlayerButtons getActivateSpell() {
	return activateSpell;
}


public PlayerButtons getSwitchMode() {
	return switchMode;
}


public PlayerButtons getAttackMonster() {
	return attackMonster;
}


public PlayerButtons getAttackLifePoints() {
	return attackLifePoints;
}


public ArrayList<HandButtons> getHandbuttons2() {
	return handbuttons2;
}


public ArrayList<MonsterButtons> getMonsterbuttons2() {
	return monsterbuttons2;
}


public ArrayList<SpellButtons> getSpellbuttons2() {
	return spellbuttons2;
}


public JLabel getLargeVeiw() {
	return LargeVeiw;
}


public JLabel getMainBackground() {
	return MainBackground;
}



public GraveYardButton getGraveyard2() {
	return graveyard2;
}



public GraveYardButton getGraveyard() {
	return graveyard;
}


public static void main(String[] args) {

}
     }
				
