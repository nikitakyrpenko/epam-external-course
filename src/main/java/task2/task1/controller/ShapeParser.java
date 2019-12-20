package task2.task1.controller;

import task2.task1.model.entities.abstracts.Shape;
import task2.task1.model.entities.abstracts.ShapeType;
import task2.task1.model.entities.Circle;
import task2.task1.model.entities.Rectangle;
import task2.task1.model.entities.Triangle;

public class ShapeParser {

    public static Shape parse (String shape){
        String type = shape.substring(0, shape.indexOf(":")).toUpperCase();
        Shape result = null;
        switch (ShapeType.valueOf(type)){
            case CIRCLE:
                result = Circle.parseString(shape);
                return result;
            case TRIANGLE:
                result = Triangle.parseString(shape);
                return result;
            case RECTANGLE:
                result = Rectangle.parseString(shape);
                return result;

        }
        return result;
    }
}
