package com.bike.behavioral.template;

public class BMXBike extends BikeTemplate {
	@Override
    public void buildHandleBar() {
        System.out.println("Building BMXBike HandleBar");
    }

	@Override
    public void buildTires() {
        System.out.println("Building BMXBike Tires");
    }
  
    @Override
    public void buildGear() {
        System.out.println("Building BMXBike Gear");
    }

    @Override
    public void buildChain() {
        System.out.println("Building BMXBike Chain");
    }
 

}
