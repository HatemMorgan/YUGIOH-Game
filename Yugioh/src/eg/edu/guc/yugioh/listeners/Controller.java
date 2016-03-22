
package eg.edu.guc.yugioh.listeners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.Target;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.View;

//import com.sun.prism.image.ViewPort;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
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
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.GameOver;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoNameException;
import eg.edu.guc.yugioh.exceptions.NoNeededSacrficesFound;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
import eg.edu.guc.yugioh.gui.CardsImages;
import eg.edu.guc.yugioh.gui.HandButtons;
import eg.edu.guc.yugioh.gui.MainGameBoard;
import eg.edu.guc.yugioh.gui.MonsterButtons;
import eg.edu.guc.yugioh.gui.PlayerButtons;
import eg.edu.guc.yugioh.gui.Sound;
import eg.edu.guc.yugioh.gui.Sound2;
import eg.edu.guc.yugioh.gui.SpellButtons;



public class Controller extends JFrame implements ActionListener, Runnable  {
	JLabel  LargeVeiw;
	boolean b;
	String name;
	private JFrame frame;
	private JPanel panel;
	JButton startgame ;
	private JLabel Background ;
	private static JTextField Player2 = new JTextField(10);
	private static JTextField Player1 = new JTextField(10);
	JButton Click1;
    JButton Click2;
    JButton Click4;
    JButton Click3;
    
	//JFrame error;
	//JLabel errorMessage;
	MainGameBoard viewBoard;
    Board MainBoard;
    
	 JFrame Target;
	 JPanel framepanel;
	 int hieght=0;
	 
