package com.chang.oo.abstrct;

abstract class Shape {
	private String name;
	private double dim1;
	String color;
	Shape(String name,double d1,String c) {
		dim1=d1;
		color=c;
		this.name = name;
	}

	abstract void area();

	void display() {
		System.out.println(getName() + ",Color :"+color);
	}
	
	public String getName(){return(name);}
	public double getdim1(){return(dim1);}
}