package com.chang.oodp.structural.adapter2;

public class PlatinumAccount extends AbstractAccount {

	public PlatinumAccount(final double balance) {
		super(balance);
		setOverdraftAvailable(true);
	}
}