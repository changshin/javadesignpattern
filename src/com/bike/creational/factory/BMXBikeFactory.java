package com.bike.creational.factory;

public class BMXBikeFactory implements BikeFactoryInterface {

	private String frame;
	private String tires;
	private String gear;
	private String chain;

	public BMXBikeFactory(String frame, String tires, String gear, String chain) {
		this.frame = frame;
		this.tires = tires;
		this.gear = gear;
		this.chain = chain;
	}

	@Override
	public Bike createBike() {
		return new BMXBike(frame, tires, gear, chain);
	}

}