package com.bike.behavioral.template;

public class BikeTemplateMain {
	public static void main(String[] args) {
        
        BikeTemplate bike = new BMXBike();
         
        //using template method
        bike.buildBike();
        System.out.println("************");
         
        bike = new MountainBike();
        bike.buildBike();

        System.out.println("************");
        bike = new GeneralBike();
        bike.buildBike();
}

}
