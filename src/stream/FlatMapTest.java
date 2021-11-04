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

//        List<Person> list = Arrays.asList(person);
//        List<Person> list = Arrays.asList(person);
        List<List<Person>> list = Arrays.asList(Arrays.asList(person), Arrays.asList(person2));
        List<BigDecimal> collect = list.stream().flatMap(Collection::stream).map(Person::getMoney).collect(Collectors.toList());
        System.out.println(collect.toString());


//        Map<String, Map<String, List<Person>>> personMap = list.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getSchool)));
//        // 将所有分组的钱加起来
////        List<Map.Entry<String, List<Person>>> collect = personMap.entrySet().stream().flatMap(entry -> entry.getValue().entrySet().stream()).collect(Collectors.toList());
//        Stream<Stream<Stream<BigDecimal>>> streamStream = personMap.entrySet().stream().flatMap(entry -> entry.getValue().entrySet().stream())
//                .map(e -> e.getValue().stream().map(a -> e.getValue().stream().map(Person::getMoney)));


//        System.out.println(personMap.toString());

    }

}

class Person {
    private String name;
    private String school;
    private int age;
    private BigDecimal money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Person(String name, String school, int age, BigDecimal money) {
        this.name = name;
        this.school = school;
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
