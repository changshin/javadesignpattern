package com.chang.oo.abstrct;

public class ShapeTest {

	public static void main(String args[]) 	 {
		Triangle t = new Triangle(2,4,"red");
		t.display();
		t.area();
		Square s = new Square(4,"green");
		s.display();
		s.area();
		Rectangle r = new Rectangle(4,8,"yellow");
		r.display();
		r.area();
		Circle c = new Circle(6,"orange");
		c.display();
		c.area();
		
		Shape shapes[] = new Shape[4]; // generic array of any shape
		shapes[0] = t;
		shapes[1] = s;
		shapes[2] = r;
		shapes[3] = c;
		
		System.out.println("");
		for ( int i = 0; i < shapes.length; i++ ) {
			Shape shape = shapes[i];
			shape.display();
			shape.area();
		}
	  
	 }

}
