package com.chang.oodp.structural.decorator;

public class CarDecoratorMain {
	public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        
        System.out.println("\n*****");         
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();

        System.out.println("\n*****");
        Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
        luxurySportsCar.assemble();

	}

}

class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
		System.out.println("SportsCar is called.");
	}

	@Override
	public void assemble() {
		car.assemble();
		System.out.println(" Adding features of Sports Car.");
	}
}

class LuxuryCar extends CarDecorator {
	public LuxuryCar(Car car) {
		super(car);
		System.out.println("LuxuryCar is called.");
	}

	@Override
	public void assemble() {
		car.assemble();
		System.out.println(" Adding features of Luxury Car.");
	}
}

class CarDecorator implements Car {
    protected Car car;
     
    public CarDecorator(Car car){
    	System.out.println("CarDecorator constructor is called.");
		this.car=car;
    }
     
    @Override
    public void assemble() {
    	System.out.println("CarDecorator assemble is called.");
        car.assemble();
    }
}


class BasicCar implements Car {
	@Override
    public void assemble() {
        System.out.println("Basic Car is assembled");
    }

}

interface Car {
	public void assemble();
}
