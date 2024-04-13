package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox;

public class MacCheckbox implements Checkbox {

    @Override
    public void createCheckbox() {
        System.out.println("Tạo ra Mac checkbox");
    }
}
