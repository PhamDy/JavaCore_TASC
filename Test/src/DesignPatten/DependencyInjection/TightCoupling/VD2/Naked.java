package DesignPatten.DependencyInjection.TightCoupling.VD2;

public class Naked implements Outfit{

    @Override
    public void wear() {
        System.out.println("Không mặc gì");
    }
}
