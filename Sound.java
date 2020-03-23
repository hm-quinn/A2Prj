package com.mycompany.cmd;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.CheckBox;
import com.mycompany.a2.GameWorld;

public class Sound extends Command{
	private GameWorld gw;
	
	public Sound(GameWorld gw) {
		super("Sound");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(((CheckBox)ev.getComponent()).isSelected()) {
			gw.soundToggle(true);
		}
		else {
			gw.soundToggle(false);
		}
		
	}
}
