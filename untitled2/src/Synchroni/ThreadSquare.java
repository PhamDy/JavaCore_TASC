package Synchroni;

public class ThreadSquare extends Thread{
    ShareData shareData;

    public ThreadSquare(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (shareData){
                try {
                    shareData.notifyAll();
                    shareData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int rad = shareData.getRad();
                rad *= rad;
                System.out.println("PT: " + rad);
            }
        }
    }
}
