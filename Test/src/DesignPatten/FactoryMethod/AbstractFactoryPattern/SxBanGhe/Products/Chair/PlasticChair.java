package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair.Chair;

public class PlasticChair implements Chair {

    @Override
    public void createChair() {
        System.out.println("Sản xuất ghế nhựa");
    }
}
