package com.chang.oodp.behavioral.command;

// https://dzone.com/articles/design-patterns-command
// client
public class LightOnOffMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    RemoteControl control = new RemoteControl();
	    Light light = new Light();
	    Command lightsOn = new LightOnCommand(light);
	    Command lightsOff = new LightOffCommand(light);

	    //switch on
	    control.setCommand(lightsOn);
	    control.pressButton();

	    //switch off
	    control.setCommand(lightsOff);
	    control.pressButton();
	}

}

//Invoker
class RemoteControl{
	private Command command;
	public void setCommand(Command command){
		this.command = command;
	}

	public void pressButton(){
		System.out.println("RemoteControl, pressButton.");
		command.execute();
	}
}



//Concrete Command
class LightOffCommand implements Command{
	//reference to the light
	Light light;
	public LightOffCommand(Light light){
		this.light = light;
	}

	public void execute(){
		light.switchOff();
	}

}

//Concrete Command
class LightOnCommand implements Command{
	//reference to the light
	Light light;

	public LightOnCommand(Light light){
	  this.light = light;
  	}

  	public void execute(){
	  light.switchOn();
   	}

}

//receiver
class Light{

	private boolean on;
	public void switchOn(){
		System.out.println("Light is on.");
	    on = true;
	}

	public void switchOff(){
		System.out.println("Light is off.");
	    on = false;
	}
}