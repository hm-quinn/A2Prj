package com.mycompany.a2;

public class BaseCollisionStrategy implements IStrategy {
	@Override
	public void apply() {
		System.out.println("Non Player Cyborg is moving onto the next base.");
	}
	@Override
	public String getName() {
		return "Base Collide Strategy";
	}
}
