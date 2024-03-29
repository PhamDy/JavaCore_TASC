package Collection;

import java.util.*;

public class QUEUE {
    public static void main(String[] args) {
//        Queue<String> names = new LinkedList<>();
//        names.offer("E");
//        names.offer("A");
//        names.offer("M");
//        names.add("G");
//        names.add("B");
//        System.out.println(names.peek());
//        System.out.println(names);
//
//        Queue<String> names = new PriorityQueue<>();
//        names.offer("E");
//        names.offer("A");
//        names.offer("M");
//
//        names.add("G");
//        names.add("B");
//
//        while (!names.isEmpty()){
//            System.out.println(names.poll());
//        }

        Queue<Book> queue = new PriorityQueue<>();
        Book book1 = new Book(123, "A");
        Book book2 = new Book(321, "A");
        Book book3 = new Book(120, "A");
        Book book4 = new Book(5312, "A");

        queue.add(book1);
        queue.add(book2);
        queue.add(book3);
        queue.add(book4);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    Queue<String> strings = new LinkedList<>();
    }
}
