package DesignPatten.FactoryMethod.AbstractFactoryPattern.SxBanGhe.Factory;

public class FurnitureFactory {

    public static final FurnitureAbstractFactory getFactory(MaterialType type){
        switch (type){
            case FLASTIC:
                return new FlasticFactory();
            case WOOD:
                return new WoodFactory();
            default:
                throw new IllegalArgumentException("Error");
        }
    }

}
