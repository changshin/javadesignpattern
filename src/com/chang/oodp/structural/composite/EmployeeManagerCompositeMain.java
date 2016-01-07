package com.chang.oodp.structural.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// http://java.dzone.com/articles/composite-design-pattern-java-0
// http://www.java2novice.com/java-design-patterns/composite-pattern/

public class EmployeeManagerCompositeMain {
	public static void main(String[] args) {
		Employee emp1 = new Developer("John", 10000);
		Employee emp2 = new Developer("David", 15000);
		Employee manager1 = new Manager("Daniel", 25000);
		manager1.add(emp1);
		manager1.add(emp2);
		Employee emp3 = new Developer("Michael", 20000);
		Manager generalManager = new Manager("Mark", 50000);
		generalManager.add(emp3);
		generalManager.add(manager1);
		generalManager.print();
	}
}


interface Employee {
	public void add(Employee employee);
	public void remove(Employee employee);
	public Employee getChild(int i);
	public String getName();
	public double getSalary();
	public void print();
}


class Developer implements Employee {

	private String name;
	private double salary;

	public Developer(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public void add(Employee employee) {
		// this is leaf node so this method is not applicable to this class.
	}

	public Employee getChild(int i) {
		// this is leaf node so this method is not applicable to this class.
		return null;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void print() {
		System.out.println("-------------");
		System.out.println("Name =" + getName());
		System.out.println("Salary =" + getSalary());
		System.out.println("-------------");
	}

	public void remove(Employee employee) {
		// this is leaf node so this method is not applicable to this class.
	}

}


class Manager implements Employee {

	private String name;
	private double salary;

	public Manager(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	List<Employee> employees = new ArrayList<Employee>();

	public void add(Employee employee) {
		employees.add(employee);
	}

	public Employee getChild(int i) {
		return employees.get(i);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void print() {
		System.out.println("-------------");
		System.out.println("Manager Name =" + getName());
		System.out.println("Salary =" + getSalary());
		System.out.println("-------------");

		Iterator<Employee> employeeIterator = employees.iterator();
		while (employeeIterator.hasNext()) {
			Employee employee = employeeIterator.next();
			employee.print();
		}
	}

	public void remove(Employee employee) {
		employees.remove(employee);
	}
}

