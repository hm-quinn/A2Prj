package com.mycompany.a2;
import com.mycompany.cmd.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

public class Game extends Form {
	private GameWorld gw;
	private MapView map;
	private ScoreView score;
	
	public Game() {
		/* Create game world and views using MVC architecture
		 * 
		 */
		this.gw = new GameWorld();
		this.map = new MapView();
		this.score = new ScoreView();
		
		gw.addObserver(map);
		gw.addObserver(score);
		
		this.setLayout(new BorderLayout()); //set border layout for game form
		
		/*Set title*/
		Toolbar myToolBar = new Toolbar();
		this.setToolbar(myToolBar);
		myToolBar.setTitle("Sili-Challenge Game");
		myToolBar.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
		
		this.addComponent(BorderLayout.CENTER, map); //add map view to center
		this.addComponent(BorderLayout.NORTH, score); //add score view to the top
		
		gw.setHeight(map.getGameHeight());
		gw.setWidth(map.getGameWidth());
		
		Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		westContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
		
		//Accelerate 
		Accelerate acc = new Accelerate(gw);
		Button accB = new Button("Accelerate");
		buttonStyle(accB);
		accB.getAllStyles().setMarginTop(10);;
		accB.setCommand(acc);
		westContainer.addComponent(accB);
		this.addKeyListener('a', acc);
		myToolBar.addCommandToSideMenu(acc);
		
		//Left turn
		Left left = new Left(gw);
		Button leftB = new Button("Left");
		buttonStyle(leftB);
		leftB.setCommand(left);
		westContainer.addComponent(leftB);
		this.addKeyListener('l', left);
		
		//Change Strategies
		Strategy strategy = new Strategy(gw);
		Button strategyB = new Button("Change Strategies");
		buttonStyle(strategyB);
		strategyB.setCommand(strategy);
		westContainer.addComponent(strategyB);
		
		this.addComponent(BorderLayout.WEST, westContainer);
		
		Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
		
		//Collide with NPC
		NPCCollision collision1 = new NPCCollision(gw);
		Button npcB = new Button("Collide with NPC");
		buttonStyle(npcB);
		npcB.getAllStyles().setMarginLeft(5);
		npcB.setCommand(collision1);
		bottomContainer.addComponent(npcB);
		
		//Collide with Base
		BCollision collision2 = new BCollision(gw);
		Button bB = new Button("Collide with Base");
		buttonStyle(bB);
		bB.setCommand(collision2);
		bottomContainer.addComponent(bB);
		
		//Collide with energy station
		ECollision collision3 = new ECollision(gw);
		Button eB = new Button("Collide with Energy Station");
		buttonStyle(eB);
		eB.setCommand(collision3);
		bottomContainer.addComponent(eB);
		this.addKeyListener('e', collision3);
		
		//Collide with Drone
		DCollision collision4 = new DCollision(gw);
		Button dB = new Button("Collide with Drone");
		buttonStyle(dB);
		dB.setCommand(collision4);
		bottomContainer.addComponent(dB);
		this.addKeyListener('g', collision4);
		
		//Clock tick
		Clock clock = new Clock(gw);
		Button clockB = new Button("Tick");
		buttonStyle(clockB);
		clockB.getAllStyles().setMarginRight(5);
		clockB.setCommand(clock);
		bottomContainer.addComponent(clockB);
		this.addKeyListener('t', clock);
		
		this.addComponent(BorderLayout.SOUTH, bottomContainer);
		
		Container eastContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
		
		//Brake
		Brake brake = new Brake(gw);
		Button brakeB = new Button("Brake");
		buttonStyle(brakeB);
		brakeB.getAllStyles().setMarginTop(10);
		brakeB.setCommand(brake);
		eastContainer.addComponent(brakeB);
		this.addKeyListener('b', brake);
		
		//Right turn
		Right right = new Right(gw);
		Button rightB = new Button("Right");
		buttonStyle(rightB);
		rightB.setCommand(right);
		eastContainer.addComponent(rightB);
		this.addKeyListener('r', right);
		
		this.addComponent(BorderLayout.EAST, eastContainer);
		
		//Sound
		CheckBox soundB;
		if(gw.getSound())
			soundB = new CheckBox("ON");
		else
			soundB = new CheckBox("OFF");
		Sound sound = new Sound(gw);
		soundB.setCommand(sound);
		myToolBar.addComponentToSideMenu(soundB);
		
		//About
		About about = new About();
		myToolBar.addCommandToSideMenu(about);
		
		//Exit
		Exit exit = new Exit(gw);
		myToolBar.addCommandToSideMenu(exit);
		
		//Help
		Help help = new Help();
		myToolBar.addCommandToRightBar(help);
		
		this.show();
	}
	
	private void buttonStyle(Button button) {
		button.getAllStyles().setBgTransparency(255);
		button.getAllStyles().setBorder(Border.createBevelRaised());
		button.getAllStyles().setBorder(Border.createBevelLowered());
		button.getAllStyles().setBorder(Border.createDoubleBorder(2,ColorUtil.GRAY));
		button.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 100, 100));
		button.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		button.getPressedStyle().setBgTransparency(125);
		button.getPressedStyle().setBgColor(ColorUtil.rgb(0, 100, 100));
		button.getPressedStyle().setFgColor(ColorUtil.BLUE);
		button.getDisabledStyle().setBgTransparency(255);
		button.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		button.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		button.getDisabledStyle().setStrikeThru(true);
	}
}