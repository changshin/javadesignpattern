package com.chang.oodp.structural.adapter;

// https://sourcemaking.com/design_patterns/adapter/java/1

class LegacyLine {
	public void draw(int x1, int y1, int x2, int y2) {
		System.out.println("line from (" + x1 + ',' + y1 + ") to (" + x2 + ','
				+ y2 + ')');
	}
}

class LegacyRectangle {
	public void draw(int x, int y, int w, int h) {
		System.out.println("rectangle at (" + x + ',' + y + ") with width " + w
				+ " and height " + h);
	}
}

interface Shape {
	void draw(int x1, int y1, int x2, int y2);
}

class Line implements Shape {
	private LegacyLine adaptee = new LegacyLine();

	public void draw(int x1, int y1, int x2, int y2) {
		adaptee.draw(x1, y1, x2, y2);
	}
}

class Rectangle implements Shape {
	private LegacyRectangle adaptee = new LegacyRectangle();

	public void draw(int x1, int y1, int x2, int y2) {
		adaptee.draw(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1),
				Math.abs(y2 - y1));
	}
}

public class LegacyShapeAdapterMain {
	public static void main(String[] args) {
		
		// before adapter
		Object[] shapes = { new LegacyLine(), new LegacyRectangle() };
		// A begin and end point from a graphical editor
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		for (int i = 0; i < shapes.length; ++i) {
			System.out.println("class name=" + shapes[i].getClass().getName());
			if (shapes[i].getClass().getName().contains("LegacyLine"))
				((LegacyLine) shapes[i]).draw(x1, y1, x2, y2);
			else if (shapes[i].getClass().getName().contains("LegacyRectangle"))
				((LegacyRectangle) shapes[i]).draw(Math.min(x1, x2),
						Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}
		
		// with Adapter
		Shape[] shapes2 = { new Line(), new Rectangle() };
		for (int i = 0; i < shapes2.length; ++i) {
			shapes2[i].draw(x1, y1, x2, y2);
		}
	}
}