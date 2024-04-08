package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.Chair;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.WoodChair;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table.Table;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table.WoodTable;

public class WoodFactory extends FurnitureAbstractFactory{

    @Override
    public Chair createChair() {
        return new WoodChair();
    }

    @Override
    public Table createTable() {
        return new WoodTable();
    }
}
