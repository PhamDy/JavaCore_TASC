package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SETCOLL {
    public static void main(String[] args) {
        LinkedHashSet<Student> list = new LinkedHashSet<>();
        Student s1 = new Student(123, "Hi");
        Student s2 = new Student(123, "Jack");
        Student s3 = new Student(56, "Adam");
        Student s4 = new Student(123, "Jack");
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.forEach(i -> System.out.println(i));


    }
}
