package DesignPatten.DependencyInjection.TightCoupling.VD2;

public class Girl {
    private Outfit outfit;

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

    public void showOutfit() {
        outfit.wear();
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
