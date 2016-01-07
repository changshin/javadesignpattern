package com.bike.visitor;


public class MountainBike implements Item {
    
	private int price;
    private String name;
    private int discount;
    
   public MountainBike(int price, String name, int discount){
       this.price = price;
       this.name  = name;
       this.discount = discount;
   }
    
   public int getPrice() {
       return price;
   }
   public int getDiscount() {
       return discount;
   }
   public String getName() {
       return name;
   }

   @Override
   public int price(ShoppingItem shoppingCartItem) {
       return shoppingCartItem.getPrice(this);
   }

}
