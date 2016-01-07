package com.chang.oodp.behavioral.observer2;

import java.util.Observable;
import java.util.Observer;
public class Employee implements Observer {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    public void update(Observable o, Object arg) {	// from Observer
        if (o instanceof Watcher) {
            System.out.println(name + "이 일하는 척");
        }
    }
    public String getName() {
        return name;
    }
}