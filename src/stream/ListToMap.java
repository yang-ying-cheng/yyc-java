package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", "a"));
        list.add(new Student("2", "b"));
        list.add(new Student("3", "null"));
//        Map<String, String> collect = list.stream().filter(e->e.getValue() != null).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (a, b) -> b));
        Map<String, String> collect = list.stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (a, b) -> b));
        collect.forEach(System.out::printf);


    }
}

