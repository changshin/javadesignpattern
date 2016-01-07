package com.chang.oodp.behavioral.state;

public class TVRemoteWithStateMain {

	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();

		context.setState(tvStartState);
		context.doAction();

		context.setState(tvStopState);
		context.doAction();

	}

}

class TVContext implements State {

	private State tvState;

	public void setState(State state) {
		this.tvState = state;
	}

	public State getState() {
		return this.tvState;
	}

	@Override
	public void doAction() {
		this.tvState.doAction();
	}

}

class TVStopState implements State {

	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}

}

class TVStartState implements State {

	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}

}

interface State {
	public void doAction();
}
