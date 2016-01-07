package com.chang.oodp.creational.singleton;


// http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples
/*
 * Notice the private inner static class that contains the instance of the singleton class. 
 * When the singleton class is loaded, SingletonHelper class is not loaded into memory 
 * and only when someone calls the getInstance method, 
 * this class gets loaded and creates the Singleton class instance.
 * This is the most widely used approach for Singleton class as it doesn’t require synchronization. 
 * I am using this approach in many of my projects and it's easy to understand and implement also.
 * inner static helper class
 */
public class InnerClassBillPughSingleton {
	 
    private InnerClassBillPughSingleton(){}
     
    private static class SingletonHelper{
        private final static InnerClassBillPughSingleton INSTANCE = new InnerClassBillPughSingleton();
    }
     
    public static InnerClassBillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}