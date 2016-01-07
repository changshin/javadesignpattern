package com.chang.oo.financial;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private List<Loan> loans = null;
	
	Person (String name) {
		this.name = name;
		loans = new ArrayList<Loan>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person = new Person("Chang");
		CreditCard cc = new CreditCard(1000,.1,10,"CC");
		Mortgage mort = new Mortgage(2000,.1,10,"Mort");
		person.loans.add(cc);
		person.loans.add(mort);
		double ccMonthPayment =  cc.getMonthlyPayment();
		double mortMonthPayment =  mort.getMonthlyPayment();
		System.out.println("cc="+ccMonthPayment);
		System.out.println("mort="+mortMonthPayment);
		double total = 0;
		for ( Loan loan: person.loans ) {
			total += loan.getMonthlyPayment();
		}
		System.out.println("total="+total);
	}
	
}
