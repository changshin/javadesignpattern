package com.bike.creational.factory;

public class BikeFactory {
	public static Bike getBike(BikeFactoryInterface bikeFactoryInterface) {
		return bikeFactoryInterface.createBike();
	}
}
