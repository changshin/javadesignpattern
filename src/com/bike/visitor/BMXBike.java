package com.bike.visitor;

public class BMXBike implements Item {
	// test
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
    public int price(ShoppingItem shoppingItem) {
        return shoppingItem.getPrice(this);
    }
 
}
