import config.HibernateUtil;
import entity.Category;
import entity.Manufacturer;
import entity.Products;
import org.hibernate.Session;


import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
//            session.getTransaction().begin();

            Category category = session.get(Category.class, 2);
            category.getProducts().forEach(products -> System.out.println(products.getName()));

//            Manufacturer m1 = session.get(Manufacturer.class, 1);
//            Manufacturer m2 = session.get(Manufacturer.class, 2);
//
//            Products products = new Products();
//            products.setName("phone");
//            products.setPrice(10);
//            products.setDescription("123");
//            products.setCategory(category);
//
//            Set<Manufacturer> m = new HashSet<>();
//            m.add(m1);
//            m.add(m2);
//            products.setManufacturers(m);
//
//            session.save(products);
//            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
