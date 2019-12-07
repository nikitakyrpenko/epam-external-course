package task_2.task2_1.Model.Entities;

import task_2.task2_1.Model.Entities.Abstract.Shape;

public class Rectangle extends Shape {
    private double w, h;

    public Rectangle(String shapeColor, double w, double h){
        super(shapeColor);
        this.w = w;
        this.h = h;
    }

    public double getWeight(){ return w; }
    public double getHeight() {return h; }

    public void setWeight(double w) {this.w = w;}
    public void setHeight(double h) {this.h = h;}

    @Override
    public double calcArea() { return w * h; }

    @Override
    public String toString() { return super.toString() + "; w= "+ w + "; h= "+h; }

    public String draw() { return this.toString() + "; area= " + calcArea(); }
}
