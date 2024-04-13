package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.Chair;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.PlasticChair;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table.PlasticTable;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table.Table;

public class FlasticFactory extends FurnitureAbstractFactory {

    @Override
    public Chair createChair() {
        return new PlasticChair();
    }

    @Override
    public Table createTable() {
        return new PlasticTable();
    }
}
