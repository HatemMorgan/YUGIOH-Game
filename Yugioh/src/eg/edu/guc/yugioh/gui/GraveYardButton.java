package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class  GraveYardButton extends JButton {
	private String LocationName;
  public GraveYardButton() {

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
