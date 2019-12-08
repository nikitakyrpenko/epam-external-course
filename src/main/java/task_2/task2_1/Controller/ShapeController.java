package task_2.task2_1.Controller;

import task_2.task2_1.Model.Entities.Abstract.Shape;
import task_2.task2_1.Model.Entities.Circle;
import task_2.task2_1.Model.Entities.Rectangle;
import task_2.task2_1.Model.Entities.Triangle;
import task_2.task2_1.Model.ShapeModel;
import task_2.task2_1.View.ShapeView;

import java.util.Random;

public class ShapeController {

    private ShapeModel shapeModel;
    private ShapeView shapeView;


    public ShapeController(int shapesAmount, String[] colorValues, double[] dimensionValues){
        Shape[] shapes = parseData(shapesAmount, colorValues, dimensionValues);
        shapeModel = new ShapeModel(shapes);
        shapeView = new ShapeView();
    }

    public void reply(){
        shapeView.printMessage(ShapeView.SHAPES_REPRESENTATION, shapeModel.getShapesRepresentation());
        shapeView.printMessage(ShapeView.SHAPES_TOTAL_AREA, shapeModel.getTotalShapesArea());
        shapeView.printMessage(ShapeView.SHAPES_TOTAL_AREA_OF_CLASS, shapeModel.getTotalShapesAreaOfClass(Circle.class));
        shapeView.printMessage(ShapeView.SHAPES_SORTED_BY_AREA, shapeModel.sortByShapeArea());
        shapeView.printMessage(ShapeView.SHAPES_SORTED_BY_COLOR, shapeModel.sortByShapeColor());
    }

    private Shape[] parseData(int shapesAmount, String[] colorValues, double[] dimensionValues){
        Shape[] result = new Shape[shapesAmount];
        for (int i = 0; i < shapesAmount; i++) {
            switch (pickRandom(3)) {
                case 0:
                    String circleColor = colorValues[pickRandom(colorValues.length)];
                    double radius = dimensionValues[pickRandom(dimensionValues.length)];
                    Shape circle = new Circle(circleColor, radius);
                    result[i] = circle;
                    break;
                case 1:
                    String rectangleColor = colorValues[pickRandom(colorValues.length)];
                    double w = dimensionValues[pickRandom(dimensionValues.length)];
                    double h = dimensionValues[pickRandom(dimensionValues.length)];
                    Shape rectangle = new Rectangle(rectangleColor, w, h);
                    result[i] = rectangle;
                    break;
                case 2:
                    String triangleColor = colorValues[pickRandom(colorValues.length)];
                    double a = dimensionValues[pickRandom(dimensionValues.length)];
                    double b = dimensionValues[pickRandom(dimensionValues.length)];
                    double c = dimensionValues[pickRandom(dimensionValues.length)];
                    while (!isValid(a,b,c)){
                        a = dimensionValues[pickRandom(dimensionValues.length)];
                        b = dimensionValues[pickRandom(dimensionValues.length)];
                        c = dimensionValues[pickRandom(dimensionValues.length)];
                    }
                    Shape triangle = new Triangle(triangleColor, a, b, c);
                    result[i] = triangle;
            }
        }
        return result;
    }


    private int pickRandom(int bound){
        return new Random().nextInt(bound);
    }

    private boolean isValid(double a, double b, double c){
        return !(a + b <= c) && !(a + c <= b) && !(b + c <= a);
    }

}
