package Luong;

public class UsingJoinMethod extends Thread {
    public UsingJoinMethod(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName());
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(i + " ");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        UsingJoinMethod t1 = new UsingJoinMethod("Thread 1");
        UsingJoinMethod t2 = new UsingJoinMethod("Thread 2");
        t1.start();
        t1.join();
        t2.start();
        System.out.println("Main Thread Finished");
    }
}
