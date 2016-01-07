package com.chang.oodp.structural.adapter2;

import java.util.ArrayList;  
/*
//http://www.java2blog.com/2012/09/adapter-design-pattern-in-java.html
* When to use it:

 You want to use existing class and its interface does not match the one you need.
 You want to create a resuable class that cooperates with unrelated or unforeseen classes 
 that is, class that don't necessarily have compatible interfaces.
*/
// Adapter class
public class PrintableListAdapter implements PrintableList{  
  
	 public void printList(ArrayList<String> list) {  
	   
		  //Converting ArrayList<String> to String so that we can pass String to  
		  // adaptee class  
		  String listString = "";  
		  for (String s : list) {  
		      listString += s + "\t";  
		  }  
		  // instantiating adaptee class  
		  PrintStringAdaptee psAdaptee = new PrintStringAdaptee();  
		  psAdaptee.print(listString);  
	 }  
}
