package Luong;

public class RunnableSimple implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        RunnableSimple runnable = new RunnableSimple();
        Thread t1 = new Thread(runnable);
        t1.start();
    }
}
