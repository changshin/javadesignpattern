package com.bike.creational.builder;

import com.bike.creational.builder.Bike;
// http://www.journaldev.com/1425/builder-design-pattern-in-java
public class TestBuilderPattern {
	public static void main(String[] args) {
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments management issues
		Bike bike = new Bike.BikeBuilder("Main Frame", "Tires")
				.setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true)
				.build();
		System.out.println(bike.toString());
	}

}
