package DesignPatten.ReflectionInJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            String tenClass = "DesignPatten.ReflectionInJava.SinhVien";

            Class<?> clsSinhVien = Class.forName(tenClass);
            Constructor<?> constructor = clsSinhVien.getDeclaredConstructor();
            SinhVien sv = (SinhVien) constructor.newInstance();
//            SinhVien sv = (SinhVien) clsSinhVien.newInstance();

            Method[] methods = clsSinhVien.getMethods();

            for (Method method : methods
            ) {
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            System.out.println(ex);
        }

    }
}
