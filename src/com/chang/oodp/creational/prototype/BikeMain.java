package com.chang.oodp.creational.prototype;

public class BikeMain {
	public Bike makeJaguar(Bike basicBike) {
		basicBike.makeAdvanced();
		return basicBike;
	}

	public static void main(String args[]) {
		Bike bike = new Bike();
		Bike basicBike = bike.clone();
		System.out.println("bike: "	+ bike.getModel());
		System.out.println("basicBike: " + basicBike.getModel());
		BikeMain workShop = new BikeMain();
		Bike advancedBike = workShop.makeJaguar(basicBike);
		System.out.println("bike: "	+ bike.getModel());
		System.out.println("basicBike: " + basicBike.getModel());
		//System.out.println("workShop: " + workShop.getModel());
		System.out.println("Prototype Design Pattern: "	+ advancedBike.getModel());
	}
}

class Bike implements Cloneable {
	private int gears;
	private String bikeType;
	private String model;

	public Bike() {
		bikeType = "Standard";
		model = "Leopard";
		gears = 4;
	}

	public Bike clone() {
		return new Bike();
	}

	public void makeAdvanced() {
		bikeType = "Advanced";
		model = "Jaguar";
		gears = 6;
	}

	public String getModel() {
		return model;
	}
}