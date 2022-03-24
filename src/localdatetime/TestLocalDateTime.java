package localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().plusDays(-31);
        System.out.println(now.isEqual(LocalDateTime.now()));

        // string 和 LocalDateTime 相互转换
        DateTimeFormatter partten = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now1 = LocalDateTime.parse("2021-12-31 ",partten);
        System.out.println(now1);

        // 获取当前年份的所有天数,
        int year = LocalDate.now().lengthOfYear();
        System.out.println(year);
        int yearDays = LocalDate.of(2022, 1, 1).lengthOfYear();
        System.out.println(yearDays);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-1]+nums[i]);
        }
        return dp[length-1];
    }
}
