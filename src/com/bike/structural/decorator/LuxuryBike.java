package com.bike.structural.decorator;

public class LuxuryBike implements Bike {
	protected Bike bike;
	public LuxuryBike(Bike bike) {
		this.bike = bike;
	}

	@Override
	public void assemble() {
		bike.assemble();
		System.out.println("Adding features of Luxury Bike.");
	}

	@Override
	public String getName() {
		return bike.getName()+", Luxury";
    }
	@Override
	public int getPrice() {
        return bike.getPrice() + 50;
    }
	
}
