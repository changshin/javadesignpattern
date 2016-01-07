package com.chang.oo.abstrct;

abstract class Employee {
	private String name;
   	private String address;
	protected double salary;
	public Employee(String name, String address, double salary) {
		this.name = name;
	    this.address = address;
	    this.salary = salary;
	}
	public abstract double raise(); // abstract method
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	   
}

class Secretary extends Employee {
    Secretary(String name, String address,double salary) {
       	super(name, address, salary);
	}
	public double raise(){
	    return salary;
    }
}


class Salesman  extends Employee{
    private double commission;
    public Salesman(String name, String address, double salary, double commission) {
	     super(name, address, salary);
	     this.commission=commission;
	}
    public double raise() {
         salary = salary + commission;
         return salary;
    }
}

class Manager extends  Employee {
    Manager(String name, String address,double salary) {
        super(name, address, salary);
    }
    public double raise(){
        salary = salary + salary * .05;
        return salary;
    }
}

class Worker extends Employee {
    Worker(String name, String address, double salary) {
         super(name, address, salary);
    }
    public double raise() {
        salary = salary + salary * .02;
        return salary;
    }
}

public class AbstractMain {
	public static void main(String[] args) {
		Secretary a = new Secretary("amir","tehran",1000);
	    Manager b = new Manager("hossein","shiraz",2000);
	    Worker c = new Worker("reza","tehran",1000);
	    Salesman d = new Salesman("danial","mashhad",1500,200);

	    Employee[] ArrayEmployee=new Employee[4];
	    ArrayEmployee[0]=a;
	    ArrayEmployee[1]=b;
	    ArrayEmployee[2]=c;
	    ArrayEmployee[3]=d;

        for(int i=0;i<ArrayEmployee.length;i++){
            double s=ArrayEmployee[i].raise();
            System.out.println("final salary"+" "+s+":"+ArrayEmployee[i].getName());
            if  ( ArrayEmployee[i] instanceof Manager ) {
            	System.out.println(ArrayEmployee[i].getName() + " is manager.");
            }
        }
    }
}
