package Collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedColl {
    public static final int NUM_OF_ELEMENT = 5;

    public static void main(String[] args) {
        List<Student> list = new LinkedList<>();
        for (int i = 0; i < NUM_OF_ELEMENT; i++) {
            Student student = new Student(i,"Huy" + i);
            list.add(student);
        }

        list.add(2, new Student(213, "ÁD"));

        list.forEach(System.out::println);





    }
}
