package com.bike.creational.factory;

public class MountainBikeFactory implements BikeFactoryInterface {

	private String frame;
	private String tires;
	private String gear;
	private String chain;

	public MountainBikeFactory(String frame, String tires, String gear, String chain) {
		this.frame = frame;
		this.tires = tires;
		this.gear = gear;
		this.chain = chain;
	}

	@Override
	public Bike createBike() {
		return new MountainBike(frame, tires, gear, chain);
	}

}