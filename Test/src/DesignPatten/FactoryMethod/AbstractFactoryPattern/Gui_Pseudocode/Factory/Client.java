package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button.Button;

public class Client {
    public static void main(String[] args) {
        GuiInterfaceFactory factory = GuiFactory.getFactory(GuiType.Mac); // Chọn ra nhà máy sản xuất chất liệu Mac
        Button button = factory.createButton(); // Sản xuất ra Button với chất liệu Mac
        button.createButton(); //
    }
}
