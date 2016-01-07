package com.chang.oodp.structural.decorator;

public class CarDecoratorMain {
	public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");
         
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();

        Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
        luxurySportsCar.assemble();

	}

}

class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
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
		this.car=car;
    }
     
    @Override
    public void assemble() {
        car.assemble();
    }
}


class BasicCar implements Car {
	@Override
    public void assemble() {
        System.out.println("Basic Car.");
    }

}

interface Car {
	public void assemble();
}
