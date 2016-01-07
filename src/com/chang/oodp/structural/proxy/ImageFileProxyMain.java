package com.chang.oodp.structural.proxy;

// http://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
/*
 We are going to create an Image interface and concrete classes implementing the Image interface. \
ProxyImage is a a proxy class to reduce memory footprint of RealImage object loading.
ProxyPatternDemo, our demo class, will use ProxyImage to get an Image object to load and display as it needs.
 */
public class ImageFileProxyMain {
	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		// image will be loaded from disk
		image.display();
		System.out.println("");

		// image will not be loaded from disk
		image.display();
	}
}

class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}

class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}
}

interface Image {
	void display();
}