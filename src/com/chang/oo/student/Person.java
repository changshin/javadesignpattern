package com.chang.oo.student;

public class Person {
	// Instance variables
	private String name;
	private String address;

	// Constructor
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String toString() {
		return name + "(" + address + ")";
	}
}