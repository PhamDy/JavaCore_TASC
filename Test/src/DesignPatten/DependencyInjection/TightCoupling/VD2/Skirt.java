package DesignPatten.DependencyInjection.TightCoupling.VD2;

public class Skirt implements Outfit{

    @Override
    public void wear() {
        System.out.println("Đã mặc Skirt");
    }
}
