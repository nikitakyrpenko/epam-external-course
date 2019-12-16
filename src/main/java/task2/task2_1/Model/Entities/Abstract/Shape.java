package task2.task2_1.Model.Entities.Abstract;

import java.util.Comparator;

public abstract class Shape implements Drawable{

    private String shapeColor;

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() { return shapeColor; }

    public void setShapeColor(String shapeColor) { this.shapeColor = shapeColor; }

    public abstract double calcArea();

    public static ShapeColorComparator getShapeColorComparator(){
        return new ShapeColorComparator();
    }

    public static ShapeAreaComparator getShapeAreaComparator(){
        return new ShapeAreaComparator();
    }


    @Override
    public String toString(){ return getClass().getSimpleName() + "; shapeColor= "+shapeColor; }

    public String draw() { return this.toString() + "; area= " + calcArea(); }


    private static class ShapeColorComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            Shape s1 = (Shape) o1;
            Shape s2 = (Shape) o2;
            long s1ColorValue = Long.parseLong(s1.shapeColor.substring(1),16);
            long s2ColorValue = Long.parseLong(s2.shapeColor.substring(1),16);
            return (int) (s1ColorValue - s2ColorValue);
        }
    }

    private static class ShapeAreaComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            Shape s1 = (Shape) o1;
            Shape s2 = (Shape) o2;
            return (int) (s1.calcArea() - s2.calcArea());
        }
    }
}
