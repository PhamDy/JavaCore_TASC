package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Factory;

import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button.Button;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Button.WinButton;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox.Checkbox;
import DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Product.Checkbox.WinCheckbox;

public class WinFactory implements GuiInterfaceFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new WinCheckbox();
    }
}
