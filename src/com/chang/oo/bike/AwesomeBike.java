package com.chang.oo.bike;

import java.util.ArrayList;
import java.util.List;

public class AwesomeBike extends Bike {
	private String description;
	private Bike bike;
	private String name;
	private List<Part> extraParts;
	public AwesomeBike(String name,Bike bike) {
		super(name,bike.getPrice());
		this.bike = bike;
		extraParts = new ArrayList<Part>();
		this.name = name;
	}
	public void addParts(Part part) {
		extraParts.add(part);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice( ){
		int price = super.getPrice();
		for ( Part part: extraParts ) {
			price += part.getPrice();
		}
		return price;
	};
}
