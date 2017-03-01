package com.chang.oodp.behavioral.command;

import java.util.ArrayList;
import java.util.List;

// http://codereview.stackexchange.com/questions/52110/command-pattern-implementation
public class StockBuySellCommandMain {
	public static void main(String[] args) {
		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}
}

class Broker {
	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {
		orderList.add(order);
	}

	public void placeOrders() {

		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}


class SellStock implements Order {
	private Stock aStock;

	public SellStock(Stock aStock) {
		this.aStock = aStock;
	}

	public void execute() {
		aStock.sell();
	}
}

class BuyStock implements Order {
	private Stock aStock;

	public BuyStock(Stock aStock) {
		this.aStock = aStock;
	}

	public void execute() {
		aStock.buy();
	}
}
interface Order {
	void execute();
}

class Stock {

	private String name = "ABC";
	private int quantity = 10;

	public void buy(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
	   }

	public void sell(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
	   }
}

