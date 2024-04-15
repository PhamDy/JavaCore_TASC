package config;

import entity.Category;
import entity.Manufacturer;
import entity.Products;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {
    public static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "");
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Products.class);
        configuration.addAnnotatedClass(Manufacturer.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                                    .applySettings(configuration.getProperties()).build();

        FACTORY = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return FACTORY;
    }

}
