package com.chang.oodp.creational.factory;

//http://www.journaldev.com/1418/abstract-factory-design-pattern-in-java

public class ComputerAbstractFactoryMain {
	public static void main(String[] args) {
        Computer pc = ComputerAbstractFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        Computer server = ComputerAbstractFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
        pc = ComputerAbstractFactory.getComputer(new PCFactory2( new PC("2 GB","500 GB","2.4 GHz")));
        server = ComputerAbstractFactory.getComputer(new ServerFactory2( new Server("16 GB","1 TB","2.9 GHz")));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}

class ComputerAbstractFactory {
	public static Computer getComputer(ComputerFactoryInterface factory) {
		return factory.createComputer();
	}
}

class ServerFactory implements ComputerFactoryInterface {
	 
    private String ram;
    private String hdd;
    private String cpu;
     
    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
     
    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }
 
}

class PCFactory implements ComputerFactoryInterface {
	 
    private String ram;
    private String hdd;
    private String cpu;
     
    public PCFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public Computer createComputer() {
        return new PC(ram,hdd,cpu);
    }
 
}

class ServerFactory2 implements ComputerFactoryInterface {
	 
    private Server server;
     
    public ServerFactory2(Server server){
        this.server = server;
    }
    @Override
    public Computer createComputer() {
        return this.server;
    }
 
}

class PCFactory2 implements ComputerFactoryInterface {
	 
    private PC pc;
     
    public PCFactory2(PC pc){
        this.pc = pc;
    }
    @Override
    public Computer createComputer() {
        return this.pc;
    }
 
}


interface ComputerFactoryInterface {
	public Computer createComputer();
}
