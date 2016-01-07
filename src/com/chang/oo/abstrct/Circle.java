package com.chang.oo.abstrct;

class Circle extends Shape {
 
	Circle(double d1,String c)  {
		super("Circle",d1,c);
	}
	void area()  {
		double d1=getdim1();
		double pi=3.1416;
		double a= 2*pi*d1;
		System.out.println("Area :"+a);
	}
}