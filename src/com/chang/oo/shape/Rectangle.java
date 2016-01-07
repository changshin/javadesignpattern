package com.chang.oo.shape;

//Rectangle.java: the class Rectangle
public class Rectangle extends Point {  // inherits from Point
protected double length;
protected double width;

// Constructor
public Rectangle( double len, double wid, int a, int b ) {
   super( a, b );  // call the superclass constructor
   length = ( len >= 0 ? len : 0 );
   width  = ( wid >= 0 ? wid : 0 );
}

// Calculate area of Rectangle
public double area() { return length * width; }

// convert the Rectangle to a String
public String toString() {
   return "Center = " + super.toString() + 
      "; Length = " + length + ", Width = " + width; }

// return the class name
public String getName() {
   if (length == width) return "Square"; 
   else return "Rectangle";
}
}

