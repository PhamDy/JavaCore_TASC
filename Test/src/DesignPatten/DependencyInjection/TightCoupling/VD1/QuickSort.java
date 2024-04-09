package DesignPatten.DependencyInjection.TightCoupling.VD1;

public class QuickSort implements SortAlgorithm {
    @Override
    public void sort() {
        System.out.println("Sắp xếp theo Quick sort");
    }
}
