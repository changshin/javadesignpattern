package com.chang.oodp.behavioral.visitor;

public class ShoppingCartVisitorMain {

	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[] { new Book(20, "1234"),
				new Book(100, "5678"), new Fruit(10, 2, "Banana"),
				new Fruit(5, 5, "Apple") };

		int total = calculatePrice(items);
		System.out.println("Total Cost = " + total);
	}

	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartItem cartItem = new ShoppingCartItemImpl();
		int sum = 0;
		for (ItemElement item : items) {
			sum = sum + item.getCost(cartItem);
		}
		return sum;
	}

}

class ShoppingCartItemImpl implements ShoppingCartItem {

	@Override
	public int getCost(Book book) {
		int cost = 0;
		// apply 5$ discount if book price is greater than 50
		if (book.getPrice() > 50) {
			cost = book.getPrice() - 5;
		} else
			cost = book.getPrice();
		System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost ="	+ cost);
		return cost;
	}

	@Override
	public int getCost(Fruit fruit) {
		int cost = fruit.getPricePerKg() * fruit.getWeight();
		System.out.println(fruit.getName() + " cost = " + cost);
		return cost;
	}

}
interface ShoppingCartItem {
	int getCost(Book book);
	int getCost(Fruit fruit);
}


class Book implements ItemElement {

	private int price;
	private String isbnNumber;

	public Book(int cost, String isbn) {
		this.price = cost;
		this.isbnNumber = isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	@Override
	public int getCost(ShoppingCartItem shoppingCartItem) {
		return shoppingCartItem.getCost(this);
	}

}


class Fruit implements ItemElement {

	private int pricePerKg;
	private int weight;
	private String name;

	public Fruit(int priceKg, int wt, String nm) {
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}

	public int getPricePerKg() {
		return pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int getCost(ShoppingCartItem shoppingCartItem) {
		return shoppingCartItem.getCost(this);
	}

}

interface ItemElement {
	// public int accept(ShoppingCartItem cartItem);
	public int getCost(ShoppingCartItem cartItem);
}
