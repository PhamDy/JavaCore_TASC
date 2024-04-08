package DesignPatten.Singleton;

import java.util.ArrayList;
import java.util.List;

public class DataMgr {

    private List<Category> categories;

    private List<Product> products;

    private static DataMgr instance = null;

    private DataMgr() {
        this.categories = new ArrayList<>();
        this.products = new ArrayList<>();
        System.out.println("Asd");
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static void setInstance(DataMgr instance) {
        DataMgr.instance = instance;
    }

    public static DataMgr getInstance(){
        if (instance==null){
            instance = new DataMgr();
        }
        return instance;
    }

}
