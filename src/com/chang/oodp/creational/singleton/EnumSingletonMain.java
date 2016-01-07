package com.chang.oodp.creational.singleton;


// http://java.dzone.com/articles/singleton-design-pattern-%E2%80%93
// Enum is thread safe and implementation of Singleton through Enum ensures 
// that your singleton will have only one instance even in a multithreaded environment.
enum SingletonEnum {
	INSTANCE;
	static String output;
	public void doStuff() {
		System.out.println("Singleton using Enum");
	}
	public static String getOutput() {
		if ( output == null ) {
			synchronized (SingletonEnum.class) {
				output = "testing";
				System.out.println("output is created");
            }
		} else {
			System.out.println("output is not null");
		}
		return output;
	}
}

public class EnumSingletonMain {
	public static void main(String[] args) {
		SingletonEnum.INSTANCE.doStuff();
		String output = SingletonEnum.INSTANCE.getOutput();
		System.out.println("output="+output);
		output = SingletonEnum.INSTANCE.getOutput();
		System.out.println("output="+output);
	}
}
