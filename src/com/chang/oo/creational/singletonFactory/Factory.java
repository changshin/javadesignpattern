package com.chang.oo.creational.singletonFactory;

public abstract class Factory {
	protected abstract StatementType createStatements(String selection);
}