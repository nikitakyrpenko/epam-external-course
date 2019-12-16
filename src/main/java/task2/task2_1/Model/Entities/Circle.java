package task2.task2_1.Model.Entities;

import task2.task2_1.Model.Entities.Abstract.Shape;

public class Circle extends Shape {

    private double radius;
    private static final double  PI = Math.PI;

    public Circle(String shapeColor, double radius){
        super(shapeColor);
        this.radius = radius;
    }

    public double getRadius(){ return radius;}
    public void setRadius(double radius){this.radius = radius;}

    @Override
    public double calcArea() { return PI * radius * radius; }

    @Override
    public String toString() {
        return super.toString() + "; radius= "+radius;
    }


}
