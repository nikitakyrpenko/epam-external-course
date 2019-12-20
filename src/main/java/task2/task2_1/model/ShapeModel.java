package task2.task2_1.model;

import task2.task2_1.model.entities.abstracts.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeModel<T extends Shape> {

    
    private T[] shapes;

    public ShapeModel(T[] shapes){
         this.shapes = shapes;
    }

    public String getShapesRepresentation(){
        String result = "";
        for (Shape shape: shapes)
            result = result + shape.draw() + '\n';
        return result;
    }

    public String getTotalShapesArea(){
        double result = 0.0;
        for (Shape shape: shapes)
            result = result + shape.calcArea();
        return Double.toString(result);
    }

    public String getTotalShapesAreaOfClass(Class shapeClass){
        double result = 0.0;
        for (Shape shape: shapes)
            if (shape.getClass() == shapeClass)
                result = result + shape.calcArea();
        return Double.toString(result);
    }

    public Shape[] sortByShapeColor(){
        String result = "";
        T[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getShapeColor().compareTo(o2.getShapeColor());
            }
        });
        return shapesCopy;
    }

    public Shape[] sortByShapeArea(){
        T[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.calcArea() - o2.calcArea());
            }
        });
        return shapesCopy;
    }
}
