package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class NonPlayerCyborg extends Cyborg{
	IStrategy strategy;
	private int size;
	private int id;
	
	public NonPlayerCyborg(int i) {
		this.size = rand.nextInt(6) + 25;
		this.id = i;
		super.setSpeed(1);
		super.setEnergyLevel(250);
		super.setBaseReach(0);
		super.setColor(ColorUtil.rgb(255, 0, 0));
		super.setLocation(50 + (rand.nextFloat() * 50), 50 + (rand.nextFloat() * 50));
		if(i == 1) 
			this.setStrategy(new CyborgCollisionStrategy());
		else if(i == 2)
			this.setStrategy(new BaseCollisionStrategy());
		else if(i == 3)
			this.setStrategy(new CyborgCollisionStrategy());
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		Point oldLoc = super.getLocation(); //get current location
		Point newLoc = new Point(0,0);
		float deltaX = 0;
		float deltaY = 0;
		
		//deltaX and deltaY = heading * speed
			deltaX = (float) (Math.cos(Math.toRadians(this.getHeading()))* this.getSpeed()); 
			deltaY = (float) (Math.sin(Math.toRadians(this.getHeading())) * this.getSpeed());
		//compute newLocation = oldLocation + (deltaX, deltaY)
		newLoc.setX(deltaX + oldLoc.getX());
		newLoc.setY(deltaY + oldLoc.getY());
		super.setLocation(newLoc);
	}

	public void resetEnergy() {
		super.setEnergyLevel(250);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public void setStrategy(IStrategy strategy) {
		// TODO Auto-generated method stub
		this.strategy = strategy;
	}

	public void invokeStrategy() {
		// TODO Auto-generated method stub
		this.strategy.apply();
	}
	
	public IStrategy getStrategy() {
		return this.strategy;
	}
	
	public String toString() {
		String parentDes = super.toString();
		String myDes = 
				" Size = " + this.size + " Speed = " + this.getSpeed() +
				" Steering Direction = " + this.getSteerDir() + " Energy Level = " + this.getEnergyLevel() +
				" Strategy = " + strategy.getName();
		return ("Cyborg " + this.id + ": " + parentDes + myDes);
	}

}
