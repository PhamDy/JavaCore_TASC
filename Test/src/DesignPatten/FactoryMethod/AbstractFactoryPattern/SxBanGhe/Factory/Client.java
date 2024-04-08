package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.Chair;

public class Client {
    public static void main(String[] args) {
        FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.FLASTIC);

        Chair chairPlastic = factory.createChair();
        chairPlastic.createChair();

    }
}
