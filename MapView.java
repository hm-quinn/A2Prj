package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	private GameWorld gw;
	private TextArea myText;
	public MapView() {
		// TODO Auto-generated constructor stub
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255, 0, 0)));
		this.setLayout(new BorderLayout());
		myText = new TextArea();
		myText.setEditable(false);
		myText.getAllStyles().setBgTransparency(0);
		this.setScrollable(true);
		
		this.setWidth(1000);
		this.setHeight(1000);
		this.add(BorderLayout.CENTER, myText);
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		gw = (GameWorld) data;
		IIterator itr = gw.getCollection().getIterator();	
		String display = "";
		while(itr.hasNext()){
			display = display + itr.getNext().toString()+"\n";
		}
		myText.setText(display);
		this.repaint();
	}
	
	public double getGameWidth() {
		return (double)this.getWidth();
	}
	
	public double getGameHeight() {
		return (double)this.getHeight();
	}
}
