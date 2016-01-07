package com.chang.oo.bike;

import java.util.ArrayList;
import java.util.List;

public class Bike extends Product {
	private String description;
	private List<Part> parts;
	private String name;
	public Bike(String name,int price) {
		super(name,price);
		parts = new ArrayList<Part>();
		this.name = name; 
	}
	public void addParts(Part part) {
		parts.add(part);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice( ){
		int price = super.getPrice();
		for ( Part part: parts ) {
			price += part.getPrice();
		}
		return price;
	};
}
