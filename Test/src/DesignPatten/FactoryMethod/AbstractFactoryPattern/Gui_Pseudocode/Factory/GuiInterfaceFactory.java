package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button.Button;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox.Checkbox;

public interface GuiInterfaceFactory {
        Button createButton();
        Checkbox createCheckBox();
}
