package DesignPatten.DependencyInjection.TightCoupling.VD2;

public class Main {
    public static void main(String[] args) {
        Outfit bikini = new Bikini();
        Outfit skirt = new Skirt();
        Outfit naked = new Naked();

        Girl gg = new Girl(bikini);
        gg.showOutfit();

    }
}
