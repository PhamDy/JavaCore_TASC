package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Chair;

public class WoodChair implements Chair {

    @Override
    public void createChair() {
        System.out.println("Sản xuất ghế gỗ");
    }
}
