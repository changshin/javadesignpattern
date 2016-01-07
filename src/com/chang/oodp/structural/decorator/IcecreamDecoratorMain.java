package com.chang.oodp.structural.decorator;

// http://javapapers.com/design-patterns/decorator-pattern/
public class IcecreamDecoratorMain {
	public static void main(String args[]) {
		Icecream icecream = new HoneyDecorator(new NuttyDecorator(
				new SimpleIcecream()));
		System.out.println(icecream.makeIcecream());
	}
}

class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addHoney();
	}

	private String addHoney() {
		return " + sweet honey";
	}
}

class NuttyDecorator extends IcecreamDecorator {

	public NuttyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addNuts();
	}

	private String addNuts() {
		return " + cruncy nuts";
	}
}

class IcecreamDecorator implements Icecream {

	protected Icecream specialIcecream;

	public IcecreamDecorator(Icecream specialIcecream) {
		this.specialIcecream = specialIcecream;
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream();
	}
}

class SimpleIcecream implements Icecream {

	@Override
	public String makeIcecream() {
		return "Base Icecream";
	}

}

interface Icecream {
	public String makeIcecream();
}