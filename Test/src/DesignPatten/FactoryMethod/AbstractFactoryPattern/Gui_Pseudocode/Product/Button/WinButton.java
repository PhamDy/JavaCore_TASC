package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button;

public class WinButton implements Button {

    @Override
    public void createButton() {
        System.out.println("Tạo ra Win Button");
    }
}
