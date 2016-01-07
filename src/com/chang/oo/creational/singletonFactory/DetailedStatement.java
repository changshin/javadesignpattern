package com.chang.oo.creational.singletonFactory;

public class DetailedStatement implements StatementType {
    @Override
    public String print() {
        System.out.println("Detailed Statement Created");
        return "detailedStmt";
    }
}