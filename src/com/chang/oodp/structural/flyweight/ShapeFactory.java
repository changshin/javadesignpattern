package com.chang.oodp.structural.flyweight;

import java.util.HashMap;

public class ShapeFactory {
 
    private static final HashMap<ShapeType,Shape> shapes = new HashMap<ShapeType,Shape>();
 
    public static Shape getShape(ShapeType type) {
        Shape shape = shapes.get(type);
 
        if (shape == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
            	shape = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
            	shape = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
            	shape = new Line();
            }
            shapes.put(type, shape);
        }
        return shape;
    }
     
    public static enum ShapeType{
        OVAL_FILL,OVAL_NOFILL,LINE;
    }
}
