package com.chang.oodp.creational.factory;

public class CurrencyFactoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String country = "India";	//args[0];
		Currency rupee = CurrencyFactory.createCurrency(country);
		System.out.println(rupee.getSymbol());

	}

}

// Factroy Class code
class CurrencyFactory {

	public static Currency createCurrency(String country) {
		if (country.equalsIgnoreCase("India")) {
			return new Rupee();
		} else if (country.equalsIgnoreCase("Singapore")) {
			return new SGDDollar();
		} else if (country.equalsIgnoreCase("US")) {
			return new USDollar();
		}
		throw new IllegalArgumentException("No such currency");
	}
}


// Concrete Rupee Class code
class Rupee implements Currency {
	@Override
	public String getSymbol() {
		return "Rs";
	}
}

// Concrete SGD class Code
class SGDDollar implements Currency {
	@Override
	public String getSymbol() {
		return "SGD";
	}
}

// Concrete US Dollar code
class USDollar implements Currency {
	@Override
	public String getSymbol() {
		return "USD";
	}
}

interface Currency {
	String getSymbol();
}
