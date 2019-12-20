package task2.task2_1.model.entities;

import task2.task2_1.model.entities.abstracts.Shape;

public class Circle extends Shape {

    private double radius;
    private static final double  PI = Math.PI;

    public Circle(String shapeColor, double radius){
        super(shapeColor);
        this.radius = radius;
    }


    @Override
    public double calcArea() { return PI * radius * radius; }

    @Override
    public String toString() {
        return super.toString() + "; radius= "+radius;
    }


    public static Circle parseString(String data){
        String[] tokens = data.split("[:,]");
        return new Circle(tokens[1], Double.parseDouble(tokens[2]));
    }
}
