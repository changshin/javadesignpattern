package com.chang.oodp.structural.proxy;

public class CommandProxyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandExecutor executor = new CommandExecutorProxy("chang", "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
            e.printStackTrace();
        }

	}

}
