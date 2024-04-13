package DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class.Rectangle;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class.Shape;

public class Client {
    public static void main(String[] args) {
        var rectangle = (Rectangle) ShapeFactory.getShape(ShapeType.Rectangle);
        System.out.println(rectangle.getName());
        System.out.println(rectangle.acreage(3, 1));


    }
}
