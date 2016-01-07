package com.chang.oo.creational.singletonFactory;

public class StatementFactory extends Factory {
	private static volatile StatementFactory uniqueInstance;

	private StatementFactory() {
	}

	public static StatementFactory getUniqueInstance() {
		if (uniqueInstance == null) {
			synchronized(StatementFactory.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new StatementFactory();
					System.out.println("Creating a new StatementFactory instance");
				}
			}
		}
		return uniqueInstance;

	}

	public StatementType createStatements(String selection) {
		if (selection.equalsIgnoreCase("detailedStmt")) {
			return new DetailedStatement();
		} else if (selection.equalsIgnoreCase("miniStmt")) {
			return new MiniStatement();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}