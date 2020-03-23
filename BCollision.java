package com.mycompany.cmd;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class BCollision extends Command{
	private GameWorld gw;
	
	public BCollision(GameWorld gw) {
		super("Collide with Base");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		TextField myText = new TextField();
		Command ok = new Command("OK");
		Command cancel = new Command("Cancel");
		Command[] cmd = new Command[] {ok, cancel};
		Command c = Dialog.show("Enter base number", myText, cmd);
		if(c == ok) 
			gw.BCollision(Integer.parseInt(myText.getText()));
	}
}
