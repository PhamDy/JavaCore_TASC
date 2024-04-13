package DesignPatten.DependencyInjection.TightCoupling.VD1;

public class VeryComplex {

    private SortAlgorithm sortAlgorithm;

    public VeryComplex(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public SortAlgorithm getSortAlgorithm() {
        return sortAlgorithm;
    }

    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness() {
        sortAlgorithm.sort();
    }

}
