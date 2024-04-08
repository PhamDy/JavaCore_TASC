package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table;

public class PlasticTable implements Table{

    @Override
    public void createTable() {
        System.out.println("Sản xuất bàn nhựa");
    }
}
