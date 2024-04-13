package Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapColl {
    public static void main(String[] args) {
        HashMap<Integer, Student> list = new HashMap<>();
        Student s1 = new Student(1, "Huy");
        Student s2 = new Student(2, "Duy");
        Student s3 = new Student(3, "Dat");

        list.put(s1.getId(), s1);
        list.put(s2.getId(), s2);
        list.put(s3.getId(), s3);

        for (Map.Entry<Integer, Student> map : list.entrySet()
        ) {
            if (map.getValue() == s1) {
                System.out.println(map.getKey() + " = " + map.getValue());
            }
        }


    }
}
