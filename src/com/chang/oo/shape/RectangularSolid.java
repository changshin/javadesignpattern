package com.chang.oo.shape;

//RectangularSolid.java: the class RectangularSolid
public class RectangularSolid extends Rectangle {
	protected double height;  // height of RectangularSolid
	
	// constructor
	public RectangularSolid(double h, double len, double wid, int a, int b) {
	   super(len, wid, a, b);   // call superclass constructor
	   height = ( h >= 0 ? h : 0 );
	}
	
	// Calculate area of RectangularSolid (i.e., surface area)
	public double area() {
	   return 2 * super.area() +
	          2 * length * height +
	          2 * width * height;
	}
	
	// Calculate volume of RectangularSolid
	public double volume() { return super.area() * height; }
	
	// Convert a RectangularSolid to a String
	public String toString() {
	   return super.toString() + "; Height = " + height;
	}
	
	// Return the class name
	public String getName() {
	   if (length == width && length == height)
	      return("Cube");
	   else return "RectangularSolid";
	}
}