package com.chang.oodp.structural.bridge;

public class ColorShapeBridgeMain {
	public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();
         
        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }

}

class Triangle extends Shape{
    public Triangle(Color color) {
        super(color);
    }
 
    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    } 
 

}
class Pentagon extends Shape{
    public Pentagon(Color color) {
        super(color);
    }
 
    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    } 
 

}
abstract class Shape {
    //Composition - implementor
    protected Color color;
     
    //constructor with implementor as input argument
    public Shape(Color color){
        this.color=color;
    }
     
    abstract public void applyColor();

}

class RedColor implements Color {
	public void applyColor() {
		System.out.println("red.");
	}

}
class GreenColor implements Color {
	public void applyColor() {
		System.out.println("green.");
	}

}

interface Color {
	public void applyColor();
}
