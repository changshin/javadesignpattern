package com.bike.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class DecoratorPatternTest {
	public static void main(String[] args) {
		List<Bike> bikes = new ArrayList<Bike>();
        Bike basicBike = new BasicBike();
        basicBike.assemble();
        System.out.println("\n*****");
		bikes.add(basicBike);

		Bike sportsBike = new SportsBike(new BasicBike());
        sportsBike.assemble();
        System.out.println("\n*****");
		bikes.add(sportsBike);

        Bike luxuryBike = new LuxuryBike(new BasicBike());
        luxuryBike.assemble();
        System.out.println("\n*****");
		bikes.add(luxuryBike);

        Bike sportsLuxuryBike = new SportsBike(new LuxuryBike(new BasicBike()));
        sportsLuxuryBike.assemble();
		bikes.add(sportsLuxuryBike);

        Bike luxurySportsBike = new LuxuryBike(new SportsBike(new BasicBike()));
        luxurySportsBike.assemble();
		bikes.add(luxurySportsBike);
		
		System.out.println("\n====================");
		for ( Bike bike2: bikes) {
			System.out.println(bike2.getName()+ ":"+ bike2.getPrice());
			bike2.assemble();
			System.out.println();

		}
	}

}
