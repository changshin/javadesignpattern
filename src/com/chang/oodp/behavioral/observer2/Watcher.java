package com.chang.oodp.behavioral.observer2;

import java.util.Observable;

// 변화를 통보하는 Observable
public class Watcher extends Observable {
    public void action(String string) {
        System.out.println("======="+string+"========");
        setChanged();
        //System.out.println("======="+string+"========");
        notifyObservers(string);
    }
}