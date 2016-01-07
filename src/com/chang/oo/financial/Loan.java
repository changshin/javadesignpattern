package com.chang.oo.financial;

//public abstract class Loan extends LoanAbstract{
abstract public class Loan {
	private double principle;
	private double interest;
	private int duration;
	private String name;
	
	public abstract double getMonthlyPayment();

	Loan (double principle,double interest,int duration, String name) {
		this.principle = principle;
		this.interest = interest;
		this.duration = duration;
		this.name = name;
	}
	
	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
}
