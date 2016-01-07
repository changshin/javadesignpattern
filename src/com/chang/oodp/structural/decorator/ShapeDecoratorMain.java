package com.chang.oodp.structural.decorator;

public class ShapeDecoratorMain {
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("====Circle with normal border");
		circle.draw();

		System.out.println("\n====Circle of red border");
		redCircle.draw();

		System.out.println("\n====Rectangle of red border");
		redRectangle.draw();
	}
}

class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}

class ShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}
}


class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}
}

interface Shape {
	void draw();
}