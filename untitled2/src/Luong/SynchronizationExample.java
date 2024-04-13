package Luong;

public class SynchronizationExample {
    private static SynchronizationExample instance;

    public synchronized void lockedByThis() {
        System.out.println(" This synchronized method is locked by current, instance of object, i.e. this");
    }

    private static synchronized SynchronizationExample lockedByClassLock() {
        System.out.println("This static synchronized method is locked by class level lock of this class,  "
                + "i.e. SychronizationExample.class");
        if (instance == null) {
            instance = new SynchronizationExample();
        }
        return instance;
    }

    public static synchronized SynchronizationExample lockedBySynchronizedBlock() {
        System.out.println("This line is executed without locking");
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new SynchronizationExample();
                }
            }
        }
        return instance;
    }
}
