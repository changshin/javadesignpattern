package com.chang.oo.cart;


/**
 * @author Cremazer(cremazer@gmail.com)
 */
public class CartTest {
	public static void main(String[] args) {
		Buyer customer = new Buyer();

		customer.summery();	// return empty

		customer.buy(new Notebook());
		customer.buy(new Audio());
		customer.buy(new TV());
		customer.buy(new Notebook("Samsung",123));

		customer.summery();
	}
}
