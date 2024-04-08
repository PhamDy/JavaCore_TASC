package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Products.Table;

public class WoodTable implements Table{

    @Override
    public void createTable() {
        System.out.println("Sản xuất bàn gỗ");
    }
}
