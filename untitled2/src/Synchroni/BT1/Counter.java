package Synchroni.BT1;

public class Counter {

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public synchronized void upCounter() {
        this.counter++;
        System.out.println(counter);
    }

}
