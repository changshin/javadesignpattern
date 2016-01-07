package com.chang.oo.creational.singletonFactory;

public class MiniStatement implements StatementType {
    @Override
    public String print() {
        System.out.println("Mini Statement Created");
        return "miniStmt";
    }
}