		PlayerButtons SummonMonsters=new PlayerButtons("Summon Monster");
		PlayerButtons SetMonsters=new PlayerButtons("Set Monster");
		PlayerButtons SetSpell=new PlayerButtons("Set Spell");
		PlayerButtons ActivateSpell=new PlayerButtons("Activate Spell");
	    JFrame f= new JFrame();
	     int index;
	    ArrayList<MonsterCard> sacrifices=new ArrayList<MonsterCard>();
	    MonsterCard ActiveMonster;
	    int activeMonsterIndex;
	 public Controller() {
	
b=false;
		
		frame= new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setOpaque(true);
		panel.setLayout(null);
		Background=new JLabel(new ImageIcon("Yugioh_Wallpaper_by_shannonrivergirl233.jpg"));
		
		JLabel text1=new JLabel("Player One Name:");
		text1.setSize(200,50);
		text1.setLocation(0,350);
		text1.setFont(new Font(text1.getText(), Font.BOLD,23));
		text1.setForeground(Color.GRAY);
		Background.add(text1);
		
		JLabel text2=new JLabel("Player Two Name:");
		text2.setSize(200,50);
		text2.setLocation(550,350);
		text2.setFont(new Font(text1.getText(), Font.BOLD,23));
		text2.setForeground(Color.GRAY);
		Background.add(text2);
		
		Background.setSize(2000,1000);
		panel.add(Background);
        Background.add(Player1);
        Background.add(Player2);
		Cursor x = new Cursor(Cursor.HAND_CURSOR);
        JButton startgame = new JButton("Start Game");
        startgame.setCursor(x);
        startgame.setOpaque(false);
        startgame.setBorderPainted(false);
         startgame.setContentAreaFilled(false);
         startgame.setFont(new Font("SANS-SERIF", Font.BOLD,33));
         
 		startgame.setForeground(Color.GRAY);
        startgame.setSize(250,100);
        startgame.setLocation(400,450);
        startgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				init();
				start();
			}
		});
        Background.add(startgame);
        
        Player1.setLocation(220,350);
        Player1.setSize(200,50);
        Player2.setLocation(820,350);
        Player2.setSize(200,50);
       
	    Target =new JFrame();
	    Target.setSize(240,700);
	    Target.setLocation(1400,200);
	    framepanel=new JPanel();
	    framepanel.setLayout(null);
	    
	     Target.add(framepanel);
	     
	     
		frame.setTitle("Yugioh");
		frame.add(panel);
		      frame.setSize(300,300);
             frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		     frame.setLocationByPlatform(true);
		     frame.setVisible(true);
		   
		   
		     startgame.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						if(Player1.getText().isEmpty()){
						
							JOptionPane.showMessageDialog(null,"Please enter Player1 Name");
							
							throw new NoNameException("Please enter Player1 Name");
						}
						if(Player2.getText().isEmpty()){
						
							JOptionPane.showMessageDialog(null,"Please enter Player2 Name");
							throw new NoNameException("Please enter Player2 Name");
						}
						
				
						
					
						frame.setVisible(false);
						 JFrame x =  new JFrame();
						 x.setExtendedState(JFrame.MAXIMIZED_BOTH);
							x.setVisible(true);
							//x.setSize(1000,600);
							//x.setLocation(300, 100);
							JLabel y ;
							JLabel text = new JLabel("ITS TIME TO DUEL");
							
							y=new JLabel(new ImageIcon("yugi.png"));
							y.setSize(2000,1000);
							
							JPanel o = new JPanel();
							o.setSize(1000,600);
							o.add(y);
							o.setOpaque(true);
							o.setLayout(null);
							//o.setBackground(Color.BLACK);
							
							x.add(o);
							javax.swing.Timer timer = new javax.swing.Timer(5000,new ActionListener() {
							
								
								@Override
								public void actionPerformed(ActionEvent e) {
									x.setVisible(false);
									
									x.dispose();
						            init2();
						            start2();
								
							
							
					
								try {
								Player	p1 = new Player(Player1.getText());
								Player	p2= new Player(Player2.getText());
								    
									 MainBoard= new Board();
								     
									viewBoard=new MainGameBoard();
									MainBoard.startGame(p1,p2);
									viewBoard.PlayerName1.setText(("ActivePlayer Name:"+MainBoard.getActivePlayer().getName()));
									viewBoard.PlayerName2.setText("Opponentplayer Name:"+MainBoard.getOpponentPlayer().getName());
									viewBoard.getNumberCardsOfDeck2().setText("The Deck contains "+MainBoard.getOpponentPlayer().getField().getDeck().getDeck().size()+" Card");
									 viewBoard.getNumberCardsOfDeck().setText("The Deck contains "+MainBoard.getActivePlayer().getField().getDeck().getDeck().size()+" Card");
					    		ArrayList<Card>temp1=MainBoard.getActivePlayer().getField().getHand();
									ArrayList<Card>temp2=MainBoard.getOpponentPlayer().getField().getHand();
									
										for(int i=0;i<6;i++){
			CardsImages c= new CardsImages(temp1.get(i).getName())	;
			
			viewBoard.getHandbuttons().get(i).add(c.getDeck());
			viewBoard.getHandbuttons().get(i).setLocationName(temp1.get(i).getName());	
			viewBoard.getHandbuttons().get(i).revalidate();
			viewBoard.getHandbuttons().get(i).repaint();
										}
        
						for(int i=0;i<5;i++){
			       
					
					viewBoard.getHandbuttons2().get(i).setLocationName(temp2.get(i).getName());	
					viewBoard.getHandbuttons2().get(i).revalidate();
					viewBoard.getHandbuttons2().get(i).repaint();									
										}					
												
									     addActionListenersToButtons();			
									   viewBoard.validate();
										viewBoard.repaint();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.getMessage();
								}
							   
								
								}
								
							});
							 timer.setRepeats(false);
							    timer.start();
					}
					
				});
	
		
	}
	 public void addActionListenersToButtons() {
		 ArrayList<HandButtons> Hand = viewBoard.getHandbuttons();
		 for(HandButtons handButton : Hand){
			 handButton.addActionListener(this);
	
	 }
		 ArrayList<HandButtons> Hand2 = viewBoard.getHandbuttons2();
		 for(HandButtons handButton : Hand2){
			 handButton.addActionListener(this);
	 }
		 ArrayList<MonsterButtons> MonsterArea = viewBoard.getMonsterbuttons();
		 for(MonsterButtons monster : MonsterArea){
			 monster.addActionListener(this);
		
	 }
		 ArrayList<MonsterButtons> MonsterArea2 = viewBoard.getMonsterbuttons2();
		 for(MonsterButtons monster : MonsterArea2){
			 monster.addActionListener(this);
	 }
		 ArrayList<SpellButtons> SpellButtons= viewBoard.getSpellbuttons();
		 for(SpellButtons spell : SpellButtons){
			 spell.addActionListener(this);
	 }
		 
		 ArrayList<PlayerButtons> playerButtons= viewBoard.getPlayerbuttons();
		 for( PlayerButtons playerbutton : playerButtons){
			 playerbutton.addActionListener(this);
		 }
	 }
	 
	 public void actionPerformed(ActionEvent e) {
 if(Click1==null){
			 if(e.getSource() instanceof HandButtons){
					Click1=(HandButtons) e.getSource();
					 int index=viewBoard.getHandbuttons().indexOf(Click1);
					 if(index!=-1){
					 Card check= MainBoard.getActivePlayer().getField().getHand().get(index);
					 if(check instanceof MonsterCard){
			    f=new JFrame();
			        f.setLayout(new FlowLayout());
			        f.setLocation(850,520);
			        f.setSize(250,35);
			        SummonMonsters=new PlayerButtons("Summon Monster");
			        SummonMonsters.addActionListener(this);
			        f.add(SummonMonsters);  
			      SetMonsters=new PlayerButtons("Set Monster");
			        SetMonsters.addActionListener(this);
			        f.add(SetMonsters);
                   f.setUndecorated(true);
                   f.setVisible(true);
					 }  else{
						 f=new JFrame();
					        f.setLayout(new FlowLayout());
					        f.setLocation(850,520);
					        f.setSize(250,35);
					        SetSpell =new PlayerButtons("Set Spell");
					        SetSpell.addActionListener(this);
					        f.add(SetSpell);
					        ActivateSpell=new PlayerButtons("Activate Spell");
					        ActivateSpell.addActionListener(this);
					        f.add(ActivateSpell);
		                   f.setUndecorated(true);
		                   f.setVisible(true);
					 }
					 }
			
			 } else{
				 if(e.getSource() instanceof PlayerButtons){
					 if(e.getSource()==viewBoard.getAttackMonster()){
					 Click1=(PlayerButtons) e.getSource();
				     
					 } else{
						 if(e.getSource()==viewBoard.getEndPhase()){
							 try{
							 if(!(MainBoard.getActivePlayer().getField().getPhase().equals(Phase.MAIN2))){
							MainBoard.getActivePlayer().endPhase();
							viewBoard.getPlayerPhase1().setText("Phase"+MainBoard.getActivePlayer().getField().getPhase());
							 viewBoard.getPlayerPhase2().setText("Phase"+MainBoard.getOpponentPlayer().getField().getPhase());
							 updateViewBoard();
							 }
								}catch (RuntimeException e1) {
									
									JOptionPane.showMessageDialog(null,e1.getMessage());
								}
								 finally
							      {
									 Click1 =null;
							    	 Click2 =null;
							      }
						
							 
						 }else{
							 if(e.getSource()==viewBoard.getEndTurn()){
								 try{
								 MainBoard.getActivePlayer().endTurn();
						        updateViewBoard();
						          viewBoard.getPlayerPhase1().setText("Phase"+MainBoard.getActivePlayer().getField().getPhase());
									 viewBoard.getPlayerPhase2().setText("Phase"+MainBoard.getOpponentPlayer().getField().getPhase());
									 updateViewBoard();
									 viewBoard.revalidate();
									  viewBoard.repaint();
										viewBoard.getMainBackground().revalidate();
										viewBoard.getMainBackground().repaint();
									}catch (RuntimeException e1) {
										
										JOptionPane.showMessageDialog(null,e1.getMessage());
									}
									 finally
								      {
										 Click1 =null;
								    	 Click2 =null;
								      }		
							 }else{
								 if(e.getSource()==viewBoard.getActivateSpell()){
									 Click1=(PlayerButtons)e.getSource();
								 }else{
									 if(e.getSource()==viewBoard.getSwitchMode()){
										 Click1=(PlayerButtons)e.getSource();
									 }
								 }
							 }
						 }
					 }
				 }
			 }
		 }else{
			 
			if(e.getSource() instanceof MonsterButtons && Click1==viewBoard.getAttackMonster()){
				
					
				Click2=(MonsterButtons)e.getSource();
				int index=viewBoard.getMonsterbuttons().indexOf(Click2);
				String s = "";
				try{
			 s=viewBoard.getMonsterbuttons().get(index).getLocationName();}
				catch (IndexOutOfBoundsException exception){JOptionPane.showMessageDialog(null, "Invalid move !");}
				for(int j=0;j<5;j++){
				if(MainBoard.getActivePlayer().getField().getMonstersArea().get(j).getName().equals(s)){	
				 activeMonsterIndex=j;
				 ActiveMonster=MainBoard.getActivePlayer().getField().getMonstersArea().get(j);
				 break;
				}
				}
			
					
				if(MainBoard.getOpponentPlayer().getField().getMonstersArea().size()!=0){
						ArrayList<JButton> temp=new ArrayList<JButton>();
						for(int i=0;i<MainBoard.getOpponentPlayer().getField().getMonstersArea().size();i++){
							String name2=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName();
							JLabel back=null;
							if(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getMode().equals(Mode.ATTACK)){
							
								
						     
							CardsImages c2=new CardsImages(name2 );
						     back =c2.getDeck();
							}else{
								CardsImages c2=new CardsImages("Defence");
							     back =c2.getDeck();
							}
						
						    back.setSize(80,117);
						    JButton b= new JButton(name2);
						   
						    b.setSize(80,120);
						    b.setLocation(100,hieght);
						    b.setLayout(null);
						    JLabel bc=new JLabel(new ImageIcon("yugioh-netflix.jpg"));
						    bc.setSize(240,700);
						    framepanel.add(bc);
						    framepanel.setOpaque(true);
						  
						    b.add(back);
						    bc.add(b);
						    temp.add(b);
						   
						   // Target.setLocationByPlatform(true);
						    hieght+=130;
							}
						
						Target.revalidate();
						Target.repaint();
							Target.setVisible(true);
							 LargeVeiw=new JLabel();
						     setEnabled(false);
						     LargeVeiw.setLocation(0,210);
							     LargeVeiw.setSize(400,580);
							     LargeVeiw.setEnabled(true);
							    
							     viewBoard.getMainBackground().add(LargeVeiw);
							for(int i=0;i<temp.size();i++){
								 temp.get(i).addMouseListener(new MouseListener() {
									
								
									public void mouseReleased(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void mousePressed(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void mouseExited(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										 JButton b =(JButton)e.getSource();
					    				 String s= b.getText();
					    				 MonsterCard m=null;
					    				 for(int i=0;i<MainBoard.getOpponentPlayer().getField().getMonstersArea().size();i++){
											    
												if(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName().equals(name)){
											
													 m=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i);
													
												break;
												}}
					    				
					    					 if(m!=null&&m.getMode().equals(Mode.ATTACK)){
					    				 if(s!=null){
					    						 switch(s)
					    						   {
					    						   case "Red-Eyes Black Dragon" :viewBoard.getLargeVeiw().setName("Red-Eyes Black Dragon"); viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Red-Eyes Black Dragon.png")); break;
					    	  						
					    						    case "Blue-Eyes White Dragon" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Blue-Eyes White Dragon.png")); break;
					    							case "Cosmo Queen" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/CosmoQueen.png")); break;
					    							case "Dark Magician" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Dark Magician.png"));break;
					    							case "Gaia The Fierce Knight" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Gaia The Fierce Knight.png"));break;
					    							case "Summoned Skull" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Summoned Skull.png"));break;
					    							case "Dark Magician Girl" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Dark Magician Girl.png"));break;
					    							case "Curse Of Dragon" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Curse Of Dragon.png"));break;
					    							case "Alexandrite Dragon" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Alexandrite Dragon.png"));break;
					    							case "Vorse Raider" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Vorse Raider.png"));break;
					    							case "Gemini Elf" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Gemini Elf.png"));break;
					    							case "Fence Guard Apprentice" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Fence Guard Apprentice.png"));break;
					    							case "Beta The Magnet Warrior" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Beta The Magnet Warrior.png"));break;
					    							case "Alligator Sword" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Alligator Sword.png"));break;
					    							case "Gamma The Magnet Warrior" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Gamma The Magnet Warrior.png"));break;
					    							case "Celtic Guardian" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Celtic Guardian.png"));break;
					    							case "Alpha The Magnet Warrior" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Alpha The Magnet Warrior.png"));break;
					    							case "Harpie Lady" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Harpie Lady.png"));break;
					    							case "Big Shield Gardna" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Big Shield Gardna.png"));break;
					    							case "Witty Phantom" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Witty Phantom.png"));break;
					    							case "Baby Dragon" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Baby Dragon.png"));break;
					    							case "Cyber Jar" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Cyber Jar.png"));break;
					    							case "Clown Zombie" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Clown Zombie.png"));break;
					    							case "Time Wizard" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Time Wizard.png"));break;
					    							case "Man-Eater Bug" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Man-Eater Bug.png"));break;
					    							case "Kuriboh" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Kuriboh.png"));break;
					    							case "Mokey Mokey" : viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Mokey Mokey.png"));break;
					    							case "Fence Guard Dragon": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Fence Guard Dragon.jpg"));break;
					    							case "Fence Guard Magician": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Fence Guard Magician.jpg"));break;
					    							case "Fence Guard": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Fence Guard.jpg"));break;
					    							case "Card Destruction": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Card Destruction.png"));break;
					    							case "Change Of Heart": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Change Of Heart.png"));break;
					    							case "Dark Hole": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Dark Hole.png"));break;
					    							case "Graceful Dice": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Graceful Dice.png"));break;
					    							case "Harpie's Feather Duster": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Harpie's Feather Duster.png"));break;
					    							case "Heavy Storm": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Heavy Storm.png"));break;
					    							case "Mage Power": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Mage Power.png"));break;
					    							case "Monster Reborn": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Monster Reborn.png"));break;
					    							case "Pot of Greed": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Pot of Greed.png"));break;
					    							case "Raigeki": viewBoard.getLargeVeiw().setIcon(new ImageIcon("/Raigeki.png"));break;
					    						   
					    						   }
					    						 viewBoard.getLargeVeiw().setLocation(0,210);
					    					     viewBoard.getLargeVeiw().setSize(400,580);
					    	    					viewBoard.getLargeVeiw().setEnabled(true);
					                     
					    				}	 
					    				
					    					 }else{
					    						 viewBoard.getLargeVeiw().setIcon(new ImageIcon("downCard - Copy.jpg")); 
					    					 }
					    					 
									}
									
									@Override
									public void mouseClicked(MouseEvent e) {
									JButton b= (JButton) e.getSource();
                              	    String name=b.getText();
                          		  
									int intialLifePoints1= MainBoard.getActivePlayer().getLifePoints();
									int intialLifePoints2= MainBoard.getOpponentPlayer().getLifePoints();
								
									try{
									for(int i=0;i<MainBoard.getOpponentPlayer().getField().getMonstersArea().size();i++){
								    
									if(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName().equals(name)){
								
										MonsterCard m=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i);
										
										MainBoard.getActivePlayer().declareAttack(ActiveMonster, m);
										updateViewBoard();
									break;
									}}
									}catch (RuntimeException e1) {
										
										JOptionPane.showMessageDialog(null,e1.getMessage());
									}
									 finally
								      {
										 Click1 =null;
								    	 Click2 =null;
								      }
									for(int i=0;i<temp.size();i++){
									Container c= temp.get(i).getParent();
									c.remove(temp.get(i));	
									c.revalidate();
									c.repaint();
									}
									hieght=0;
									Target.revalidate();
									Target.repaint();
									Target.setVisible(false);
								
									}
								});
								}
				 }else{
					 try{
				
					
					 MainBoard.getActivePlayer().declareAttack(ActiveMonster);
					 updateViewBoard();
					     
					 }catch (RuntimeException e1) {
							
							JOptionPane.showMessageDialog(null,e1.getMessage());
						}
						 finally
					      {
							 Click1 =null;
					    	 Click2 =null;
					      }		
				 }
			
				  viewBoard.revalidate();
				  viewBoard.repaint();
					viewBoard.getMainBackground().revalidate();
					viewBoard.getMainBackground().repaint();
				
			}else{
				if(e.getSource() instanceof SpellButtons&& Click1==viewBoard.getActivateSpell()){
				try{
					Click2=(SpellButtons)e.getSource();
					int index= viewBoard.getSpellbuttons().indexOf(Click2);
					String name= viewBoard.getSpellbuttons().get(index).getLocationName();
					SpellCard spell= MainBoard.getActivePlayer().getField().getSpellArea().get(index);
					 switch(name){
						case "Card Destruction":
							System.out.println(Card.getBoard().getActivePlayer().getField().getMonstersArea());
							CardDestruction c=(CardDestruction)spell;
							CardDestruction cd=(CardDestruction)spell;
							MainBoard.getActivePlayer().activateSpell(cd,null);
							updateViewBoard();
						
                            
                            System.out.println(Card.getBoard().getActivePlayer().getField().getMonstersArea());
							;break;
						case("Change Of Heart"):
						
							ArrayList<JButton> temp=new ArrayList<JButton>();
							//System.out.println(MainBoard.getOpponentPlayer().getField().getMonstersArea());
								for(int i=0;i<MainBoard.getOpponentPlayer().getField().getMonstersArea().size();i++){
				
							/*String name2=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName();		
						     
							CardsImages c2=new CardsImages(name2 );
						    JLabel back =c2.getDeck();
						    */
						    String name2=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName();
							JLabel back=null;
							if(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getMode().equals(Mode.ATTACK)){
							
								
						     
							CardsImages c2=new CardsImages(name2 );
						     back =c2.getDeck();
							}else{
								CardsImages c2=new CardsImages("Defence");
							     back =c2.getDeck();
							}
						    back.setSize(80,117);
						    JButton b= new JButton("kl");
						    
						    b.setSize(80,120);
						    b.setLocation(70,hieght);
						    b.setLayout(null);
						    b.add(back);
						    temp.add(b);
						    
						    framepanel.add(b);
						    hieght+=130;
							}
								Target.revalidate();
								Target.repaint();
							Target.setVisible(true);
							for(int i=0;i<temp.size();i++){
							 temp.get(i).addMouseListener(new MouseListener() {
								
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
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
								JButton b= (JButton) e.getSource();
								int index= temp.indexOf(b);
								String name=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(index).getName();
								MonsterCard m=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(index);
								ChangeOfHeart ch=(ChangeOfHeart)spell;
								MainBoard.getActivePlayer().activateSpell(ch,m);
								updateViewBoard();
							
							for(int i=0;i<temp.size();i++){
									Container c= temp.get(i).getParent();
									c.remove(temp.get(i));
									c.revalidate();
									c.repaint();
								}
								hieght=0;
								Target.revalidate();
								Target.repaint();
								Target.setVisible(false);
								}
							});
							}
						
						
							;break;
						case"Dark Hole":
							DarkHole dh=(DarkHole)spell;
						MainBoard.getActivePlayer().activateSpell(dh,null);
					
						updateViewBoard();
						
						;break;
						case"Graceful Dice":
							GracefulDice g=(GracefulDice)spell;
							MainBoard.getActivePlayer().activateSpell(g,null);
							updateViewBoard();
							;break;
						case"Harpie's Feather Duster":
							HarpieFeatherDuster hp=(HarpieFeatherDuster)spell;
							MainBoard.getActivePlayer().activateSpell(hp,null);
							
					      updateViewBoard();
					  
							;break;
						case"Heavy Storm":
							HeavyStorm hs=(HeavyStorm)spell;
							MainBoard.getActivePlayer().activateSpell(hs,null);
							
							 updateViewBoard();
					      
					          ;break;
						case "Mage Power":
							ArrayList<JButton> temp1=new ArrayList<JButton>();
							//System.out.println(MainBoard.getOpponentPlayer().getField().getMonstersArea());
								for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
				
							/*String name2=MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName();		
						     
							CardsImages c2=new CardsImages(name2 );
						    JLabel back =c2.getDeck();
						    */
									String name2=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName();
									JLabel back=null;
									if(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getMode().equals(Mode.ATTACK)){
									
										
								     
									CardsImages c2=new CardsImages(name2 );
								     back =c2.getDeck();
									}else{
										CardsImages c2=new CardsImages("Defence");
									     back =c2.getDeck();
									}
						    back.setSize(80,117);
						    JButton b= new JButton("kl");
						    
						    b.setSize(80,120);
						    b.setLocation(70,hieght);
						    b.setLayout(null);
						    b.add(back);
						    temp1.add(b);
						    framepanel.add(b);
						    hieght+=130;
							}
								Target.revalidate();
								Target.repaint();
							Target.setVisible(true);
							for(int i=0;i<temp1.size();i++){
							 temp1.get(i).addMouseListener(new MouseListener() {
								
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
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
								JButton b= (JButton) e.getSource();
								int index= temp1.indexOf(b);
								String name=MainBoard.getActivePlayer().getField().getMonstersArea().get(index).getName();
								MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(index);
								for(int i=0;i<temp1.size();i++){
									Container c= temp1.get(i).getParent();
									c.remove(temp1.get(i));
									c.revalidate();
									c.repaint();
								}
								hieght=0;
								Target.revalidate();
								Target.repaint();
								Target.setVisible(false);
								MagePower mp= (MagePower)spell;
								try{
								MainBoard.getActivePlayer().activateSpell(mp,m);
								}catch(Exception e1){
									JOptionPane.showMessageDialog(null,e1.getMessage());;
								}
								}
							});
							}
							 updateViewBoard();
						
							;break;
						case "Monster Reborn":
							MonsterReborn mr= (MonsterReborn)spell;
							MainBoard.getActivePlayer().activateSpell(mr,null);
							 updateViewBoard();
						    ;break;
						case "Pot of Greed":
							PotOfGreed pg= (PotOfGreed)spell;
							MainBoard.getActivePlayer().activateSpell(pg,null);
							if(MainBoard.getWinner()!=null){
								GameOver();
								viewBoard.setVisible(false);
								Controller c1= new Controller();
							}
							 
							for(int i=0;i<viewBoard.getHandbuttons().size();i++){
								viewBoard.getHandbuttons().get(i).removeAll();
								viewBoard.getHandbuttons().get(i).setLocationName(null);
							}
							for(int i=0;i<MainBoard.getActivePlayer().getField().getHand().size();i++){
							String s=  MainBoard.getActivePlayer().getField().getHand().get(i).getName();
							CardsImages ci= new CardsImages(s);
							viewBoard.getHandbuttons().get(i).add(ci.getDeck());
							viewBoard.getHandbuttons().get(i).setLocationName(s);
							}
						
									
							
						
						
						;break;
						case"Raigeki":
							Raigeki r=(Raigeki)spell;
							MainBoard.getActivePlayer().activateSpell(r, null);
							 updateViewBoard();
							;break;
				        }
				       ;
						viewBoard.getMainBackground().revalidate();
						viewBoard.getMainBackground().repaint();
						viewBoard.revalidate();
						viewBoard.repaint();
				}catch (RuntimeException e1) {
					
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				 finally
			      {
					 Click1 =null;
			    	 Click2 =null;
			      }		
				}else{
					if(e.getSource() instanceof MonsterButtons && Click1==viewBoard.getSwitchMode()){
					  Click2= (MonsterButtons)e.getSource();
					  int index= viewBoard.getMonsterbuttons().indexOf(Click2);
					  try{
					  MonsterCard monster= MainBoard.getActivePlayer().getField().getMonstersArea().get(index);
					MainBoard.getActivePlayer().switchMonsterMode(monster);
					if(monster.getMode().equals(Mode.ATTACK)){
						CardsImages c= new CardsImages(monster.getName());
						viewBoard.getMonsterbuttons().get(index).removeAll();
						viewBoard.getMonsterbuttons().get(index).add(c.getDeck());
						viewBoard.getMonsterbuttons().get(index).setLocationName(monster.getName());
					}else{
						CardsImages c= new CardsImages("Hatem");
						viewBoard.getMonsterbuttons().get(index).removeAll();
						viewBoard.getMonsterbuttons().get(index).add(c.getDeck());
									viewBoard.getMonsterbuttons().get(index).setLocationName(monster.getName());
					}
					}catch (RuntimeException e1) {
						
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}
					 finally
				      {
						 Click1 =null;
				    	 Click2 =null;
				      }		
					
					}
					
				}
				viewBoard.getMonsterbuttons().get(index).revalidate();
				viewBoard.getMonsterbuttons().get(index).repaint();
				viewBoard.getMainBackground().revalidate();
				viewBoard.getMainBackground().repaint();
				viewBoard.revalidate();
				viewBoard.repaint();
			}
			 if(e.getSource() instanceof PlayerButtons){  
				
				 if((e.getSource()==SummonMonsters) && (Click1 instanceof HandButtons)){
					
				
						 
						f.setVisible(false);
						 Click2=(PlayerButtons) e.getSource();
							int index=viewBoard.getHandbuttons().indexOf(Click1);
							MonsterCard monster =(MonsterCard) MainBoard.getActivePlayer().getField().getHand().get(index);
							if(monster.getLevel()<=4){
								try{
							MainBoard.getActivePlayer().summonMonster(monster);
							
							String s= viewBoard.getHandbuttons().get(index).getLocationName();
							int location= viewBoard.getHandbuttons().get(index).getLocationIndex();
							CardsImages c= new CardsImages(s);
							JLabel Hatem= c.getDeck();
							for(int i=0;i<5;i++){
								if(viewBoard.getMonsterbuttons().get(i).getLocationName()==null){
							viewBoard.getMonsterbuttons().get(i).add(Hatem);
							viewBoard.getMonsterbuttons().get(i).setLocationName(s);
							viewBoard.getMonsterbuttons().get(i).revalidate();
							viewBoard.getMonsterbuttons().get(i).repaint();
							break;
								}
							}
								}catch (RuntimeException e1) {
									JOptionPane.showMessageDialog(null,e1.getMessage());
								}
								 finally
							      {
									 Click1 =null;
							    	 Click2 =null;
							    	 Click3=null;
							    	 Click4=null;
							      }
							updateViewBoard();
							}else{
								if(monster.getLevel()==5||monster.getLevel()==6){
								
									ArrayList<JButton> temp=new ArrayList<JButton>();
									for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
										
										String name2=MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName();		
									     
										CardsImages c2=new CardsImages(name2 );
									    JLabel back =c2.getDeck();
									    back.setSize(80,117);
									    JButton b= new JButton(name2);
									    
									    b.setSize(80,120);
									    b.setLocation(100,hieght);
									    b.setLayout(null);
									    JLabel bc=new JLabel(new ImageIcon("yugioh-netflix.jpg"));
									    bc.setSize(240,700);
									    framepanel.add(bc);
									    framepanel.setOpaque(true);
									    b.add(back);
									    bc.add(b);
									    temp.add(b);
									   
									   // Target.setLocationByPlatform(true);
									    hieght+=130;
										}
									try{
									if(MainBoard.getActivePlayer().getField().getMonstersArea().size()<1){
									throw new NoNeededSacrficesFound("This Monster needed one Monster to sacrfice");
									}
										Target.revalidate();
									Target.repaint();
										Target.setVisible(true);
									}catch(RuntimeException e3){
										JOptionPane.showMessageDialog(null,e3.getMessage());
									}
									finally{
										
										Click1=null;
										Click2=null;
										Click3=null;
										Click4=null;
									}
									
									
										for(int i=0;i<temp.size();i++){
											 temp.get(i).addMouseListener(new MouseListener() {
												
											
												public void mouseReleased(MouseEvent e) {
													// TODO Auto-generated method stub
													
												}
												
												@Override
												public void mousePressed(MouseEvent e) {
													// TODO Auto-generated method stub
													
												}
												
												@Override
												public void mouseExited(MouseEvent e) {
													// TODO Auto-generated method stub
													
												}
												
												@Override
												public void mouseEntered(MouseEvent e) {
													// TODO Auto-generated method stub
													
												}
												
												@Override
												public void mouseClicked(MouseEvent e) {
												JButton b= (JButton) e.getSource();
												
												String name=b.getText();
												
												
											
												for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
											    
												if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName().equals(name)){
													  
													MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(i);
													
												ArrayList<MonsterCard> sacrifices=new ArrayList<MonsterCard>();
												sacrifices.add(m);
												try{
												MainBoard.getActivePlayer().summonMonster(monster, sacrifices);
												}catch (RuntimeException e1) {
													JOptionPane.showMessageDialog(null,e1.getMessage());
												}
												 finally
											      {
													 Click1 =null;
											    	 Click2 =null;
											    	 Click3=null;
											    	 Click4=null;
											      }
												break;
												}}
												for(int i=0;i<temp.size();i++){
													Container c= temp.get(i).getParent();
													c.remove(temp.get(i));
													c.revalidate();
													c.repaint();
												}
												hieght=0;
												Target.revalidate();
												Target.repaint();
												Target.setVisible(false);
												for(int index1=0;index1<viewBoard.getMonsterbuttons().size();index1++){
												if(viewBoard.getMonsterbuttons().get(index1).getLocationName()!=null){
													
													if(viewBoard.getMonsterbuttons().get(index1).getLocationName().equals(name)){	
							              		       CardsImages c1=new CardsImages(name);
							              		       viewBoard.getGraveyard().add(c1.getDeck(),BorderLayout.CENTER);
														viewBoard.getMonsterbuttons().get(index1).removeAll();
							              		viewBoard.getMonsterbuttons().get(index1).setLocationName(monster.getName());
												CardsImages c=new CardsImages(monster.getName());
												viewBoard.getMonsterbuttons().get(index1).add(c.getDeck(),BorderLayout.CENTER);
												viewBoard.getMonsterbuttons().get(index1).revalidate();
												viewBoard.getMonsterbuttons().get(index1).repaint();
												break;
													}
													}
												}
												}
											});
											}
										updateViewBoard();
										Target.revalidate();
										Target.repaint();
									
								}else{
									if(monster.getLevel()==7 || monster.getLevel()==8){
										
										
										ArrayList<JButton> temp=new ArrayList<JButton>();
										for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
											
											String name2=MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName();		
										     
											CardsImages c2=new CardsImages(name2 );
										    JLabel back =c2.getDeck();
										    back.setSize(80,117);
										    JButton b= new JButton(name2);
										    
										    b.setSize(80,120);
										    b.setLocation(90,hieght);
										    b.setLayout(null);
										    JLabel bc=new JLabel(new ImageIcon("yugioh-netflix.jpg"));
										    bc.setSize(240,700);
										    framepanel.add(bc);
										   // framepanel.setOpaque(true);
										    b.add(back);
										    bc.add(b);
										    temp.add(b);
										   
										   // Target.setLocationByPlatform(true);
										    hieght+=130;
											}
										try{
										if(MainBoard.getActivePlayer().getField().getMonstersArea().size()<2){
											throw new NoNeededSacrficesFound("This Monster needed Two Monster to sacrfice");
											}
											
										Target.revalidate();
										Target.repaint();
											Target.setVisible(true);
										}catch(RuntimeException e4){
											JOptionPane.showMessageDialog(null,e4.getMessage());
										}
										finally{
											Click1=null;
											Click2=null;
											Click3=null;
											Click4=null;
										}
											for(int i=0;i<temp.size();i++){
												 temp.get(i).addMouseListener(new MouseListener() {
													
												
													public void mouseReleased(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mousePressed(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mouseExited(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mouseEntered(MouseEvent e) {
														// TODO Auto-generated method stub
														
													}
													
													@Override
													public void mouseClicked(MouseEvent e) {
														
														
														if(Click3==null){
													JButton b= (JButton) e.getSource();
													Click3=b;
													 name=b.getText();
													
													
												
													for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
												    
													if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName().equals(name)){
														  
														MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(i);
														
													
													sacrifices.add(m);
													
													
													break;
													}}
													
													
													}else{
														Click4=(JButton) e.getSource();
														String name1=Click4.getText();
														for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
													    
														if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName().equals(name1)){
															  
															MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(i);
														sacrifices.add(m);
													break;
														}}
														for(int i=0;i<temp.size();i++){
															Container c= temp.get(i).getParent();
															c.remove(temp.get(i));
															c.revalidate();
															c.repaint();
														}
														hieght=0;
														Target.revalidate();
														Target.repaint();
														Target.setVisible(false);
														try{
														MainBoard.getActivePlayer().summonMonster(monster, sacrifices);
														}catch (RuntimeException e1) {
															JOptionPane.showMessageDialog(null,e1.getMessage());
														}
														 finally
													      {
															 Click1 =null;
													    	 Click2 =null;
													    	 Click3=null;
													    	 Click4=null;
													      }
														
														for(int index1=0;index1<viewBoard.getMonsterbuttons().size();index1++){
															if(viewBoard.getMonsterbuttons().get(index1).getLocationName()!=null){
																
																if(viewBoard.getMonsterbuttons().get(index1).getLocationName().equals(name)){	
										              		       CardsImages c1=new CardsImages(name);
										              		       viewBoard.getGraveyard().add(c1.getDeck(),BorderLayout.CENTER);
																	viewBoard.getMonsterbuttons().get(index1).removeAll();
										              		
															break;
																}
																}
															}
														for(int index1=0;index1<viewBoard.getMonsterbuttons().size();index1++){
															if(viewBoard.getMonsterbuttons().get(index1).getLocationName()!=null){
																
																if(viewBoard.getMonsterbuttons().get(index1).getLocationName().equals(name1)){	
										              		       CardsImages c1=new CardsImages(name1);
										              		       viewBoard.getGraveyard().add(c1.getDeck(),BorderLayout.CENTER);
																	viewBoard.getMonsterbuttons().get(index1).removeAll();
										              		viewBoard.getMonsterbuttons().get(index1).setLocationName(monster.getName());
															CardsImages c=new CardsImages(monster.getName());
															viewBoard.getMonsterbuttons().get(index1).add(c.getDeck(),BorderLayout.CENTER);
															viewBoard.getGraveyard().revalidate();
															viewBoard.getGraveyard().repaint();
															break;
																}
																}
															}
													}
													}
												});
													updateViewBoard();
												 Target.revalidate();
													Target.repaint();
													viewBoard.getMonsterbuttons().get(i).revalidate();
													viewBoard.getMonsterbuttons().get(i).repaint();
													viewBoard.revalidate();
													viewBoard.repaint();
													viewBoard.getMainBackground().revalidate();
													viewBoard.getMainBackground().repaint();
												}
								
									}
								}
							}
						
							
							
							
							viewBoard.revalidate();
							viewBoard.repaint();
							viewBoard.getMainBackground().revalidate();
							viewBoard.getMainBackground().repaint();
							
							
						}else{
							if((e.getSource()==SetMonsters)&&(Click1 instanceof HandButtons)){
							
									 
									f.setVisible(false);
									 Click2=(PlayerButtons) e.getSource();
										int index=viewBoard.getHandbuttons().indexOf(Click1);
										MonsterCard monster =(MonsterCard) MainBoard.getActivePlayer().getField().getHand().get(index);
										if(monster.getLevel()<=4){
											try{
										MainBoard.getActivePlayer().setMonster(monster);
										
										String s= viewBoard.getHandbuttons().get(index).getLocationName();
										int location= viewBoard.getHandbuttons().get(index).getLocationIndex();
										CardsImages c= new CardsImages("Hatem");
										JLabel Hatem= c.getDeck();
										for(int i=0;i<5;i++){
											if(viewBoard.getMonsterbuttons().get(i).getLocationName()==null){
										viewBoard.getMonsterbuttons().get(i).add(Hatem);
										viewBoard.getMonsterbuttons().get(i).setLocationName(s);
										viewBoard.getMonsterbuttons().get(i).revalidate();
										viewBoard.getMonsterbuttons().get(i).repaint();
										break;
											}
										}
										}catch (RuntimeException e1) {
											JOptionPane.showMessageDialog(null,e1.getMessage());
										}
										 finally
									      {
											 Click1 =null;
									    	 Click2 =null;
									    	 Click3=null;
									    	 Click4=null;
									      }
							
										}else{
											if(monster.getLevel()==5||monster.getLevel()==6){
												ArrayList<JButton> temp=new ArrayList<JButton>();
												for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
													
													String name2=MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName();		
												     
													CardsImages c2=new CardsImages(name2 );
												    JLabel back =c2.getDeck();
												    back.setSize(80,117);
												    JButton b= new JButton(name2);
												    
												    b.setSize(80,120);
												    b.setLocation(100,hieght);
												    b.setLayout(null);
												    JLabel bc=new JLabel(new ImageIcon("yugioh-netflix.jpg"));
												    bc.setSize(240,700);
												    framepanel.add(bc);
												    framepanel.setOpaque(true);
												    b.add(back);
												    bc.add(b);
												    temp.add(b);
												   
												   // Target.setLocationByPlatform(true);
												    hieght+=130;
													}
												try{
												if(MainBoard.getActivePlayer().getField().getMonstersArea().size()<1){
												throw new NoNeededSacrficesFound("This Monster needed one Monster to sacrfice");
												}
													Target.revalidate();
												Target.repaint();
													Target.setVisible(true);
												}catch(RuntimeException e3){
													JOptionPane.showMessageDialog(null,e3.getMessage());
												}finally{
													Click1=null;
													Click2=null;
													Click3=null;
													Click4=null;
												}
												
													for(int i=0;i<temp.size();i++){
														 temp.get(i).addMouseListener(new MouseListener() {
															
														
															public void mouseReleased(MouseEvent e) {
																// TODO Auto-generated method stub
																
															}
															
															@Override
															public void mousePressed(MouseEvent e) {
																// TODO Auto-generated method stub
																
															}
															
															@Override
															public void mouseExited(MouseEvent e) {
																// TODO Auto-generated method stub
																
															}
															
															@Override
															public void mouseEntered(MouseEvent e) {
																// TODO Auto-generated method stub
																
															}
															
															@Override
															public void mouseClicked(MouseEvent e) {
															JButton b= (JButton) e.getSource();
															
															String name=b.getText();
															
															
														
															for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
														    
															if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName().equals(name)){
																  
																MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(i);
																
															ArrayList<MonsterCard> sacrifices=new ArrayList<MonsterCard>();
															sacrifices.add(m);
															try{
															MainBoard.getActivePlayer().setMonster(monster, sacrifices);
															}catch (RuntimeException e1) {
																JOptionPane.showMessageDialog(null,e1.getMessage());
															}
															 finally
														      {
																 Click1 =null;
														    	 Click2 =null;
														    	 Click3=null;
														    	 Click4=null;
														      }
															break;
															}}
															for(int i=0;i<temp.size();i++){
																Container c= temp.get(i).getParent();
																c.remove(temp.get(i));
																c.revalidate();
																c.repaint();
															}
															hieght=0;
															Target.revalidate();
															Target.repaint();
															Target.setVisible(false);
													 updateViewBoard();
															}
														});
														}
													Target.revalidate();
													Target.repaint();
												
								
											}else{
												if(monster.getLevel()==7 || monster.getLevel()==8){
													try{
													if(MainBoard.getActivePlayer().getField().getMonstersArea().size()<2){
														throw new NoNeededSacrficesFound("This Monster needed one Monster to sacrfice");
													}
													if(MainBoard.getActivePlayer().getField().getMonstersArea().size()>=5){
														throw new NoMonsterSpaceException();
													}
													ArrayList<JButton> temp=new ArrayList<JButton>();
													for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
														
														String name2=MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName();		
													     
														CardsImages c2=new CardsImages("Hatem");
													    JLabel back =c2.getDeck();
													    back.setSize(80,117);
													    JButton b= new JButton(name2);
													    
													    b.setSize(80,120);
													    b.setLocation(90,hieght);
													    b.setLayout(null);
													    JLabel bc=new JLabel(new ImageIcon("yugioh-netflix.jpg"));
													    bc.setSize(240,700);
													    framepanel.add(bc);
													   // framepanel.setOpaque(true);
													    b.add(back);
													    bc.add(b);
													    temp.add(b);
													   
													   // Target.setLocationByPlatform(true);
													    hieght+=130;
														}
													Target.revalidate();
													Target.repaint();
														Target.setVisible(true);
														for(int i=0;i<temp.size();i++){
															 temp.get(i).addMouseListener(new MouseListener() {
																
															
																public void mouseReleased(MouseEvent e) {
																	// TODO Auto-generated method stub
																	
																}
																
																@Override
																public void mousePressed(MouseEvent e) {
																	// TODO Auto-generated method stub
																	
																}
																
																@Override
																public void mouseExited(MouseEvent e) {
																	// TODO Auto-generated method stub
																	
																}
																
																@Override
																public void mouseEntered(MouseEvent e) {
																	// TODO Auto-generated method stub
																	
																}
																
																@Override
																public void mouseClicked(MouseEvent e) {
																	
																	
																	if(Click3==null){
																JButton b= (JButton) e.getSource();
																Click3=b;
																 name=b.getText();
																
																
															
																for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
															    
																if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName().equals(name)){
																	  
																	MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(i);
																	
																
																sacrifices.add(m);
																
																
																break;
																}}
																
																
																}else{
																	Click4=(JButton) e.getSource();
																	String name1=Click4.getText();
																	for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
																    
																	if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName().equals(name1)){
																		  
																		MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(i);
																	sacrifices.add(m);
																break;
																	}}
																	for(int i=0;i<temp.size();i++){
																		Container c= temp.get(i).getParent();
																		c.remove(temp.get(i));
																		c.revalidate();
																		c.repaint();
																	}
																	hieght=0;
																	Target.revalidate();
																	Target.repaint();
																	Target.setVisible(false);
																	MainBoard.getActivePlayer().setMonster(monster, sacrifices);
																	for(int index1=0;index1<viewBoard.getMonsterbuttons().size();index1++){
																		if(viewBoard.getMonsterbuttons().get(index1).getLocationName()!=null){
																			
																			if(viewBoard.getMonsterbuttons().get(index1).getLocationName().equals(name)){	
													              		       CardsImages c1=new CardsImages(name);
													              		       viewBoard.getGraveyard().add(c1.getDeck(),BorderLayout.CENTER);
																				viewBoard.getMonsterbuttons().get(index1).removeAll();
													              		
																		break;
																			}
																			}
																		}
																	for(int index1=0;index1<viewBoard.getMonsterbuttons().size();index1++){
																		if(viewBoard.getMonsterbuttons().get(index1).getLocationName()!=null){
																			
																			if(viewBoard.getMonsterbuttons().get(index1).getLocationName().equals(name1)){	
													              		       CardsImages c1=new CardsImages(name1);
													              		       viewBoard.getGraveyard().add(c1.getDeck(),BorderLayout.CENTER);
																				viewBoard.getMonsterbuttons().get(index1).removeAll();
													              		viewBoard.getMonsterbuttons().get(index1).setLocationName(monster.getName());
																		CardsImages c=new CardsImages(monster.getName());
																		viewBoard.getMonsterbuttons().get(index1).add(c.getDeck(),BorderLayout.CENTER);
																		viewBoard.getGraveyard().revalidate();
																		viewBoard.getGraveyard().repaint();
																		break;
																			}
																			}
																		}
																}
																}
															});
																
															 Target.revalidate();
																Target.repaint();
																viewBoard.getMonsterbuttons().get(i).revalidate();
																viewBoard.getMonsterbuttons().get(i).repaint();
																viewBoard.revalidate();
																viewBoard.repaint();
																viewBoard.getMainBackground().revalidate();
																viewBoard.getMainBackground().repaint();
															}
												}catch (RuntimeException e1) {
													JOptionPane.showMessageDialog(null,e1.getMessage());
												}
												 finally
											      {
													 Click1 =null;
											    	 Click2 =null;
											    	 Click3=null;
											    	 Click4=null;
											      }
									
												}
											}
										}
										viewBoard.getHandbuttons().get(index).setLocationName(null);
										viewBoard.getHandbuttons().get(index).removeAll();
										for(int i=index;i<viewBoard.getHandbuttons().size();i++){
											if(viewBoard.getHandbuttons().get(i+1).getLocationName()!=null){
											String s1=viewBoard.getHandbuttons().get(i+1).getLocationName();
											CardsImages c1= new CardsImages(s1);
											JLabel temps=c1.getDeck();
											viewBoard.getHandbuttons().get(i).add(temps);
											viewBoard.getHandbuttons().get(i).setLocationName(s1);
											viewBoard.getHandbuttons().get(i+1).removeAll();
											viewBoard.getHandbuttons().get(i+1).setLocationName(null);
											JLabel LargeVeiw=new JLabel();
										 	viewBoard.getHandbuttons().get(i).addMouseListener(new MouseListener() {
							    			 	
							    		
								    			
							    				public void mouseReleased(MouseEvent arg0) {
							    					
							    					
							    				}
							    			
							    				public void mousePressed(MouseEvent arg0) {
							    					
							    					
							    				}
							    		
							    				public void mouseExited(MouseEvent e) {
							    					 HandButtons b = (HandButtons) e.getSource();
							    					 b.setLocation(b.getLocationIndex(),900);
							    					 LargeVeiw.setEnabled(false);
							    					return;
							    			//LargeVeiw.setIcon(new ImageIcon("C:\\Users\\Kennedy\\Desktop\\YUGIOH image icons\\ed6f7a3b3c9dc081b4216409c2319.jpg"));
							    					
							    					
							    				}
							    				
							    				@Override
							    				public void mouseEntered(MouseEvent e) {
							    				
							    				 HandButtons b = (HandButtons) e.getSource();
							    				 String s= b.getLocationName();
							    				
							    				
							    					 
							    				 if(s!=null){
							    						 b.setLocation(b.getLocationIndex(),880);
							    						 switch(s)
							    						   {
							    						   case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("/Red-Eyes Black Dragon.png")); break;
							    						    case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("/Blue-Eyes White Dragon.png")); break;
							    							case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("/CosmoQueen.png")); break;
							    							case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("/Dark Magician.png"));break;
							    							case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("/Gaia The Fierce Knight.png"));break;
							    							case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("/Summoned Skull.png"));break;
							    							case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("/Dark Magician Girl.png"));break;
							    							case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("/Curse Of Dragon.png"));break;
							    							case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("/Alexandrite Dragon.png"));break;
							    							case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("/Vorse Raider.png"));break;
							    							case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("/Gemini Elf.png"));break;
							    							case "F-ence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("/Fence Guard Apprentice.png"));break;
							    							case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("/Beta The Magnet Warrior.png"));break;
							    							case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("/Alligator Sword.png"));break;
							    							case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("/Gamma The Magnet Warrior.png"));break;
							    							case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("/Celtic Guardian.png"));break;
							    							case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("/Alpha The Magnet Warrior.png"));break;
							    							case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("/Harpie LadLargeVeiw.png"));break;
							    							case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("/Big Shield Gardna.png"));break;
							    							case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("/Witty Phantom.png"));break;
							    							case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("/Baby Dragon.png"));break;
							    							case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("/Cyber Jar.png"));break;
							    							case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("/Clown Zombie.png"));break;
							    							case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("/Time Wizard.png"));break;
							    							case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("/Man-Eater Bug.png"));break;
							    							case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("/Kuriboh.png"));break;
							    							case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("/Mokey Mokey.png"));break;
							    							case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("/Fence Guard Dragon.jpg"));break;
							    							case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("/Fence Guard Magician.jpg"));break;
							    							case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("/Fence Guard.jpg"));break;
							    							case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("/Card Destruction.png"));break;
							    							case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("/Change Of Heart.png"));break;
							    							case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("/Dark Hole.png"));break;
							    							case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("/Graceful Dice.png"));break;
							    							case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("/Harpie's Feather Duster.png"));break;
							    							case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("/Heavy Storm.png"));break;
							    							case "Mage Power": LargeVeiw.setIcon(new ImageIcon("/Mage Power.png"));break;
							    							case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("/Monster Reborn.png"));break;
							    							case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("/Pot of Greed.png"));break;
							    							case "Raigeki": LargeVeiw.setIcon(new ImageIcon("/Raigeki.png"));break;
							    						   
							    						   }

							    	    					LargeVeiw.setEnabled(true);
							                     
							    				}	 
							    				
							    				
							    				}
							    			
							    				
							    				public void mouseClicked(MouseEvent e) {
							    					
							    					
							    				};
							    				 
							    			});
							    			
											}else{
												break;
											}
											viewBoard.getHandbuttons().get(i).revalidate();
											viewBoard.getHandbuttons().get(i).repaint();
											
										}
										
										viewBoard.revalidate();
										viewBoard.repaint();
										viewBoard.getMainBackground().revalidate();
										viewBoard.getMainBackground().repaint();
										
									
							}else{
							if((e.getSource()==SetSpell)&& Click1 instanceof HandButtons){
								 try{
										f.setVisible(false);
										 Click2=(PlayerButtons) e.getSource();
											int index=viewBoard.getHandbuttons().indexOf(Click1);
											
											MainBoard.getActivePlayer().setSpell((SpellCard)MainBoard.getActivePlayer().getField().getHand().get(index));
											String s= viewBoard.getHandbuttons().get(index).getLocationName();
											int location= viewBoard.getHandbuttons().get(index).getLocationIndex();
											CardsImages c= new CardsImages("Hatem");
											JLabel Hatem= c.getDeck();
											for(int i=0;i<5;i++){
											if(viewBoard.getSpellbuttons().get(i).getLocationName()==null){	
											viewBoard.getSpellbuttons().get(i).add(Hatem);
											viewBoard.getSpellbuttons().get(i).setLocationName(s);
											break;
											}
											}
											viewBoard.getHandbuttons().get(index).setLocationName(null);
											viewBoard.getHandbuttons().get(index).removeAll();
											for(int i=index;i<viewBoard.getHandbuttons().size();i++){
												if(viewBoard.getHandbuttons().get(i+1).getLocationName()!=null){
												String s1=viewBoard.getHandbuttons().get(i+1).getLocationName();
												CardsImages c1= new CardsImages(s1);
												JLabel temps=c1.getDeck();
												viewBoard.getHandbuttons().get(i).add(temps);
												viewBoard.getHandbuttons().get(i).setLocationName(s1);
												viewBoard.getHandbuttons().get(i+1).removeAll();
												viewBoard.getHandbuttons().get(i+1).setLocationName(null);
												JLabel LargeVeiw=new JLabel();
											 	viewBoard.getHandbuttons().get(i).addMouseListener(new MouseListener() {
								    				
								    				
									    			
								    				public void mouseReleased(MouseEvent arg0) {
								    					
								    					
								    				}
								    			
								    				public void mousePressed(MouseEvent arg0) {
								    					
								    					
								    				}
								    		
								    				public void mouseExited(MouseEvent e) {
								    					 HandButtons b = (HandButtons) e.getSource();
								    					 b.setLocation(b.getLocationIndex(),900);
								    					 LargeVeiw.setEnabled(false);
								    					return;
								    			//LargeVeiw.setIcon(new ImageIcon("C:\\Users\\Kennedy\\Desktop\\YUGIOH image icons\\ed6f7a3b3c9dc081b4216409c2319.jpg"));
								    					
								    					
								    				}
								    				
								    				@Override
								    				public void mouseEntered(MouseEvent e) {
								    				
								    				 HandButtons b = (HandButtons) e.getSource();
								    				 String s= b.getLocationName();
								    				
								    				
								    					 
								    				 if(s!=null){
								    						 b.setLocation(b.getLocationIndex(),880);
								    						 switch(s)
								    						   {
								    						    
								    						    case "Red-Eyes Black Dragon" :LargeVeiw.setName("Red-Eyes Black Dragon"); LargeVeiw.setIcon(new ImageIcon("/Red-Eyes Black Dragon.png")); break;
								    							case "Blue-Eyes White Dragon" : LargeVeiw.setIcon(new ImageIcon("/Blue-Eyes White Dragon.png")); break;
								    							case "Cosmo Queen" : LargeVeiw.setIcon(new ImageIcon("/CosmoQueen.png")); break;
								    							case "Dark Magician" : LargeVeiw.setIcon(new ImageIcon("/Dark Magician.png"));break;
								    							case "Gaia The Fierce Knight" : LargeVeiw.setIcon(new ImageIcon("/Gaia The Fierce Knight.png"));break;
								    							case "Summoned Skull" : LargeVeiw.setIcon(new ImageIcon("/Summoned Skull.png"));break;
								    							case "Dark Magician Girl" : LargeVeiw.setIcon(new ImageIcon("/Dark Magician Girl.png"));break;
								    							case "Curse Of Dragon" : LargeVeiw.setIcon(new ImageIcon("/Curse Of Dragon.png"));break;
								    							case "Alexandrite Dragon" : LargeVeiw.setIcon(new ImageIcon("/Alexandrite Dragon.png"));break;
								    							case "Vorse Raider" : LargeVeiw.setIcon(new ImageIcon("/Vorse Raider.png"));break;
								    							case "Gemini Elf" : LargeVeiw.setIcon(new ImageIcon("/Gemini Elf.png"));break;
								    							case "Fence Guard Apprentice" : LargeVeiw.setIcon(new ImageIcon("/Fence Guard Apprentice.png"));break;
								    							case "Beta The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("/Beta The Magnet Warrior.png"));break;
								    							case "Alligator Sword" : LargeVeiw.setIcon(new ImageIcon("/Alligator Sword.png"));break;
								    							case "Gamma The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("/Gamma The Magnet Warrior.png"));break;
								    							case "Celtic Guardian" : LargeVeiw.setIcon(new ImageIcon("/Celtic Guardian.png"));break;
								    							case "Alpha The Magnet Warrior" : LargeVeiw.setIcon(new ImageIcon("/Alpha The Magnet Warrior.png"));break;
								    							case "Harpie Lady" : LargeVeiw.setIcon(new ImageIcon("/Harpie LadLargeVeiw.png"));break;
								    							case "Big Shield Gardna" : LargeVeiw.setIcon(new ImageIcon("/Big Shield Gardna.png"));break;
								    							case "Witty Phantom" : LargeVeiw.setIcon(new ImageIcon("/Witty Phantom.png"));break;
								    							case "Baby Dragon" : LargeVeiw.setIcon(new ImageIcon("/Baby Dragon.png"));break;
								    							case "Cyber Jar" : LargeVeiw.setIcon(new ImageIcon("/Cyber Jar.png"));break;
								    							case "Clown Zombie" : LargeVeiw.setIcon(new ImageIcon("/Clown Zombie.png"));break;
								    							case "Time Wizard" : LargeVeiw.setIcon(new ImageIcon("/Time Wizard.png"));break;
								    							case "Man-Eater Bug" : LargeVeiw.setIcon(new ImageIcon("/Man-Eater Bug.png"));break;
								    							case "Kuriboh" : LargeVeiw.setIcon(new ImageIcon("/Kuriboh.png"));break;
								    							case "Mokey Mokey" : LargeVeiw.setIcon(new ImageIcon("/Mokey Mokey.png"));break;
								    							case "Fence Guard Dragon": LargeVeiw.setIcon(new ImageIcon("/Fence Guard Dragon.jpg"));break;
								    							case "Fence Guard Magician": LargeVeiw.setIcon(new ImageIcon("/Fence Guard Magician.jpg"));break;
								    							case "Fence Guard": LargeVeiw.setIcon(new ImageIcon("/Fence Guard.jpg"));break;
								    							case "Card Destruction": LargeVeiw.setIcon(new ImageIcon("/Card Destruction.png"));break;
								    							case "Change Of Heart": LargeVeiw.setIcon(new ImageIcon("/Change Of Heart.png"));break;
								    							case "Dark Hole": LargeVeiw.setIcon(new ImageIcon("/Dark Hole.png"));break;
								    							case "Graceful Dice": LargeVeiw.setIcon(new ImageIcon("/Graceful Dice.png"));break;
								    							case "Harpie's Feather Duster": LargeVeiw.setIcon(new ImageIcon("/Harpie's Feather Duster.png"));break;
								    							case "Heavy Storm": LargeVeiw.setIcon(new ImageIcon("/Heavy Storm.png"));break;
								    							case "Mage Power": LargeVeiw.setIcon(new ImageIcon("/Mage Power.png"));break;
								    							case "Monster Reborn": LargeVeiw.setIcon(new ImageIcon("/Monster Reborn.png"));break;
								    							case "Pot of Greed": LargeVeiw.setIcon(new ImageIcon("/Pot of Greed.png"));break;
								    							case "Raigeki": LargeVeiw.setIcon(new ImageIcon("/Raigeki.png"));break;
								    						   
								    						   }

								    	    					LargeVeiw.setEnabled(true);
								                     
								    				}	 
								    				
								    				
								    				}
								    			
								    				
								    				public void mouseClicked(MouseEvent e) {
								    					
								    					
								    				};
								    				 
								    			});
								    			
												}else{
													break;
												}
											}
											viewBoard.revalidate();
											viewBoard.repaint();
											viewBoard.getMainBackground().revalidate();
											viewBoard.getMainBackground().repaint();
											
											}catch (RuntimeException e1) {
												JOptionPane.showMessageDialog(null,e1.getMessage());
											}
											 finally
										      {
												 Click1 =null;
										    	 Click2 =null;
										      }
							}else{
								
								if((e.getSource()==ActivateSpell)&&(Click1 instanceof HandButtons)){
									 try{

											f.setVisible(false);
											 Click2=(PlayerButtons) e.getSource();
												int index=viewBoard.getHandbuttons().indexOf(Click1);
												
							
												SpellCard spell=(SpellCard) MainBoard.getActivePlayer().getField().getHand().get(index);
												String name=viewBoard.getHandbuttons().get(index).getLocationName();
										     
												
										        switch(name){
												case "Card Destruction":
													CardDestruction cd=(CardDestruction)spell;
													MainBoard.getActivePlayer().activateSpell(cd,null);
													 updateViewBoard();
												
													;break;
												case("Change Of Heart"):
													System.out.println(Card.getBoard().getActivePlayer().getField().getMonstersArea());
													ArrayList<JButton> temp=new ArrayList<JButton>();
													//System.out.println(MainBoard.getOpponentPlayer().getField().getMonstersArea());
														for(int i=0;i<MainBoard.getOpponentPlayer().getField().getMonstersArea().size();i++){
										
													String name2=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName();		
												     
													CardsImages c2=new CardsImages(name2 );
												    JLabel back =c2.getDeck();
												    back.setSize(80,117);
												    JButton b= new JButton("kl");
												    
												    b.setSize(80,120);
												    b.setLocation(70,hieght);
												    b.setLayout(null);
												    b.add(back);
												    temp.add(b);
												    framepanel.add(b);
												    hieght+=130;
													}
														Target.revalidate();
														Target.repaint();
													Target.setVisible(true);
													for(int i=0;i<temp.size();i++){
													 temp.get(i).addMouseListener(new MouseListener() {
														
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
															// TODO Auto-generated method stub
															
														}
														
														@Override
														public void mouseEntered(MouseEvent e) {
															// TODO Auto-generated method stub
															
														}
														
														@Override
														public void mouseClicked(MouseEvent e) {
														JButton b= (JButton) e.getSource();
														int index= temp.indexOf(b);
														String name=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(index).getName();
														MonsterCard m=MainBoard.getOpponentPlayer().getField().getMonstersArea().get(index);
														ChangeOfHeart ch=(ChangeOfHeart)spell;
														MainBoard.getActivePlayer().activateSpell(ch,m);
														updateViewBoard();
														
													  System.out
															.println(MainBoard.getActivePlayer().getField().getMonstersArea());
													  System.out
															.println(MainBoard.getOpponentPlayer().getField().getMonstersArea());
														for(int i=0;i<temp.size();i++){
															Container c= temp.get(i).getParent();
															c.remove(temp.get(i));
															c.revalidate();
															c.repaint();
														}
														hieght=0;
														Target.revalidate();
														Target.repaint();
														Target.setVisible(false);
														
														
														}
													});
													}
												
													viewBoard.revalidate();
													viewBoard.repaint();
													viewBoard.getMainBackground().revalidate();
													viewBoard.getMainBackground().repaint();
													;break;
												case"Dark Hole":
													DarkHole dh=(DarkHole)spell;
												MainBoard.getActivePlayer().activateSpell(dh,null);
											
										
											   
												 updateViewBoard();
												viewBoard.revalidate();
												viewBoard.repaint();
												viewBoard.getMainBackground().revalidate();
												viewBoard.getMainBackground().repaint();
												System.out.println(Card.getBoard().getActivePlayer().getField().getMonstersArea());
												;break;
												case"Graceful Dice":
													GracefulDice gd=(GracefulDice)spell;
													MainBoard.getActivePlayer().activateSpell(gd,null);
													 updateViewBoard();
													  viewBoard.revalidate();
													  viewBoard.repaint();
														viewBoard.getMainBackground().revalidate();
														viewBoard.getMainBackground().repaint();
														
													;break;
												case"Harpie's Feather Duster":
													HarpieFeatherDuster hd= (HarpieFeatherDuster)spell;
													MainBoard.getActivePlayer().activateSpell(hd,null);
													 updateViewBoard();
													  viewBoard.revalidate();
													  viewBoard.repaint();
														viewBoard.getMainBackground().revalidate();
														viewBoard.getMainBackground().repaint();
														
													;break;
												case"Heavy Storm":
													HeavyStorm hs=(HeavyStorm)spell;
													MainBoard.getActivePlayer().activateSpell(hs,null);
													 updateViewBoard();
													  viewBoard.revalidate();
													  viewBoard.repaint();
														viewBoard.getMainBackground().revalidate();
														viewBoard.getMainBackground().repaint();
														
											          ;break;
												case "Mage Power":
													ArrayList<JButton> temp1=new ArrayList<JButton>();
													//System.out.println(MainBoard.getOpponentPlayer().getField().getMonstersArea());
														for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
										
													String name2=MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName();		
												     
													CardsImages c2=new CardsImages(name2 );
												    JLabel back =c2.getDeck();
												    back.setSize(80,117);
												    JButton b= new JButton("kl");
												    
												    b.setSize(80,120);
												    b.setLocation(70,hieght);
												    b.setLayout(null);
												    b.add(back);
												    temp1.add(b);
												    framepanel.add(b);
												    hieght+=130;
													}
														Target.revalidate();
														Target.repaint();
													Target.setVisible(true);
													for(int i=0;i<temp1.size();i++){
													 temp1.get(i).addMouseListener(new MouseListener() {
														
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
															// TODO Auto-generated method stub
															
														}
														
														@Override
														public void mouseEntered(MouseEvent e) {
															// TODO Auto-generated method stub
															
														}
														
														@Override
														public void mouseClicked(MouseEvent e) {
														JButton b= (JButton) e.getSource();
														int index= temp1.indexOf(b);
														String name=MainBoard.getActivePlayer().getField().getMonstersArea().get(index).getName();
														MonsterCard m=MainBoard.getActivePlayer().getField().getMonstersArea().get(index);
														for(int i=0;i<temp1.size();i++){
															Container c= temp1.get(i).getParent();
															c.remove(temp1.get(i));
															c.revalidate();
															c.repaint();
														}
														hieght=0;
														Target.revalidate();
														Target.repaint();
														Target.setVisible(false);
														MagePower mp=(MagePower)spell;
														MainBoard.getActivePlayer().activateSpell(mp,m);
														
														}
													});
													}
													 updateViewBoard();
													  viewBoard.revalidate();
													  viewBoard.repaint();
														viewBoard.getMainBackground().revalidate();
														viewBoard.getMainBackground().repaint();
														
													;break;
												case "Monster Reborn":
													MonsterReborn m= (MonsterReborn)spell;
													MainBoard.getActivePlayer().activateSpell(m,null);
													 updateViewBoard();
												    ;break;
												case "Pot of Greed":
								PotOfGreed pg=(PotOfGreed)spell;
													MainBoard.getActivePlayer().activateSpell(pg,null);
											updateViewBoard();
													  viewBoard.revalidate();
													  viewBoard.repaint();
														viewBoard.getMainBackground().revalidate();
														viewBoard.getMainBackground().repaint();
														
												;break;
												case"Raigeki":
													Raigeki r=(Raigeki)spell;
													MainBoard.getActivePlayer().activateSpell(r, null);
													 updateViewBoard();
													
													 viewBoard.getMainBackground().revalidate();
													    viewBoard.getMainBackground().repaint();
													    viewBoard.revalidate();
													    viewBoard.repaint();
													;break;
										        }
										        updateViewBoard();
												}catch (RuntimeException e1) {
												
													JOptionPane.showMessageDialog(null,e1.getMessage());
												}
												 finally
											      {
													 Click1 =null;
											    	 Click2 =null;
											    	 Click3=null;
											    	 Click4=null;
											      }
									
							}
							}
							}
						}
					
					 
				 }
		 
		 }  
 
		  viewBoard.getMainBackground().revalidate();
			viewBoard.getMainBackground().repaint();	
		}
	 public void GameOver (){
		 
		 try{
			 if(MainBoard.isGameOver()){
				 b=true;
				 if(MainBoard.getWinner().equals(MainBoard.getActivePlayer())){
				 throw new GameOver("The winner is "+MainBoard.getActivePlayer().getName()+ " "
				 		+ "PlayAgain");
			 }else{
				 throw new GameOver("The winner is "+MainBoard.getOpponentPlayer().getName()+" "
				 		
						 );
			 }
			 }
			 }catch(RuntimeException e){
				 JOptionPane.showMessageDialog(null,e.getMessage());
			 }
		 
		 }
	 public void updateViewBoard(){
		 if(MainBoard.getOpponentPlayer().getField().getHand().size()!=0){
			 for(int i=0;i<MainBoard.getOpponentPlayer().getField().getHand().size();i++){
				 viewBoard.getHandbuttons2().get(i).removeAll();
				 
				 viewBoard.getHandbuttons2().get(i).setLocationName(null);
				viewBoard.revalidate();
				viewBoard.repaint();
				viewBoard.getMainBackground().revalidate();
				viewBoard.getMainBackground().repaint();
				}
	}else{
		 for(int i=0;i<viewBoard.getHandbuttons2().size();i++){
			 viewBoard.getHandbuttons2().get(i).removeAll();
			 viewBoard.getHandbuttons2().get(i).setLocationName(null);
				viewBoard.revalidate();
				viewBoard.repaint();
				viewBoard.getMainBackground().revalidate();
				viewBoard.getMainBackground().repaint();
	}
	}
	if(MainBoard.getActivePlayer().getField().getHand().size()!=0){
		for(int i=0;i<viewBoard.getHandbuttons().size();i++){
			viewBoard.getHandbuttons().get(i).removeAll();
			viewBoard.getHandbuttons().get(i).setLocationName(null);
			viewBoard.revalidate();
			viewBoard.repaint();
			viewBoard.getMainBackground().revalidate();
			viewBoard.getMainBackground().repaint();
		}
			 for(int i=0;i<MainBoard.getActivePlayer().getField().getHand().size();i++){
				 				 CardsImages c=new CardsImages(MainBoard.getActivePlayer().getField().getHand().get(i).getName());
				 viewBoard.getHandbuttons().get(i).add(c.getDeck());
				 viewBoard.getHandbuttons().get(i).setLocationName(MainBoard.getActivePlayer().getField().getHand().get(i).getName());
					viewBoard.revalidate();
					viewBoard.repaint();
					viewBoard.getMainBackground().revalidate();
					viewBoard.getMainBackground().repaint();
				}
	}else{
		 for(int i=0;i<viewBoard.getHandbuttons().size();i++){
			 viewBoard.getHandbuttons().get(i).removeAll();
			 viewBoard.getHandbuttons().get(i).setLocationName(null);
				viewBoard.revalidate();
				viewBoard.repaint();
				viewBoard.getMainBackground().revalidate();
				viewBoard.getMainBackground().repaint();
			
		 }
	}
	viewBoard.revalidate();
	viewBoard.repaint();
			 if(MainBoard.getOpponentPlayer().getField().getMonstersArea().size()!=0){
				 for(int i=0;i<viewBoard.getMonsterbuttons2().size();i++){
					 viewBoard.getMonsterbuttons2().get(i).removeAll();
					 viewBoard.getMonsterbuttons2().get(i).setLocationName(null);
					 
				 }
			 for(int i=0;i<MainBoard.getOpponentPlayer().getField().getMonstersArea().size();i++){
				
				if(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getMode().equals(Mode.ATTACK)){
				 CardsImages c=new CardsImages(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName());
				 viewBoard.getMonsterbuttons2().get(i).add(c.getDeck());
				 viewBoard.getMonsterbuttons2().get(i).setLocationName(MainBoard.getOpponentPlayer().getField().getMonstersArea().get(i).getName());
				 viewBoard.getMonsterbuttons2().get(i).revalidate();
					viewBoard.getMonsterbuttons2().get(i).repaint();
				}else{
					CardsImages c=new CardsImages("Hatem");
					 viewBoard.getMonsterbuttons2().get(i).add(c.getDeck());
					 viewBoard.getMonsterbuttons2().get(i).setLocationName(null);
					 viewBoard.getMonsterbuttons2().get(i).revalidate();
						viewBoard.getMonsterbuttons2().get(i).repaint();
				}
				}
			 }else{
				 for(int i=0;i<viewBoard.getMonsterbuttons2().size();i++){
					 viewBoard.getMonsterbuttons2().get(i).removeAll();
					 viewBoard.getMonsterbuttons2().get(i).setLocationName(null);
					 viewBoard.getMonsterbuttons2().get(i).revalidate();
						viewBoard.getMonsterbuttons2().get(i).repaint();
				 }
			 }
			 if(MainBoard.getActivePlayer().getField().getMonstersArea().size()!=0){
				 for(int i=0;i<viewBoard.getMonsterbuttons().size();i++){
					 viewBoard.getMonsterbuttons().get(i).removeAll();
					 viewBoard.getMonsterbuttons().get(i).setLocationName(null);
				 }
			 for(int i=0;i<MainBoard.getActivePlayer().getField().getMonstersArea().size();i++){
				
				 if(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getMode().equals(Mode.ATTACK)){
				 CardsImages c=new CardsImages(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName());
				 viewBoard.getMonsterbuttons().get(i).add(c.getDeck());
				 viewBoard.getMonsterbuttons().get(i).setLocationName(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName());
				 viewBoard.getMonsterbuttons().get(i).revalidate();
					viewBoard.getMonsterbuttons().get(i).repaint();
				 }else{
					 CardsImages c=new CardsImages("Hatem");
					 viewBoard.getMonsterbuttons().get(i).add(c.getDeck());
					 viewBoard.getMonsterbuttons().get(i).setLocationName(MainBoard.getActivePlayer().getField().getMonstersArea().get(i).getName());
					 viewBoard.getMonsterbuttons().get(i).revalidate();
						viewBoard.getMonsterbuttons().get(i).repaint();
				 }
				}
			 }else{
				 for(int i=0;i<viewBoard.getMonsterbuttons().size();i++){
					 viewBoard.getMonsterbuttons().get(i).removeAll();	
					 viewBoard.getMonsterbuttons().get(i).setLocationName(null);
					 viewBoard.getMonsterbuttons().get(i).revalidate();
						viewBoard.getMonsterbuttons().get(i).repaint();
			 }
			 }
			 if(MainBoard.getOpponentPlayer().getField().getSpellArea().size()!=0){
				 for(int i=0;i<viewBoard.getSpellbuttons2().size();i++){
					 viewBoard.getSpellbuttons2().get(i).removeAll();
					 viewBoard.getSpellbuttons2().get(i).setLocationName(null);
				
				 }
			 for(int i=0;i<MainBoard.getOpponentPlayer().getField().getSpellArea().size();i++){
			
				 CardsImages c=new CardsImages("Hatem");
				 viewBoard.getSpellbuttons2().get(i).add(c.getDeck());
				 viewBoard.getSpellbuttons2().get(i).setLocationName(MainBoard.getOpponentPlayer().getField().getSpellArea().get(i).getName());
				 viewBoard.getSpellbuttons2().get(i).revalidate();
					viewBoard.getSpellbuttons2().get(i).repaint();
				}
			 }else{
				 for(int i=0;i<viewBoard.getSpellbuttons2().size();i++){
					 viewBoard.getSpellbuttons2().get(i).removeAll();
					 viewBoard.getSpellbuttons2().get(i).setLocationName(null);
					 viewBoard.getSpellbuttons2().get(i).revalidate();
						viewBoard.getSpellbuttons2().get(i).repaint();
			 }
			 }
			 if(MainBoard.getActivePlayer().getField().getSpellArea().size()!=0){
				
					 for(int i=0;i<viewBoard.getSpellbuttons().size();i++){
						 viewBoard.getSpellbuttons().get(i).removeAll();
						 viewBoard.getSpellbuttons().get(i).setLocationName(null);
					
					 }
			 for(int i=0;i<MainBoard.getActivePlayer().getField().getSpellArea().size();i++){
				
				 CardsImages c=new CardsImages("Hatem");
				 viewBoard.getSpellbuttons().get(i).add(c.getDeck());
				 viewBoard.getSpellbuttons().get(i).setLocationName(MainBoard.getActivePlayer().getField().getSpellArea().get(i).getName());
				 viewBoard.getSpellbuttons().get(i).revalidate();
					viewBoard.getSpellbuttons().get(i).repaint();
			 }
				}else{
					 for(int i=0;i<viewBoard.getSpellbuttons().size();i++){
						 viewBoard.getSpellbuttons().get(i).removeAll();
						 viewBoard.getSpellbuttons().get(i).setLocationName(null);
						 viewBoard.getSpellbuttons().get(i).revalidate();
							viewBoard.getSpellbuttons().get(i).repaint();
					 }
				}
			 viewBoard.getGraveyard().removeAll();
			 int size=MainBoard.getActivePlayer().getField().getGraveyard().size();
			 if(size!=0){
			
			 CardsImages c=new CardsImages(MainBoard.getActivePlayer().getField().getGraveyard().get(size-1).getName());
			 viewBoard.getGraveyard().add(c.getDeck());
			 viewBoard.getGraveyard().setLocationName(MainBoard.getActivePlayer().getField().getGraveyard().get(size-1).getName());
			 viewBoard.getGraveyard().revalidate();
			 viewBoard.getGraveyard().repaint();
			 }
			 viewBoard.getGraveyard2().removeAll();
			 int size1=MainBoard.getOpponentPlayer().getField().getGraveyard().size();
			 
			 if(size1!=0){
				
			 CardsImages c=new CardsImages(MainBoard.getOpponentPlayer().getField().getGraveyard().get(size1-1).getName());
			 viewBoard.getGraveyard2().add(c.getDeck());
			 viewBoard.getGraveyard2().setLocationName(MainBoard.getOpponentPlayer().getField().getGraveyard().get(size1-1).getName());
	         viewBoard.getGraveyard2().revalidate();
	         viewBoard.getGraveyard2().repaint();
	         
			 }
		viewBoard.getPlayer1LifePoints().setText("Player LifePoints="+MainBoard.getActivePlayer().getLifePoints());	 
		viewBoard.getPlayer2LifePoints().setText("Player LifePoints="+MainBoard.getOpponentPlayer().getLifePoints());
		
		viewBoard.getPlayerName1().setText("ActivePlayer Name :"+MainBoard.getActivePlayer().getName());
		viewBoard.getPlayerName2().setText("OpponentPlayer Name :"+MainBoard.getOpponentPlayer().getName());
		
		viewBoard.getPlayerPhase1().setText("Phase"+MainBoard.getActivePlayer().getField().getPhase());
		viewBoard.getPlayerPhase2().setText("Phase"+MainBoard.getOpponentPlayer().getField().getPhase());
		 viewBoard.getNumberCardsOfDeck2().setText("The Deck contains "+MainBoard.getOpponentPlayer().getField().getDeck().getDeck().size()+" Card");
		 viewBoard.getNumberCardsOfDeck().setText("The Deck contains "+MainBoard.getActivePlayer().getField().getDeck().getDeck().size()+" Card");
		if(MainBoard.getWinner()!=null){
			GameOver();
			viewBoard.setVisible(false);
			this.setVisible(false);
			main(null);
		}
		 
		viewBoard.revalidate();
		  viewBoard.repaint();
			viewBoard.getMainBackground().revalidate();
			viewBoard.getMainBackground().repaint();
	 }
	
	
	public MainGameBoard getViewBoard() {
		return viewBoard;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getStartgame() {
		return startgame;
	}


	public static JTextField getPlayer2() {
		return Player2;
	}

	public static JTextField getPlayer1() {
		return Player1;
	}

	public Board getMainBoard() {
		return MainBoard;
	}

	public void init()
	{
		Sound.sound1.play();
	}
	public void start()
	{
		init();
		new Thread(this).start();;
	}

	
	public void init2()
	{
		Sound2
		.sound1.play();
	}
	public void start2()
	{
		init2();
		new Thread(this).start();;
	}
	
public static void main(String[] args) {
	Controller c= new Controller();
}
@Override
public void run() {
	// TODO Auto-generated method stub
	
}


}