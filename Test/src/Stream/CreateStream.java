package Stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "a");
        Employee e2 = new Employee("2", "b");
        Employee e3 = new Employee("3", "c");
        Employee e4 = new Employee("4", "d");

        Stream<Employee> stream = Stream.of(e1,e2,e3,e4);

        stream.forEach(item -> {
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("----------");
        });

    }
}
