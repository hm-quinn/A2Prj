package com.mycompany.cmd;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NPCCollision extends Command {
	private GameWorld gw;
	
	public NPCCollision(GameWorld gw) {
		super("Collide with NPC");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.CBCollision();
	}

}
