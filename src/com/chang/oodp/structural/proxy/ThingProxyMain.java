package com.chang.oodp.structural.proxy;

import java.util.Date;

// http://www.avajava.com/tutorials/lessons/proxy-pattern.html?page=1
public class ThingProxyMain {
	public static void main(String[] args) {

		Proxy proxy = new Proxy();

		FastThing fastThing = new FastThing();
		fastThing.sayHello();
		proxy.sayHello();


	}
}

class Proxy {

	SlowThing slowThing;
	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void sayHello() {
		if (slowThing == null) {
			slowThing = new SlowThing();
		}
		slowThing.sayHello();
	}

}


class FastThing extends Thing {
	public FastThing() {
	}

}

class SlowThing extends Thing {
	public SlowThing() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

abstract class Thing {
	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " says howdy at " + new Date());
	}
}