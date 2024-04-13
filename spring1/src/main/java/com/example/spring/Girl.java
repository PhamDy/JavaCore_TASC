package com.example.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



//@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Girl {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void test(){
        System.out.println("ok1");
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //    @PostConstruct
//    public void postConstructor(){
//        System.out.println("Ham nay duoc goi sau khi bean Girl duoc tao");
//    }
//
//    @PreDestroy
//    public void preDestroy(){
//        System.out.println("Ham nay duoc goi sau khi bean Girl destroy");
//    }

}
