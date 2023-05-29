package stream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/4/25 21:42
 */

public class StreamTest {

    public static void main(String[] args) {
//        long start = System.nanoTime();
//        List<Student> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            Student student = new Student("学生->" + i, "名称->" + i, i);
//            list.add(student);
//        }
//        Map<String, Student> collect = list.stream().collect(Collectors.toMap(Student::getKey, e -> e, (a, b) -> b));
////        Map<String, Student> collect = list.parallelStream().collect(Collectors.toMap(Student::getKey, e -> e, (a, b) -> b));
//        long end = System.nanoTime();
//        System.out.println("stream花费时间：" + (end - start)+ "纳秒");
//        System.out.println("parallelStream花费时间：" + (end - start)+ "纳秒");
        Instant instant = Instant.ofEpochSecond(1682587381);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);
    }
}
