package stream;

public class Student {
    private String key;
    private String value;
    private Integer age;
    public Student() {
    }

    public Student(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Student(String key, Integer age) {
        this.key = key;
        this.age = age;
    }

    public Student(String key, String value, Integer age) {
        this.key = key;
        this.value = value;
        this.age = age;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", age=" + age +
                '}';
    }
}
