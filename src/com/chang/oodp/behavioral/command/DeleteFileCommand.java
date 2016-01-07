package com.chang.oodp.behavioral.command;

public class DeleteFileCommand implements Command {
	 
    private FileSystemReceiver fileSystem;
     
    public DeleteFileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.deleteFile();
    }
}
