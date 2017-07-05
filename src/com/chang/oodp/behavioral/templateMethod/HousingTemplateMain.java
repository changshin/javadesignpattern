package com.chang.oodp.behavioral.templateMethod;

import java.util.ArrayList;
import java.util.List;

public class HousingTemplateMain {
	public static void main(String[] args) {

		HouseTemplate woodHouse = new WoodenHouse();
		//woodHouse.buildHouse();
		HouseTemplate glassHouse = new GlassHouse();
		//glassHouse.buildHouse();

		List<HouseTemplate> houses = new ArrayList<HouseTemplate>();
		houses.add(woodHouse);
		houses.add(glassHouse);
		for ( HouseTemplate houseTemplate: houses ) {
			houseTemplate.buildHouse();
		}
	}

}

class WoodenHouse extends HouseTemplate {
	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with wood coating");
	}

}

class GlassHouse extends HouseTemplate {
	//@Override
	public void buildWalls() {
		System.out.println("Building glass Walls");
	}

	//@Override
	public void buildPillars() {
		System.out.println("Building Pillars with glass coating");
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
