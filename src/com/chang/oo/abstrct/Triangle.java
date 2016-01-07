package com.chang.oo.abstrct;

class Triangle extends Shape {
	private double dim2;//dim1=base,dim2-altitude
	Triangle(double d1,double d2,String c)  {
		super("triangle",d1,c);
		dim2=d2;
	}
	void area()  {
		double d1=getdim1();
		double a;
		a =d1*dim2/2;
		System.out.println("Area :"+a);
	}
}