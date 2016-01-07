package com.chang.oo.singleton;
// http://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html
public class VolatileSingleton {

	private static volatile VolatileSingleton _instance; //volatile variable

	// test
	public static VolatileSingleton getInstance(){

	   if(_instance == null){
		   synchronized(VolatileSingleton.class){	// volatile, thread-safe
			   if(_instance == null)
				   _instance = new VolatileSingleton();
	       }

	   }
	   return _instance;

	}


}
/*
If we do not make _instance variable volatile 
then Thread which is creating instance of Singleton is not able to communicate other thread, 
that instance has been created until it comes out of the Singleton block 
,so if Thread A is creating Singleton instance and just after creation lost the CPU
,all other thread will not be able to see value of _instance as not null and they will believe its still null.
Why because reader threads are not doing any locking and 
until writer thread comes out of synchronized block, memory will not be synchronized and value of _instance will not be updated in main memory. 
With Volatile keyword in Java this is handled by Java himself and such updates will be visible by all reader threads.

*/