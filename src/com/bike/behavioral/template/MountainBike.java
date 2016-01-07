package com.bike.behavioral.template;

public class MountainBike extends BikeTemplate {
	@Override
    public void buildHandleBar() {
        System.out.println("Building MountainBike HandleBar");
    }
	@Override
    public void buildTires() {
        System.out.println("Building MountainBike Tires");
    }
  
    @Override
    public void buildGear() {
        System.out.println("Building MountainBike Gear");
    }

    @Override
    public void buildChain() {
        System.out.println("Building MountainBike Chain");
    }
 

}
