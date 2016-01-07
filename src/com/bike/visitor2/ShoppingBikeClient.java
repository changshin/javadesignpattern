package com.bike.visitor2;

public class ShoppingBikeClient {
	 
    public static void main(String[] args) {
        Item[] items = new Item[]{new BMXBike(2000, "BMX-100"),new BMXBike(3000, "BMX-200"),
                new MountainBike(1000, "Mountain-10", 100), new MountainBike(1500, "Mountain-20", 200)};
         
        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }
 
    private static int calculatePrice(Item[] items) {
        int sum=0;
        for(Item item : items){
            sum = sum + item.price();
        }
        return sum;
    }
 
}
