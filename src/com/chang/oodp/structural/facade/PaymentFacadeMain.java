package com.chang.oodp.structural.facade;

// http://www.javacodegeeks.com/2012/11/facade-design-pattern-design-standpoint.html
public class PaymentFacadeMain {
	public static void main(String args[]) {
		OrderFacade orderFacade = new OrderFacade();
		orderFacade.placeOrder("OR123456");
		System.out.println("Order processing completed");
	}
}

class OrderFacade {
	private Payment pymt = new Payment();
	private Inventory inventry = new Inventory();

	public void placeOrder(String orderId) {
		String step1 = inventry.checkInventory(orderId);
		String step2 = pymt.deductPayment(orderId);
		System.out.println("Following steps completed:" + step1 
						+ " & " + step2);
	}
}

class Payment {
	public String deductPayment(String orderID) {
		return "Payment deducted successfully";

	}
}

class Inventory {
	public String checkInventory(String OrderId) {
		return "Inventory checked";
	}
}