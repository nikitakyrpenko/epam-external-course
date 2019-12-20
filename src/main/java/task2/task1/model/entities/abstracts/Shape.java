package task2.task1.model.entities.abstracts;

public abstract class Shape implements Drawable{

    private String shapeColor;

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() { return shapeColor; }

    public void setShapeColor(String shapeColor) { this.shapeColor = shapeColor; }

    public abstract double calcArea();




    @Override
    public String toString(){ return getClass().getSimpleName() + "; shapeColor= "+shapeColor; }

    public String draw() { return this.toString() + "; area= " + calcArea(); }





}
