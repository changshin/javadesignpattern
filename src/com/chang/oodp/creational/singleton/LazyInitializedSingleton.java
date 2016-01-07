package com.chang.oodp.creational.singleton;

/*
 * The above implementation works fine in case of single threaded environment 
 * but when it comes to multithreaded systems, it can cause issues if multiple threads are inside the if loop at the same time. 
 * It will destroy the singleton pattern and both threads will get the different instances of singleton class. 
 * In next section, we will see different ways to create a thread-safe singleton class.
 */
public class LazyInitializedSingleton {
	 
    private static LazyInitializedSingleton instance;
     
    private LazyInitializedSingleton(){}
     
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}