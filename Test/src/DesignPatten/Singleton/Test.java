package DesignPatten.Singleton;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        DataMgr dataMgr = DataMgr.getInstance();

        List<Product> list = new ArrayList<>();
//        list.add(new Product(1,2,"ASD", 2.2f));
        dataMgr.setProducts(list);
        Product product = new Product();
        product.getList();

    }
}
