package DesignPatten.DependencyInjection.TightCoupling.VD1;

import DesignPatten.DependencyInjection.TightCoupling.VD1.BubbleSort;
import DesignPatten.DependencyInjection.TightCoupling.VD1.QuickSort;
import DesignPatten.DependencyInjection.TightCoupling.VD1.SortAlgorithm;
import DesignPatten.DependencyInjection.TightCoupling.VD1.VeryComplex;

public class Main {
    public static void main(String[] args) {
        SortAlgorithm bubbleSort = new BubbleSort();
        SortAlgorithm quickSort = new QuickSort();

        VeryComplex bussiness1 = new VeryComplex(bubbleSort);
        VeryComplex bussiness2 = new VeryComplex(quickSort);

        bussiness1.complexBusiness();
        bussiness2.complexBusiness();
        bussiness2.setSortAlgorithm(bubbleSort);
        bussiness2.complexBusiness();

    }
}
