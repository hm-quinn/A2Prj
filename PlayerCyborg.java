package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;

public class PlayerCyborg extends Cyborg{
	private static PlayerCyborg pc;
	private int size, maximumSpeed, energyConsumptionRate, damageLevel, maxDamageLevel;
	

 {
		this.size = rand.nextInt(6) + 20;
		this.maximumSpeed = 50;
		super.setEnergyLevel(100);
		this.energyConsumptionRate = 1;
		this.damageLevel = 0;
		this.maxDamageLevel = 100;
		super.setBaseReach(1);
		super.setColor(ColorUtil.rgb(255,0,0)); //red
		super.setSpeed(0);
		super.setHeading(0);
		super.setLocation(100,100);
	}
	
	public static PlayerCyborg getPlayer() {
		if(pc == null) 
			pc = new PlayerCyborg();
		return pc;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	public int getMaxSpeed() {
		return this.maximumSpeed;
	}
	
	public int getMaxDamageLevel() {
		return this.maxDamageLevel;
	}
	
	public int getRate() {
		return this.energyConsumptionRate;
	}
	
	public void setDamageLevel(int i) {
		if (this.damageLevel == this.maxDamageLevel)
			System.out.println("Cyborg is at its max damage level.");
		else 
			this.damageLevel += i;
	}
	
	public int getDamageLevel() {
		return this.damageLevel;
	}
	
	@Override
	public void setSteerDir(char x) {
		super.setSteerDir(x);
	}
	
	@Override
	public void move() {
		super.move();
	}
	
	public String toString() {
		String parentDes = super.toString();
		String myDes = 
				" Size = " + this.size + " Max Speed = " + this.maximumSpeed + 
				" Steering Direction = " + this.getSteerDir() + " Energy Level = " + this.getEnergyLevel() +
				" Damage Level = " + this.damageLevel;
		return ("Cyborg: " + parentDes + myDes);
	}
}
