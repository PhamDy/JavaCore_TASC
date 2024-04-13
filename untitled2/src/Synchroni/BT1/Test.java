package Synchroni.BT1;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.upCounter();
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.upCounter();
            }
        });
        thread1.start();
        thread2.start();
    }
}
