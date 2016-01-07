package com.chang.oodp.creational.factory;

// http://java.dzone.com/articles/design-patterns-abstract-factory
	
public class OSAbstractFatoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIBuilder guiBuilder = new GUIBuilder();
		WindowFactory windowFactory = null;
		// check what platform we're on
		String platform = "Mac";
		if (platform.equals("Mac")) {
			windowFactory = new MacWindowsFactory();
		} else {
			windowFactory = new MsWindowsFactory();
		}
		guiBuilder.buildWindow(windowFactory);
	}

}

class GUIBuilder {
	public void buildWindow(WindowFactory windowFactory) {
		Window window = windowFactory.createWindow();
		window.setTitle("New Window");
	}
}


class MsWindowsFactory implements WindowFactory{
	// create an MSWindow
	public Window createWindow() {
		MSWindow window = new MSWindow();
		return window;
	}
}


class MacWindowsFactory  implements WindowFactory{
	// create an MSWindow
	public Window createWindow() {
		MacWindow window = new MacWindow();
		return window;
	}
}

interface WindowFactory {
	public Window createWindow();
}


class MSWindow implements Window {
	public void setTitle(String text) {
		System.out.println("I am MS Windows, title=" + text);
	}

	public void repaint() {
		System.out.println("MS Windows repaint");
	}
}

class MacWindow implements Window {
	public void setTitle(String text) {
		System.out.println("I am Mac Windows. title=" + text);
	}

	public void repaint() {
		System.out.println("Mac Windows repaint");
	}

}

//Window
interface Window {
	public void setTitle(String text);

	public void repaint();
}
