package com.chang.oodp.structural.bridge;

public class TVRemoteControllerMain {
	public static void main(String[] args){
		TV tv = new SonyTV();
		LogitechRemoteControl logitechRemoteControl = new LogitechRemoteControl(tv);
		logitechRemoteControl.setChannelKeyboard(100);	
	}
}

class LogitechRemoteControl extends RemoteControl {
	 
	public LogitechRemoteControl(TV tv) {
		super(tv);
	}
	
	public void setChannelKeyboard(int channel){
		setChannel(channel);
		System.out.println("Logitech use keyboard to set channel.");
	}
}

// generic remote controll
class RemoteControl {
	
	private TV tv;
 
	public RemoteControl(TV tv){
		this.tv = tv;
	}
 
	public void turnOn(){
		tv.on();
	}
 
	public void turnOff(){
		tv.off();
	}
	
	public void setChannel(int channel){
		System.out.println("AbstractRemoteControl, setChannel() is called.");
		tv.switchChannel(channel);
	}
}

class SonyTV implements TV {
	 
	@Override
	public void on() {
		System.out.println("Sony is turned on.");
	}
 
	@Override
	public void off() {
		System.out.println("Sony is turned off.");
	}
 
	@Override
	public void switchChannel(int channel) {
		System.out.println("Sony: channel - " + channel);
	}
}

class SamsungTV implements TV {
	@Override
	public void on() {
		System.out.println("Samsung is turned on.");
	}
 
	@Override
	public void off() {
		System.out.println("Samsung is turned off.");
	}
 
	@Override
	public void switchChannel(int channel) {
		System.out.println("Samsung: channel - " + channel);
	}
}

interface TV {
	public void on();
	public void off();
	public void switchChannel(int channel);
}