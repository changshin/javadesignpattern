package com.chang.oo.bike;

public class Tire extends Part{
	int speed;
	int rating;
	
	public Tire() {
		super("Tire",123);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
