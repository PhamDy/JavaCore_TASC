package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.Chair;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table.Table;

public abstract class FurnitureAbstractFactory {

    public abstract Chair createChair();

    public abstract Table createTable();

}
