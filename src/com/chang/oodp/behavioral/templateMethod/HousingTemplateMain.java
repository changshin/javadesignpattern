package com.chang.oodp.behavioral.templateMethod;

public class HousingTemplateMain {
	public static void main(String[] args) {

		HouseTemplate houseType = new WoodenHouse();

		// using template method
		houseType.buildHouse();
		System.out.println("************");

		houseType = new GlassHouse();

		houseType.buildHouse();
	}

}

class WoodenHouse extends HouseTemplate {
	@Override
	public void buildWalls() {
		System.out.println("Building glass Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with glass coating");
	}

}

class GlassHouse extends HouseTemplate {
	//@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	//@Override
	public void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}

}

abstract class HouseTemplate {
	// template method, final so subclasses can't override
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	// default implementation
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}

	// methods to be implemented by subclasses
	public abstract void buildWalls();

	public abstract void buildPillars();

	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}

}
