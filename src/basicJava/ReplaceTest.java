package basicJava;

import java.time.LocalDateTime;

public class ReplaceTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        System.out.println(now.plusMonths(-12));
    }
}
