package com.mycompany.a2;
import com.codename1.charts.models.Point;

public abstract class Movable extends GameObject implements IMovable {
	private int speed;
	private double heading;
	
	@Override
	public void move() {
		Point oldLoc = super.getLocation(); //get current location
		Point newLoc = new Point(0,0);
		double theta = 90 - this.heading; 
		float deltaX = 0;
		float deltaY = 0;
		
		//deltaX and deltaY = heading * speed
		if(this.speed == 0) {
			this.speed = 1;
			deltaX = (float) (Math.cos(Math.toRadians(theta))* this.speed); 
			deltaY = (float) (Math.sin(Math.toRadians(theta)) * this.speed);
		}
		else {
			deltaX = (float) (Math.cos(Math.toRadians(theta))* this.speed); 
			deltaY = (float) (Math.sin(Math.toRadians(theta)) * this.speed);
			
		}
		//compute newLocation = oldLocation + (deltaX, deltaY)
		newLoc.setX(deltaX + oldLoc.getX());
		newLoc.setY(deltaY + oldLoc.getY());
		super.setLocation(newLoc);
	}
	
	public void setSpeed(int x)
	{
		this.speed += x;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public double getHeading()
	{
		return this.heading;
		
	}
	
	public void setHeading(double x)
	{
		this.heading = x;
	}
	
	public String toString()
	{
		String parentString = super.toString();
		String str = " Heading = " + this.heading + " Speed = " + this.speed;	
		String retval = parentString + str;
		return retval;
	}
}
