package DesignPatten.Singleton;

import java.util.List;

public class Product {
    int id, idCat;
    String title;
    float price;

    public Product() {
    }

    public Product(int id, int idCat, String title, float price) {
        this.id = id;
        this.idCat = idCat;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getIdCat() {
        return idCat;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void getList() {
        List<Product> products = DataMgr.getInstance().getProducts();
        System.out.println(products);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", idCat=" + idCat +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
