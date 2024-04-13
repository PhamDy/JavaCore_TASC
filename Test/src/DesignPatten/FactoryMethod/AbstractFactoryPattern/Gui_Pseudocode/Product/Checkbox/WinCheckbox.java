package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox;

public class WinCheckbox implements Checkbox {

    @Override
    public void createCheckbox() {
        System.out.println("Tạo ra Win checkbox");
    }
}
