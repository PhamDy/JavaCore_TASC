package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button.Button;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button.MacButton;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox.Checkbox;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox.MacCheckbox;

public class MacFactory implements GuiInterfaceFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new MacCheckbox();
    }
}
