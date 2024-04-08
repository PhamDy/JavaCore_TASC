package DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class.Circle;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class.Rectangle;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class.Shape;

public class ShapeFactory {
    private ShapeFactory(){

    }

    public static final Shape getShape(ShapeType shapeType){
        switch (shapeType){
            case Rectangle:
                return new Rectangle();
            case Circle:
                return new Circle();
            default:
                throw new IllegalArgumentException("Error");
        }
    }

}
