import config.HibernateUtil;
import entity.Category;
import entity.Manufacturer;
import entity.Products;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
//            session.getTransaction().begin();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Products> query = builder.createQuery(Products.class);
            Root root = query.from(Products.class);

            query = query.select(root);

            Predicate p1 = builder.like(root.get("name").as(String.class), "%p");
            Predicate p2 = builder.like(root.get("name").as(String.class), "%d");
            query = query.where(builder.or(p1, p2));

            var products = session.createQuery(query).getResultList();
            products.forEach(p -> System.out.println(p));



//            Category category = session.get(Category.class, 12);
//            session.remove(category);
//            int id = 2;
//            var list = session.createQuery("SELECT p from Products p WHERE p.id = :id", Products.class)
//                    .setParameter("id", id)
//                    .getResultList();
//            list.forEach(i -> {
//                System.out.println(i);
//            });



            // Merge
//            Category category = session.get(Category.class, 11);
//            category.setName("abc123");
//            var list = category.getProducts();
//            list.forEach(i -> {
//                i.setName("Merge");
//            });
//            session.merge(category);

//            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
