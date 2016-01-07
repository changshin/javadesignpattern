package com.bike.creational.factory;

public class CreateBikeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike bmxBike = BikeFactory.getBike( new BMXBikeFactory("BMX Frame1","Tires1","Gear1","Chain1"));
		Bike mountainBike = BikeFactory.getBike( new MountainBikeFactory("Mountain Frame2","Tires2","Gear2","Chain2"));
		System.out.println(bmxBike.toString());
		System.out.println(mountainBike.toString());
	}

}
