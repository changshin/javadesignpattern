package com.chang.oo.cart;

import java.util.Vector;

/**
 * @author Cremazer(cremazer@gmail.com)
 */
public class Buyer {
	Vector<Product> cart = new Vector<Product>();
	
	public void buy(Product p) {
		cart.add(p);
	}
	public void cancel(Product p) {
		cart.remove(p);
	}

	public void summery() {
		int sum = 0;
		String cartList = "";

		if (cart.isEmpty()) {
			System.out.println("empty carts=====.");
			return;
		}

//		for (int index = 0; index < cart.size(); index++) {
//			Product p = (Product) cart.get(index);
//			sum += p.getPrice();
//			cartList += (index == 0) ? "" + p.toString() : ", " + p.toString();
//			System.out.println(p + "'s price is "+p.getPrice() );
//		}
		for (Product p: cart) {
			sum += p.getPrice();
			cartList += cartList =="" ?  p.toString() : ", " + p.toString();
			System.out.println(p + "'s price is "+p.getPrice() );
		}

		System.out.println("Summary " + sum + ".");
		System.out.println("Cart names=" + cartList + ".");
	}
}
