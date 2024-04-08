package DesignPatten.FactoryMethod.AbstractFactoryPattern.Gui_Pseudocode.Factory;

public class GuiFactory {

    public static final GuiInterfaceFactory getFactory(GuiType type){
        switch (type){
            case Mac:
                return new MacFactory();
            case Win:
                return new WinFactory();
            default:
                throw new IllegalArgumentException("Error");
        }
    }
}
