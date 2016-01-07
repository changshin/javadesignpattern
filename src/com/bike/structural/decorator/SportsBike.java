package com.bike.structural.decorator;

public class SportsBike implements Bike  {
	protected Bike bike;
	public SportsBike(Bike bike) {
		this.bike = bike;
	}

	@Override
	public void assemble() {
		bike.assemble();
		System.out.println("Adding features of Sports Bike.");
	}
	
	@Override
	public String getName() {
        return bike.getName()+", Sports";
    }
	@Override
	public int getPrice() {
        return bike.getPrice() + 30;
    }
}
