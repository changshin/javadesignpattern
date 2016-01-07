package com.bike.creational.builder;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Bike {

	// required parameters
	private String frameName;
	private String tires;

	// optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public String getFrameName() {
		return frameName;
	}

	public String getTires() {
		return tires;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	private Bike(BikeBuilder builder) {
		System.out.println("Bike(builder) is called.");
		this.frameName = builder.frame;
		this.tires = builder.tires;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	@Override 
	public String toString() {  
		return ToStringBuilder.reflectionToString(this);  
	}
	
	// Builder Class
	public static class BikeBuilder {

		// required parameters
		private String frame;
		private String tires;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		public BikeBuilder(String frame, String tires) {
			System.out.println("BikeBuilder() is called.");
			this.frame = frame;
			this.tires = tires;
		}

		public BikeBuilder setGraphicsCardEnabled(
				boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public BikeBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Bike build() {
			System.out.println("Bike builder() is called.");
			return new Bike(this);
		}

	}

}