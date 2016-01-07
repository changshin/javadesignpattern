package com.chang.oodp.behavioral.command;

public interface FileSystemReceiver {
	void openFile();
    void writeFile();
    void closeFile();
    void deleteFile();

}
