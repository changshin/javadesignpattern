package com.chang.oodp.structural.adapter2;

public class AccountStandard extends AbstractAccount {

	public AccountStandard(final double balance) {
		super(balance);
		setOverdraftAvailable(false);
	}
}