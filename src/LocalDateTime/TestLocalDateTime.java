package LocalDateTime;

import java.time.LocalDateTime;

public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().plusDays(-31);
        System.out.println(now);
    }
}
