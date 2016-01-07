package com.bike.creational.factory;

public class BMXBike extends Bike {
	 
    private String frame;
    private String tires;
    private String gear;
    private String chain;
     
    public BMXBike(String frame, String tires, String gear, String chain){
        this.frame=frame;
        this.tires=tires;
        this.gear=gear;
        this.chain=chain;
    }
    @Override
    public String getFrame() {
        return this.frame;
    }
 
    @Override
    public String getTires() {
        return this.tires;
    }
 
    @Override
    public String getGear() {
        return this.gear;
    }

    @Override
    public String getChain() {
        return this.chain;
    }
 
}