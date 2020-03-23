package com.mycompany.cmd;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ECollision extends Command {
	private GameWorld gw;
	
	public ECollision(GameWorld gw) {
		super("Collide with Energy Station");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.ESCollision();
	}
}
