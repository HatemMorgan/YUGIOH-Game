package eg.edu.guc.yugioh.gui;

import java.applet.Applet;

//import javafx.scene.media.AudioClip;

public class Sound {
	
	public final static Sound sound1 = new Sound("/sound (2).wav");
	private java.applet.AudioClip clip;
	 
	public Sound(String Filename)
	{
		try
		{
			clip = Applet.newAudioClip(Sound.class.getResource(Filename));
		}
		catch (Exception e )
		{
			e.printStackTrace();
		}
		
		
	
	}
	public java.applet.AudioClip getClip() {
		return clip;
	}
	public void setClip(java.applet.AudioClip clip) {
		this.clip = clip;
	}
	public void play() {
		try
		{
			new Thread()
			{
				public void run()
				{
					clip.play();
				}
				
			}.start();
		}
		
		catch (Exception f )
		{
			f.printStackTrace();
		}
	}
		
	}
	

