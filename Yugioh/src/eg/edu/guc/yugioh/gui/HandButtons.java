package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.JButton;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class HandButtons extends JButton{
	private String LocationName;
	private int LocationIndex;
	
		public int getLocationIndex() {
		return LocationIndex;
	}
	public void setLocationIndex(int locationIndex) {
		LocationIndex = locationIndex;
	}
		public HandButtons() {
			
			super();
			LocationName=null;
		
			
		}
		public String getLocationName() {
			return LocationName;
		}
		public void setLocationName(String locationName) {
			LocationName = locationName;
		}
		
	}
