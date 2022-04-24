package basicJava;

import java.util.Scanner;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/4/1 10:22
 */

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 小写字母个数
        int k = scanner.nextInt();
        // 员工个数
        long n = scanner.nextLong();
        int res = -1;
        long p = (long)(n / Math.pow(26,k));
        if(p ==0){
            System.out.println(1);
            return;
        }
        while (p > 0) {
            p = p / 10;
            res++;
        }
        if (n % 26 == 0) {
           res =  res == 0 ? 1:res;
        } else {
            res +=1;
        }
        System.out.println(res);
    }
}
