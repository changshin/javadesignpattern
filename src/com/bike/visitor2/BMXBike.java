package com.bike.visitor2;

public class BMXBike implements Item {
	 
    private int price;
    private String name;
     
    public BMXBike(int price, String name){
        this.price=price;
        this.name=name;
    }
     
    public int getPrice() {
        return price;
    }
 
    public String getName() {
        return name;
    }
 
    @Override
    public int price() {
		System.out.println("BMX Bike:" + getName() + ", price ="	+ getPrice());
        return getPrice();
    }
 
}
