package stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FlatMapTest1 {
    public static void main(String[] args) {
        Person[] person = {new Person("A", "清华大学", 22, new BigDecimal("111")),
                new Person("B", "清华大学", 23, new BigDecimal("222")),
                new Person("A", "清华大学", 21, new BigDecimal("333")),
                new Person("D", "复旦", 24, new BigDecimal("444")),
                new Person("D", "复旦", 22, new BigDecimal("555")),
        };


        List<Person> people = Arrays.asList(person);
        long a = System.currentTimeMillis();
        System.out.println(flatMap1(people));
        long b = System.currentTimeMillis();
        System.out.println(b-a);

        long c = System.currentTimeMillis();
        System.out.println(flatMap2(people));
        long d = System.currentTimeMillis();
        System.out.println(d-c);

        long c1 = System.currentTimeMillis();
        System.out.println(flatMap3(people));
        long d1 = System.currentTimeMillis();
        System.out.println(d1-c1);

        long a1 = System.currentTimeMillis();
        System.out.println(map1(people));
        long a2 = System.currentTimeMillis();
        System.out.println(a2-a1);
    }
    public static BigDecimal flatMap2(List<Person> people){
        Map<String, List<Person>> collect = people.stream().collect(Collectors.groupingBy(Person::getName));
        // 分组后转list
        return collect.entrySet().stream().flatMap(e -> e.getValue().stream()).map(a -> a.getMoney()).reduce(BigDecimal::add).get();
    }

    public static BigDecimal flatMap1(List<Person> people){
        Map<String, Map<String, List<Person>>> peopleMap = people.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getSchool)));
        Set<Map.Entry<String, Map<String, List<Person>>>> entries = peopleMap.entrySet();
        return peopleMap.entrySet().stream().flatMap(entry -> {
            Map<String, List<Person>> value = entry.getValue();
            List<Person> collect = value.entrySet().stream().flatMap(e -> e.getValue().stream()).collect(Collectors.toList());
            return collect.stream();
        }).map(Person::getMoney).reduce(BigDecimal::add).get();
    }

    public static BigDecimal flatMap3(List<Person> people){
        Map<String, Map<String, List<Person>>> peopleMap = people.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getSchool)));
        return peopleMap.entrySet().stream()
                // 第一层扁平化
                .flatMap(entry -> entry.getValue()
                        .entrySet()
                        .stream()
                        // 第二层转为扁平化
                        .flatMap(e -> e.getValue()
                                .stream())
                        // 映射一波
                        .map(a -> a.getMoney()))
                .reduce(BigDecimal::add)
                .get();
    }

    public static BigDecimal map1(List<Person> people){
        Map<String, Map<String, List<Person>>> peopleMap = people.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getSchool)));
        BigDecimal result = BigDecimal.ZERO;
        for (Map.Entry<String, Map<String, List<Person>>> entry : peopleMap.entrySet()) {
            for (Map.Entry<String, List<Person>> e : entry.getValue().entrySet()) {
                for (Person person : e.getValue()) {
                    result  = result.add(person.getMoney());

                }
            }
        }
        return result;
    }



}
