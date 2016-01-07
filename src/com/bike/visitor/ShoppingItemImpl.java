package com.bike.visitor;

public class ShoppingItemImpl implements ShoppingItem {

	@Override
	public int getPrice(BMXBike bike) {
		System.out.println("BMX Bike:" + bike.getName() + ", price ="	+ bike.getPrice());
		return bike.getPrice();
	}

	@Override
	public int getPrice(MountainBike bike) {
		int price = bike.getPrice() - bike.getDiscount();
		System.out.println("Mountain Bike:" + bike.getName() + ", price ="	+ bike.getPrice() + ", discount ="	+ bike.getDiscount());
		return price;
	}

}
