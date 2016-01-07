package com.bike.creational.factory;

public abstract class Bike {

	public abstract String getFrame();

	public abstract String getTires();

	public abstract String getChain();

	public abstract String getGear();

	@Override
	public String toString() {
		return "Frame= " + this.getFrame() + ", Tires=" + this.getTires() 
				+ ", Chain=" + this.getChain()+ ", Gear=" + this.getGear();
	}
}