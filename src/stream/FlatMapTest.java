package stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        Person[] person = {new Person("A", "清华大学", 22, new BigDecimal("111")),
                new Person("B", "清华大学", 23, new BigDecimal("222")),
                new Person("A", "清华大学", 21, new BigDecimal("333")),
                new Person("D", "复旦", 24, new BigDecimal("444")),
                new Person("D", "复旦", 22, new BigDecimal("555")),
        };

        Person[] person2 = {new Person("A", "清华大学", 22, new BigDecimal("666")),
                new Person("B", "清华大学", 23, new BigDecimal("777")),
                new Person("A", "清华大学", 21, new BigDecimal("888")),
                new Person("D", "复旦", 24, new BigDecimal("999")),
                new Person("D", "复旦", 22, new BigDecimal("001")),
        };

        List<List<Person>> list = Arrays.asList(Arrays.asList(person), Arrays.asList(person2));
        List<BigDecimal> collect = list.stream().flatMap(Collection::stream).map(Person::getMoney).collect(Collectors.toList());
//        List<BigDecimal> collect = list.stream().flatMap(e -> e.stream()).map(a -> a.getMoney()).collect(Collectors.toList());
        System.out.println(collect.toString());

    }

}

