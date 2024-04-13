package DesignPatten.Singleton;

public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            BillPughSingleton.getInstance();
        });

        Thread thread2 = new Thread(() -> {
            BillPughSingleton.getInstance();
        });

        thread1.start();
        thread2.start();

    }
}
