package Luong;

public class ThreadSimple extends Thread {

    public void run() {
        System.out.println("thread is running ...");
    }

    public void test() {
        System.out.println("Test");
    }

    public static void main(String[] args) {
        ThreadSimple t1 = new ThreadSimple();
        t1.start();

    }
}
