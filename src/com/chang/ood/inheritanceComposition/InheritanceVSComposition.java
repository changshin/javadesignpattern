package com.chang.ood.inheritanceComposition;

// http://www.programcreek.com/2014/05/inheritance-vs-composition-in-java/
/*
 This inheritance design is bad, 
 because the subclass depends on the implementation details of its superclass. 
 If the superclass changes, the subclass may break. 
 
The following two items can guide the selection between inheritance and composition:

    If there is an IS-A relation, and a class wants to expose all the interface to another class, 
    inheritance is likely to be preferred.
    If there is a HAS-A relationship, composition is preferred.
	
 */
public class InheritanceVSComposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Insect i = new Bee(1, "red");
			i.attack();
	}

}

class Bee extends Insect {
	public Bee(int size, String color) {
		super(size, color);
	}
 
	public void move() {
		System.out.println("Fly");
	}
 
	public void attack() {
		move();
		super.attack();
	}
}
class Insect {
	private int size;
	private String color;
 
	public Insect(int size, String color) {
		this.size = size;
		this.color = color;
	}
 
	public int getSize() {
		return size;
	}
 
	public void setSize(int size) {
		this.size = size;
	}
 
	public String getColor() {
		return color;
	}
 
	public void setColor(String color) {
		this.color = color;
	}
 
	public void move() {
		System.out.println("Move");
	}
 
	public void attack() {
		move(); //assuming an insect needs to move before attacking
		System.out.println("Attack");
	}
}