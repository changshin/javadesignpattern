package com.chang.oodp.behavioral.state;

public class StateActionMain {
	public static void main(String[] args) {
	      Context context = new Context();

	      StartState startState = new StartState();
	      startState.doAction(context);
	      System.out.println(context.getState2().toString());

	      StopState stopState = new StopState();
	      stopState.doAction(context);
	      System.out.println(context.getState2().toString());
	   }
}

class Context {
	   private State2 state2;

	   public Context(){
	      state2 = null;
	   }

	   public void setState2(State2 state2){
	      this.state2 = state2;		
	   }

	   public State2 getState2(){
	      return state2;
	   }
}
class StartState implements State2 {

	   public void doAction(Context context) {
	      System.out.println("Player is in start state");
	      context.setState2(this);	
	   }

	   public String toString(){
	      return "Start State";
	   }
}
class StopState implements State2 {

	   public void doAction(Context context) {
	      System.out.println("Player is in stop state");
	      context.setState2(this);	
	   }

	   public String toString(){
	      return "Stop State";
	   }
}
interface State2 {
	   public void doAction(Context context);
	}