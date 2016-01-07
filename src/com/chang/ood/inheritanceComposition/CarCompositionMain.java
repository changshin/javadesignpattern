package com.chang.ood.inheritanceComposition;

// http://www.programcreek.com/2014/05/inheritance-vs-composition-in-java/

public class CarCompositionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sedan sedan6 = new Sedan(6, "black", new OperateImpl("Engine start", "and go fast"));
		sedan6.go();

		// if you need another implementation of operate()
		// there is no need to change car, we can quickly use new method to
		// operate

		Sedan sedan4 = new Sedan(4, "red", new OperateImpl("Engine start", "and go slow"));
		sedan4.go();
	}

}
// Sedan is a type of car, it can operate.
class Sedan extends Car implements Operate {
	private Operate operate;

	public Sedan(int size, String color, Operate operate) {
		super(size, color);
		this.operate = operate;
	}

	public void info() {
		System.out.println();
		System.out.print(this.getSize() + " " + this.getColor()+", ");
	}

	@Override
	public void start() {
		operate.start();
	}
	@Override
	public void go() {
		info();
		operate.go();
	}
}

// Since the attack function is extracted, car does not do anything related with operate any longer.
class Car {
	private int size;	// 4 or 6
	private String color;

	public Car(int size, String color) {
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
class OperateImpl implements Operate {
	private String start;
	private String go;

	public OperateImpl(String start, String go) {
		this.start = start;
		this.go = go;
	}

	@Override
	public void start() {
		System.out.print(start+" ");
	}

	@Override
	public void go() {
		start();
		System.out.print(go);
	}
}

// The operate function is abstracted as an interface.
interface Operate {
	public void start();

	public void go();
}