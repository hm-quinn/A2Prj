package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends Fixed {
	private int size, capacity;
	
	public EnergyStation() {
		int x = rand.nextInt(6) + 15;
		this.size = this.capacity = x;
		super.setColor(ColorUtil.GREEN); //green
		super.setLocation(900 * rand.nextFloat(), 900 * rand.nextFloat());
	}
	
	public int getSize() {
		return this.size;
	}
	
	//set capacity after collision
	public void setCapacity() {
		this.capacity = 0;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public String toString() {
		String parentDes = super.toString();
		String myDes = " Size = " + size + " Capacity = " + capacity;
		return ("Energy Station: " + parentDes + myDes);
	}

}
