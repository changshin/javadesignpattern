package com.chang.oo.shape;
public abstract class Shape { // abstract class, can't instantiate
    // to implement an idNumber
    private static int counter = 0;
	private int idNumber;
	public Shape () {
		idNumber = ++counter;
	}
	public int getIdNumber() { return idNumber;}

	public double area() { return 0.0; }
	public double volume() { return 0.0; }

	public abstract String getName(); // abstract, so omit body
} 