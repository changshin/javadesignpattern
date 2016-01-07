package com.bike.structural.decorator;

public class BikeImpl implements Bike {
	 
    protected Bike bike;
     
    public BikeImpl(Bike bike){
		this.bike=bike;
    }
     
    @Override
    public void assemble() {
        bike.assemble();
    }
    public String getName() {
        return bike.getName();
    }
	public int getPrice() {
        return bike.getPrice();
    }
}
