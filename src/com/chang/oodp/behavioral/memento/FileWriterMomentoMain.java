package com.chang.oodp.behavioral.memento;


// http://www.journaldev.com/1734/memento-design-pattern-in-java-example-tutorial
	
public class FileWriterMomentoMain {
	public static void main(String[] args) {

		FileWriterCaretaker caretaker = new FileWriterCaretaker();

		FileWriter fileWriter = new FileWriter("data.txt");
		fileWriter.add("First Set of Data");
		System.out.println(fileWriter);

		// lets save the file
		caretaker.save(fileWriter);
		// now write something else
		fileWriter.add(", Second Set of Data");

		// checking file contents
		System.out.println("before undo="+fileWriter);

		// lets undo to last save
		caretaker.undo(fileWriter);

		// checking file content again
		System.out.println("after="+fileWriter);

	}

}

class FileWriter {
	private String fileName;
    private StringBuilder content;
     
    public FileWriter(String file){
        this.fileName=file;
        this.content=new StringBuilder();
    }
     
    @Override
    public String toString(){
        return this.content.toString();
    }
     
    public void add(String str){
        content.append(str);
    }
     
    public Memento save(){
        return new Memento(this.fileName,this.content);
    }
     
    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.fileName = memento.fileName;
        this.content  = memento.content;
        //System.out.println("fileWriter,undoToLastSave="+this.content.toString());
    }
     
     
    private class Memento{
        private String fileName;
        private StringBuilder content;
         
        public Memento(String file, StringBuilder content){
            this.fileName=file;
            //notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
            this.content = new StringBuilder(content);
            //this.content = content;	// DOES NOT WORK
        }
    }

}


class FileWriterCaretaker {
	private Object obj;
    
    public void save(FileWriter fileWriter){
    	//System.out.println("caretaker,save="+fileWriter.toString());
        this.obj = fileWriter.save();
    }
     
    public void undo(FileWriter fileWriter){
    	//System.out.println("caretaker,undo2="+fileWriter.toString());
        fileWriter.undoToLastSave(obj);
    	//System.out.println("caretaker,undo3="+fileWriter.toString());
    }

}
