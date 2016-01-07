package com.chang.oodp.structural.adapter2;

/*
 * When to use it:

    You want to use existing class and its interface does not match the one you need.
    You want to create a resuable class that cooperates with unrelated or unforeseen classes 
    that is, class that don't necessarily have compatible interfaces.

 */
// PrintString.java(Adaptee) :
public class PrintStringAdaptee {
	public void print(String s)  {  
		System.out.println(s);  
	}  
}
