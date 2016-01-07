package com.chang.oo.financial;

import java.util.Date;

public class CreditCard extends Loan {
	private Date createdDate;
	private Date expiredDate;
	
	CreditCard ( double principle,double interest,int duration, String name) {
		super(principle,interest,duration,name);
	}
	public double getMonthlyPayment() {
		double princ = getPrinciple();
		double total = princ + princ * getInterest() * getDuration();
		return total / getDuration();
	}
}
