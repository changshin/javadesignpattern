package com.chang.oo.abstrct;

class Rectangle extends Shape {
	private double dim2;//dim1=width,dim2=breath
	Rectangle(double d1,double d2,String c)  {
		super("Rectangle",d1,c);
		dim2=d2;
	}
	void area()  {
		double d1=getdim1();
		double a= d1*dim2;
		System.out.println("Area :"+a);
	}
}