package com.bike.visitor;

public interface ShoppingItem {
	int getPrice(BMXBike bmxBike);
    int getPrice(MountainBike mountainBike);

}
