package com.chang.oo.cart;
/**
 * @author Cremazer(cremazer@gmail.com)
 */
public class TV extends Product {
	public TV() {
		super(20);
	}

	public TV(int price) {
		super(price);
	}
	public String toString() {
		return "TV";
	}
}
