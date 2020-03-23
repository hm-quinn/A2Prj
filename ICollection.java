package com.mycompany.a2;

public interface ICollection {
	public void add(GameObject object); //add game objects
	public IIterator getIterator(); //get game object collection
	public void remove(GameObject object); //remove game objects
	public int getSize(); //get size of the collection
}
