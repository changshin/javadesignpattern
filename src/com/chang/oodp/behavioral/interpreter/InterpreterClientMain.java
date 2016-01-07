package com.chang.oodp.behavioral.interpreter;

public class InterpreterClientMain {

	public InterpreterContext ic;

	public InterpreterClientMain(InterpreterContext i) {
		this.ic = i;
	}

	public String interpret(String str) {
		Expression exp = null;
		// create rules for expressions
		if (str.contains("Hexadecimal")) {
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		} else if (str.contains("Binary")) {
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		} else
			return str;
		System.out.println("interpret str=" +str);
		return exp.interpret(ic);
	}

	public static void main(String args[]) {
		String str1 = "28 in Binary";
		String str2 = "28 in Hexadecimal";

		InterpreterClientMain ec = new InterpreterClientMain(new InterpreterContext());
		System.out.println(str1 + "= " + ec.interpret(str1));
		System.out.println(str2 + "= " + ec.interpret(str2));

	}
}
