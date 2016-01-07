package com.chang.oo.abstrct;

class Square extends Shape {
 
	Square(double d1,String c) {
		super("Square",d1,c);
	}
	void area()  {
		double d1=getdim1();
		double a = d1*d1;
		System.out.println("Area :"+a);
	}
}