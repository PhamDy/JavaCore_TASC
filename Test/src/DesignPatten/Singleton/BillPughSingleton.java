package DesignPatten.Singleton;

import java.util.UUID;

public class BillPughSingleton {

    private BillPughSingleton() {
        System.out.println(UUID.randomUUID().toString());
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

}
