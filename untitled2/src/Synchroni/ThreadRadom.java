package Synchroni;

import java.util.Random;

public class ThreadRadom extends Thread{
    ShareData shareData;

    public ThreadRadom(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            synchronized (shareData){
                int rad = random.nextInt(100) + 1;
                shareData.setRad(rad);
                System.out.println("Rad: " + rad);
                shareData.notifyAll();
                try {
                    shareData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
