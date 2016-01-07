package com.chang.oodp.structural.adapter2;

public class AccountAdapter extends AbstractAccount {

	// Adaptee - The class we are adapting from
	private AccountOffshore offshoreAccount;

	/**
	 * 
	 * @param offshoreAccount
	 *            the instance of OffshoreAccount we are going to adapt from.
	 */
	public AccountAdapter(final AccountOffshore offshoreAccount) {
		super(offshoreAccount.getOffshoreBalance());

		// holds adaptee reference
		this.offshoreAccount = offshoreAccount;
	}

	/**
	 * Calculate offshore account balance after deducting the tax owed for
	 * offshore account
	 */
	@Override
	public double getBalance() {
		final double taxRate = offshoreAccount.getTaxRate();
		final double grossBalance = super.getBalance();

		final double taxableBalance = grossBalance * taxRate;
		final double balanceAfterTax = grossBalance - taxableBalance;
		return balanceAfterTax;
	}
}