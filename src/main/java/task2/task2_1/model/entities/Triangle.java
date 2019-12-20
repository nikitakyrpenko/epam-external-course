package task2.task2_1.model.entities;

import task2.task2_1.model.entities.abstracts.Shape;

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


    public static Triangle parseString(String data){
        String[] tokens = data.split("[:,]");
        double a =  Double.parseDouble(tokens[2]);
        double b = Double.parseDouble(tokens[3]);
        double c = Double.parseDouble(tokens[4]);
        if (isValid(a,b,c))
            return new Triangle(tokens[1], a,b,c);
        else
            throw new IllegalArgumentException("Wrong triangle parameters");
    }

    private static boolean isValid(double a, double b, double c){
        return !(a + b <= c) && !(a + c <= b) && !(b + c <= a);
    }
}
