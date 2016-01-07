package com.chang.oodp.structural.adapter2;

// http://javatechig.com/design-patterns/adapter-design-pattern-in-java

public class AccountAdapterTest {
	public static void main(String[] args) {

		AccountStandard sa = new AccountStandard(2000);
		System.out.println("Account Balance= " + sa.getBalance());
		
		//Calling getBalance() on Adapter
		AccountAdapter adapter = new AccountAdapter(new AccountOffshore(2000));
		System.out.println("Account Balance= " + adapter.getBalance());		
	}
}
