package DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class;

public class Circle implements Shape {

    @Override
    public String getName() {
        return "I am Circle";
    }

    public double acreage(double r) {
        return 2 * Math.PI * r;
    }

}
