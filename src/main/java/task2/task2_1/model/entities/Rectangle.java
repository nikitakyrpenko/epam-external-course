package task2.task2_1.model.entities;

import task2.task2_1.model.entities.abstracts.Shape;

public class Rectangle extends Shape {
    private double w, h;

    public Rectangle(String shapeColor, double w, double h){
        super(shapeColor);
        this.w = w;
        this.h = h;
    }



    @Override
    public double calcArea() { return w * h; }

    @Override
    public String toString() { return super.toString() + "; w= "+ w + "; h= "+h; }

    public static Rectangle parseString(String data){
        String[] tokens = data.split("[:,]");
        return new Rectangle(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }


}
