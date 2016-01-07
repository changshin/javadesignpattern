package com.bike.behavioral.template;

public abstract class BikeTemplate {
	// template method, final so subclasses can't override
	public final void buildBike() {
		buildFrame();
		
		buildHandleBar();
		buildTires();
		buildGear();
		buildChain();
		
		buildBreak();
		buildSaddle();
		System.out.println("Bike is built.");
	}

	// default implementation
	private void buildFrame() {
		System.out.println("Building frame");
	}
	// methods to be implemented by subclasses
	public abstract void buildTires();
	public abstract void buildGear();
	public abstract void buildChain();
	public abstract void buildHandleBar();

	private void buildBreak() {
		System.out.println("Building Break");
	}
	public void buildPedals() {
		System.out.println("Building Pedals");
	}
	public void buildSaddle() {
		System.out.println("Building Saddle");
	}

}
