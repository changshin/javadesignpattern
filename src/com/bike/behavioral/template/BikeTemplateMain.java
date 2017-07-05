package com.bike.behavioral.template;

import java.util.ArrayList;
import java.util.List;

public class BikeTemplateMain {
	public static void main(String[] args) {
        
		List<BikeTemplate> bikes = new ArrayList<BikeTemplate>();
        BikeTemplate bike = new BMXBike();
		bikes.add(bike);
         
        //using template method
        bike.buildBike();
        System.out.println("************");
         
        bike = new MountainBike();
		bikes.add(bike);
        bike.buildBike();

        System.out.println("************");
        bike = new GeneralBike();
		bikes.add(bike);
        bike.buildBike();
        
        for ( BikeTemplate bikeTemplate: bikes) {
        	bike.buildBike();	
        }
}

}
