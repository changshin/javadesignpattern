package com.chang.oo.bike;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Product> products = new ArrayList<Product>();
		Product product = new Product("Sample",10);
		Part part = new Part("part1",20);
		Bike bike = new Bike("Basic Bike",100);
		bike.addParts(part);
		
		//bike.setName("Awesome Bike");
		AwesomeBike awesomeBike = new AwesomeBike("Awesome Bike",bike);
		Part part2 = new Part("Customer Paint",30);
		awesomeBike.addParts(part2);
		products.add(product);
		products.add(bike);
		products.add(awesomeBike);
		int total = 0;
		int price = 0;
		for ( Product prod: products ) {
			price = prod.getPrice();
			System.out.println("total="+prod.getName()+":"+price);
			total += price;
		}
		System.out.println("total="+total);
	}
	
}
