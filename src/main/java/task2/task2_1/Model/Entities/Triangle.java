package task2.task2_1.Model.Entities;

import task2.task2_1.Model.Entities.Abstract.Shape;

public class Triangle extends Shape {
        private double a, b, c;

        public Triangle(String colorShape, double a, double b, double c){
            super(colorShape);
            this.a = a;
            this.b = b;
            this.c = c;
        }

    @Override
    public double calcArea() {
        double halfPerimeter = (a + b + c) / 2.0;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public String toString() {
        return super.toString() + "; a= "+ a + "; b=" + b + "; c= " + c;
    }


}
