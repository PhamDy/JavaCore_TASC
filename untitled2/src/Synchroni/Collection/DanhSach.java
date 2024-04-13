package Synchroni.Collection;

import java.util.ArrayList;

public class DanhSach {

    ArrayList<Student> list = new ArrayList<>();


    public DanhSach() {
    }

    public DanhSach(ArrayList<Student> list) {
        this.list = list;
    }

    public synchronized void getDs(int id) {
        System.out.println("Student " + id);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    public synchronized void addStudent(Student student) {
        list.add(student);
        System.out.println("Đã thêm thành công");
        System.out.println(list.toString());
        System.out.println(list.size());
    }

    public synchronized void update(Student student) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == student.id) {
                list.get(i).name = student.name;
            }
        }
        System.out.println("Đã được update " + student.id);
        System.out.println(list.toString());

    }

    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
            }
        }
        System.out.println("Đã được xóa " + id);
        System.out.println(list.toString());
    }

}
