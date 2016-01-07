package com.chang.oodp.structural.adapter2;


import java.util.ArrayList;
/*
// http://www.java2blog.com/2012/09/adapter-design-pattern-in-java.html
 * When to use it:

    You want to use existing class and its interface does not match the one you need.
    You want to create a resuable class that cooperates with unrelated or unforeseen classes 
    that is, class that don't necessarily have compatible interfaces.
 */
public class PrintStringAdapterTest {  
   
	 public static void main(String[] args)  {  
		  ArrayList<String> list = new  ArrayList<String>();  
		  list.add("one");  
		  list.add("two");  
		  list.add("three");  
		  PrintableList pl = new PrintableListAdapter();  
		  pl.printList(list);  
	 }  
}  

