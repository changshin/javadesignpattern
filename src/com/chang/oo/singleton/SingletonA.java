package com.chang.oo.singleton;

class A {    

    private static A singleton = new A();

    private A() {}

    public static A getInstance() {
        return singleton;
    }
}
public class SingletonA {
	
	public static void main(String[] args) {
		A a = A.getInstance();
	}
}