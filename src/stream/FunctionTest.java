package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
//        list.add(new Student("1", "a"));
//        list.add(new Student("2", "b"));
        list.add(new Student("3", 3));
        list.add(new Student("4", 5));
        Map<String, Integer> stringStringMap = toMap(list, Student::getKey, Student::getAge,e->e.getAge() !=null);
        System.out.println(stringStringMap.toString());
    }


    public static <T,K,V> Map<K,V> toMap(List<T> list, Function<T, K> key, Function<T, V> value, Predicate<T> predicate){
        return list.stream().filter(predicate).collect(Collectors.toMap(key,value,(a, b)->a));
    }

//    public static <T,K,V> Map<String, Integer> toMap(List<T> list, Function<T, K> key, Function<T, V> value, Predicate<T> predicate){
//        return list.stream().filter(predicate).collect(Collectors.toMap(key,value,(a, b)->a));
//    }
}
