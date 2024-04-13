package Synchroni.Collection;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Hai");
        Student student2 = new Student(2, "Huy");
        Student student3 = new Student(3, "Đạt");
        Student student4 = new Student(4, "Duy");

        DanhSach danhSach = new DanhSach();

        Thread t1 = new Thread(() -> {
            danhSach.addStudent(student1);
            danhSach.addStudent(student2);
        });

        Thread t2 = new Thread(() -> {
            danhSach.update(new Student(2, "test"));
        });

        Thread t3 = new Thread(() -> {
            danhSach.getDs(2);
        });

        t1.start();
        t2.start();
        t3.start();


    }
}
