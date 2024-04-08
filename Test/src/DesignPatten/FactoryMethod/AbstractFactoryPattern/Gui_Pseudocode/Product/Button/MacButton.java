package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button;

public class MacButton implements Button{

    @Override
    public void createButton() {
        System.out.println("Tạo ra Mac Button");
    }
}
