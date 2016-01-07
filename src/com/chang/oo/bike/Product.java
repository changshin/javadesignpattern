package com.chang.oo.bike;

import java.util.List;

public class Product {
	
	private String name;
	private int basicPrice;
	
	public Product(String name,int price) {
		this.name = name;
		this.basicPrice = price;
	}

	public int getPrice( ){
		int price = this.basicPrice;
		return price;
	};

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "";
	}
}
