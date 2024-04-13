package DesignPatten.Singleton;

import java.util.Random;
import java.util.UUID;

public class OngdevSingleton {

    //    private static final Object lock = new Object();
    private static OngdevSingleton uniqueInstance = new OngdevSingleton();

    private OngdevSingleton() {
//        System.out.println(UUID.randomUUID().toString());
    }

    public static OngdevSingleton getInstance() {
//        if (uniqueInstance==null){
//            synchronized (lock) {
//                if (uniqueInstance==null){
//                    uniqueInstance = new OngdevSingleton(UUID.randomUUID().toString());
//                }
//            }
//        }
        return uniqueInstance;
    }

    public void SayHi() {
        System.out.println("Hello world! I am " + UUID.randomUUID().toString());
    }

}
