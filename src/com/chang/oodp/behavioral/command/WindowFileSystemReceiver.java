package com.chang.oodp.behavioral.command;

public class WindowFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening file in Window OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Writing file in Window OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing file in Window OS");
	}
	
	@Override
	public void deleteFile() {
		System.out.println("Deleting file in Window OS");
	}

}
