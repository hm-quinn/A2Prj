package com.mycompany.cmd;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DCollision extends Command{
	private GameWorld gw;
	
	public DCollision(GameWorld gw) {
		super("Collide with Drone");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.DCollision();
	}
}
