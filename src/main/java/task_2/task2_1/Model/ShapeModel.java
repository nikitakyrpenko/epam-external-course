package task_2.task2_1.Model;

import task_2.task2_1.Model.Entities.Abstract.Shape;

import java.util.Arrays;

public class ShapeModel {

    private Shape[] shapes;

    public ShapeModel(Shape[] shapes){
         this.shapes = shapes;
    }

    public String getShapesRepresentation(){
        String result = "";
        for (Shape shape: shapes)
            result = result + shape.draw() + '\n';
        return result;
    }

    public String getTotalShapesArea(){
        double result = 0;
        for (Shape shape: shapes)
            result = result + shape.calcArea();
        return Double.toString(result);
    }

    public String getTotalShapesAreaOfClass(Class shapeClass){
        double result = 0;
        for (Shape shape: shapes)
            if (shape.getClass() == shapeClass)
                result = result + shape.calcArea();
        return Double.toString(result);
    }

    public String sortByShapeColor(){
        String result = "";
        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, Shape.getShapeColorComparator());
        for (Shape shape: shapesCopy)
            result = result + shape.draw() + '\n';

        return result;
    }

    public String sortByShapeArea(){
        String result = "";
        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, Shape.getShapeAreaComparator());
        for (Shape shape: shapesCopy)
            result = result + shape.draw() + '\n';

        return result;
    }
}
