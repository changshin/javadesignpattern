package com.bike.behavioral.template;

public class GeneralBike extends BikeTemplate {
	@Override
    public void buildHandleBar() {
        System.out.println("Building GeneralBike HandleBar");
    }

	@Override
    public void buildTires() {
        System.out.println("Building GeneralBike Tires");
    }
  
    @Override
    public void buildGear() {
        System.out.println("Building GeneralBike Gear");
    }

    @Override
    public void buildChain() {
        System.out.println("Building GeneralBike Chain");
    }
 

}
