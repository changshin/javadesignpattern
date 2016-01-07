package com.bike.structural.decorator;

public class BasicBike implements Bike {
	@Override
    public void assemble() {
        System.out.println("Basic Bike");
    }
	@Override
	public String getName() {
        return "Basic Bike";
    }
	@Override
	public int getPrice() {
        return 100;
    }
}
