package DesignPatten.FactoryMethod.AbstractFactoryPattern.Shape.Class;

public class Rectangle implements Shape {

    @Override
    public String getName() {
        return "I am Rectangle";
    }

    public double acreage(double a, double b){
        return a*b;
    }

}
