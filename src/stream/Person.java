package stream;

import java.math.BigDecimal;

public class Person {
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
