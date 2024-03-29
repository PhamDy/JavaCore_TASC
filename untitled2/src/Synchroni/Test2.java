package Synchroni;

public class Test2 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        ThreadRadom threadRadom = new ThreadRadom(shareData);

        ThreadSquare threadSquare = new ThreadSquare(shareData);

        threadRadom.start();
        threadSquare.start();


    }
}
