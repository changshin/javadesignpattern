package com.chang.oo.financial;

public class Mortgage extends Loan {
	private double housePrice;
	private double propertyTax;
	
	Mortgage ( double principle,double interest,int duration, String name) {
		super(principle,interest,duration,name);
	}
	public double getMonthlyPayment() {
		double princ = getPrinciple();
		double total = princ + princ * getInterest() * getDuration();
		return total / getDuration();
	}
}
