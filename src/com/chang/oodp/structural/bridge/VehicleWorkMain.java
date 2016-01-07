package com.chang.oodp.structural.bridge;

// http://javapapers.com/design-patterns/bridge-design-pattern/
public class VehicleWorkMain {
	public static void main(String[] args) {

		Vehicle vehicle1 = new Car(new Produce(), new Assemble());
		vehicle1.manufacture();
		Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
		vehicle2.manufacture();

	}
}

class Produce implements Workshop {

	@Override
	public void work() {
		System.out.print("Produced");
	}

}
class Assemble implements Workshop {

	@Override
	public void work() {
		System.out.println(" Assembled.");
	}

}
interface Workshop {
	public void work();
}


class Bike extends Vehicle {

	public Bike(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Bike ");
		workShop1.work();
		workShop2.work();
	}

}

class Car extends Vehicle {

	public Car(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Car ");
		workShop1.work();
		workShop2.work();

	}

}

abstract class Vehicle {
	protected Workshop workShop1;
	protected Workshop workShop2;

	protected Vehicle(Workshop workShop1, Workshop workShop2) {
		this.workShop1 = workShop1;
		this.workShop2 = workShop2;
	}

	abstract public void manufacture();
}
