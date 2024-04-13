package BlockingQueue;

import java.util.LinkedList;

public class BlockingQueue<T> {

    public static final int compacity = 10;
    private final LinkedList<T> items = new LinkedList<>();

    public synchronized void put(T value) throws InterruptedException {
        while (items.size() == compacity) {
            System.out.println("Queue is full");
            wait();
        }
        items.addLast(value);
    }

    public synchronized T take() throws InterruptedException {
        while (items.size() == 0) {
            System.out.println("Queue is empty");
            wait();
        }
        notifyAll();
        return items.removeFirst();
    }

    public synchronized int size() {
        return items.size();
    }
}
