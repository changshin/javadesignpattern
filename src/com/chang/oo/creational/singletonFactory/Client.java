package com.chang.oo.creational.singletonFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// http://java.dzone.com/articles/singleton-design-pattern-%E2%80%93?page=0,1

public class Client {
	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter your selection:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String selection = null;
			try {
				selection = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Factory factory = StatementFactory.getUniqueInstance();
			StatementType objStmtType = factory.createStatements(selection);
			System.out.println(objStmtType.print());
		}
	}
}
