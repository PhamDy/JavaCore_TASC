package com.example.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
//
//        Girl girl1 = context.getBean(Girl.class);
//        Girl girl2 = context.getBean(Girl.class);
//        System.out.println(girl1.hashCode());
//        girl2.test();
//        System.out.println("------------");
//        System.out.println(girl2.hashCode());
//        girl2.test();

//        System.out.println("Trước khi IOC container destroy girl");
//        ((ConfigurableApplicationContext)context).getBeanFactory().destroyBean(girl);
//        System.out.println("Sau khi IOC container destroy girl");


        BeanFactory factory = new ClassPathXmlApplicationContext("Bean-factory-demo.xml");
        Student student = (Student) factory.getBean("student");
        System.out.println(student);

    }
}
