package com.chang.oodp.behavioral.chainResponsibility;

import java.util.Scanner;

public class ATMDispenseChainMain {
	private DispenseChain c50;

	public ATMDispenseChainMain() {
		// initialize the chain
		this.c50 = new Dollar50Dispenser();
		DispenseChain c20 = new Dollar20Dispenser();
		DispenseChain c10 = new Dollar10Dispenser();
		DispenseChain c1 = new DollarDispenser();

		// set the chain of responsibility
		c50.setNextChain(c20);
		c20.setNextChain(c10);
		c10.setNextChain(c1);
	}

	public static DispenseChain getATMDispenseChainMain2() {
		// initialize the chain
		DispenseChain c50 = new DollarsDispenser(50);
		DispenseChain c20 = new DollarsDispenser(20);
		DispenseChain c10 = new DollarsDispenser(10);
		DispenseChain c1 = new DollarDispenser();

		// set the chain of responsibility
		c50.setNextChain(c20);
		c20.setNextChain(c10);
		c10.setNextChain(c1);
		return c50;
	}

	public static void main(String[] args) {
		ATMDispenseChainMain atmDispenser = new ATMDispenseChainMain();
		DispenseChain c50 = getATMDispenseChainMain2();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			//if (amount % 10 != 0) {
			//	System.out.println("Amount should be in multiple of 10s.");
			//	return;
			//}
			// process the request
			atmDispenser.c50.dispense(new Currency(amount));
			
			System.out.println();
			c50.dispense(new Currency(amount));
		}

	}

}

class DollarsDispenser implements DispenseChain {
	private DispenseChain chain;
	private int amount = 50;
	public DollarsDispenser(int amount){
        this.amount = amount;
    }
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= amount) {
			int num = currency.getAmount() / amount;
			int remainder = currency.getAmount() % amount;
			System.out.println("Dispensing " + num + " "+ amount + "$ note");
			if ( remainder != 0 )
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(currency);
		}
	}

}


class Dollar50Dispenser implements DispenseChain {
	private DispenseChain chain;
	private int amount = 50;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= amount) {
			int num = currency.getAmount() / amount;
			int remainder = currency.getAmount() % amount;
			System.out.println("Dispensing " + num + " "+ amount + "$ note");
			if ( remainder != 0 )
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(currency);
		}
	}

}

class Dollar20Dispenser implements DispenseChain {
	private DispenseChain chain;
	private int amount = 20;
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= amount) {
			int num = currency.getAmount() / amount;
			int remainder = currency.getAmount() % amount;
			System.out.println("Dispensing " + num + " "+ amount + "$ note");
			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(currency);
		}
	}

}

class Dollar10Dispenser implements DispenseChain {
	private DispenseChain chain;
	private int amount = 10;
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= amount) {
			int num = currency.getAmount() / amount;
			int remainder = currency.getAmount() % amount;
			System.out.println("Dispensing " + num + " " + amount + "$ note");
			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(currency);
		}
	}

}

class DollarDispenser implements DispenseChain {
	private DispenseChain chain;
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency currency) {
		if (currency.getAmount() >= 0) {
			System.out.println("Dispensing " + currency.getAmount() + " 1$ note");
		}
	}
}

interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}

class Currency {
	private int amount;
    
	public Currency(int amt){
        this.amount=amt;
    }
     
    public int getAmount(){
        return this.amount;
    }
}

