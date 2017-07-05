package com.chang.oodp.behavioral.observer2;

import java.util.Observable;
import java.util.Observer;

public class SpyObserverManin {
    public static void main(String[] args) {
        Watcher watcher = new Watcher();
        Employee pc1 = new Employee("Emp 1");
        Employee pc2 = new Employee("Emp 2");
        Employee pc3 = new Employee("Emp 3");
        //spy monitor pc3 and report pc3
        Spy spy = new Spy(pc3);
        
        watcher.addObserver(pc1);
        watcher.addObserver(pc2);
        watcher.addObserver(pc3);
        watcher.addObserver(spy);
        watcher.action("Boss is comming");
        
        watcher.deleteObserver(pc2);
        //watcher.deleteObserver(spy);
        watcher.action("CEO is comming");
    }
}

class Watcher extends Observable {
    public void action(Object message) {
        System.out.println("======="+message+"========");
        // Marks this Observable object as having been changed; the hasChanged method will now return true.
        setChanged();
        // Each observer has its update method called with two arguments: this observable object and the arg argument.
        notifyObservers(message);
    }
}

class Spy implements Observer {
    private Employee employee;
    public Spy(Employee employee) {
        this.employee = employee;
    }
    // This method is called whenever the observed object is changed. 
    // An application calls an Observable object's notifyObservers method to have all the object's observers notified of the change.
    public void update(Observable o, Object arg) {
        if (o instanceof Watcher) {
            System.out.println("Spy report "+employee.getName() +" is not working.");
        }
    }
}

class Employee implements Observer {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    public void update(Observable o, Object arg) {	// from Observer
        if (o instanceof Watcher) {
            System.out.println(name + " is pretending to work," + (String)arg);
        }
    }
    public String getName() {
        return name;
    }
}
