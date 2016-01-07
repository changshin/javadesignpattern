package com.chang.oodp.structural.adapter2;

public interface Account {
    public double getBalance();    
    public boolean isOverdraftAvailable();    
    public void credit(final double credit);
}