package basicJava;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/27 11:04
 */

public class LeetCode {
    //public int[] twoSum(int[] nums, int target) {
    //
    //    HashMap<Integer, Integer> map = new HashMap<>();
    //    for (int i = 0; i < nums.length; i++) {
    //        if(map.containsKey(target - nums[i])){
    //            return new int[]{map.get(target-nums[i]),i};
    //        }
    //        map.put(nums[i],i);
    //    }
    //    return new int[0];
    //}

    //    public static void main(String[] args) {
//        String ip = "12.255.255.255";
//
//        String[] split = ip.replaceAll("\\.",",").split(",");
//        for (String s1 : split) {
//            System.out.println(s1);
//        }
//        //System.out.println();
//    }
//}
    public void merge(int[] a, int m, int[] b, int n) {
        int l = 0;
        int r = 0;
        int[] temp = new int[m + n];
        int i = 0;
        while (l > m || r > n) {
            if (a[l] < b[r]) {
               temp[i++] = a[l++];
            }else{
                temp[i++] = a[r++];
            }
        }
        for(int j = 0 ; j < m+n ; j++){
            a[j] = temp[j];
        }

    }
}
