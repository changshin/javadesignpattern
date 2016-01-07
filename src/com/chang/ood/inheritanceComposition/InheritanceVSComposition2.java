package com.chang.ood.inheritanceComposition;

// http://www.programcreek.com/2014/05/inheritance-vs-composition-in-java/

public class InheritanceVSComposition2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bee2 a = new Bee2(1, "black", new AttackImpl("fly", "move"));
		a.attack();

		// if you need another implementation of move()
		// there is no need to change Insect, we can quickly use new method to
		// attack

		Bee2 b = new Bee2(1, "black", new AttackImpl("fly", "sting"));
		b.attack();
	}

}
// Bee is a type of Insect, it can attack.
class Bee2 extends Insect2 implements Attack {
	private Attack attack;

	public Bee2(int size, String color, Attack attack) {
		super(size, color);
		this.attack = attack;
	}

	public void move() {
		attack.move();
	}

	public void attack() {
		attack.attack();
	}
}

// Since the attack function is extracted, Insect does not do anything related with attack any longer.
class Insect2 {
	private int size;
	private String color;

	public Insect2(int size, String color) {
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
}

// Different kinds of attack can be defined by implementing the Attack interface.
class AttackImpl implements Attack {
	private String move;
	private String attack;

	public AttackImpl(String move, String attack) {
		this.move = move;
		this.attack = attack;
	}

	@Override
	public void move() {
		System.out.println(move);
	}

	@Override
	public void attack() {
		move();
		System.out.println(attack);
	}
}

// The attack function is abstracted as an interface.
interface Attack {
	public void move();

	public void attack();
}