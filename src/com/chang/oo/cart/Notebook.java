package com.chang.oo.cart;


/**
 * @author Cremazer(cremazer@gmail.com)
 */
public class Notebook extends Product {
	private String name = "Notebook";
	public Notebook() {	// default price
		super(150);
	}
	public Notebook(String name, int price) {
		super(price);
		this.name =name; 
	}

	public String toString() {
		return name;
	}
}
