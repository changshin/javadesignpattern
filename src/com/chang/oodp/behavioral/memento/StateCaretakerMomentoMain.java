package com.chang.oodp.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

// http://www.tutorialspoint.com/design_pattern/memento_pattern.htm

public class StateCaretakerMomentoMain {
	public static void main(String[] args) {

		CareTaker careTaker = new CareTaker();
		Originator originator = new Originator();

		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		System.out.println("Current State: " + originator.getState());

		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());

		careTaker = new CareTaker();
		Originator2 originator2 = new Originator2();

		originator2.setState(careTaker,"State2 #1");
		originator2.setState(careTaker,"State2 #2");
		originator2.setState(careTaker,"State2 #3");

		originator2.setState(careTaker,"State2 #4");
		System.out.println("Current State2: " + originator2.getState());

		originator2.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State2: " + originator2.getState());
		originator2.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State2: " + originator2.getState());

		originator2.getStateFromMemento(careTaker.getLatest());
		System.out.println("latest State2: " + originator2.getState());
		originator2.getStateFromMemento(careTaker.getLatest());
		System.out.println("latest State2: " + originator2.getState());

	}
}

class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
	public Memento getLatest() {
		Memento memento = mementoList.get(mementoList.size()-1);
		mementoList.remove(memento);
		return memento;
	}
}

class Originator2 {
	private String state;
	public void setState(CareTaker careTaker,String state) {
		this.state = state;
		careTaker.add(saveStateToMemento());
	}

	public String getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		System.out.println("Originator,saveStateToMemento,state="+state);
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Memento) {
		state = Memento.getState();
	}
}

class Originator {
	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		System.out.println("Originator,saveStateToMemento,state="+state);
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Memento) {
		state = Memento.getState();
	}
}

class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}