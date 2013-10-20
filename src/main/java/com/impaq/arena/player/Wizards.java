package com.impaq.arena.player;


public class Wizards extends Figures {

	private double strength;

	public Wizards(int startCount, double strength){
		super(startCount);
		this.strength = strength;
	}
	
	public int getStrength() {
		return  (int) Math.floor(this.getCount()*strength);
	}
}
