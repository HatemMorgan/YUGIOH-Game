package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MonsterButtons extends JButton {
	private String LocationName;
	public MonsterButtons()
	{
		
	super();
	LocationName=null;
	//this.setPreferredSize(new Dimension(200,300));
}
	public String getLocationName() {
		return LocationName;
	}
	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

}