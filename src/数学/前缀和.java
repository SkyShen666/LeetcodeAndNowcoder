package 数学;

import java.util.*;
import java.util.Random;

// 编写一个方法,随机返回每个数的概率为nums[i] / sum
// 如[2,4,7,1]   sum = 14
// 返回2的概率为: 2 / 14
// 返回4的概率为: 4 / 14
//   .....
// 返回1的概率为: 1 / 14
public class 前缀和 {
    public static int rand(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        Random r = new Random();
        int num = r.nextInt(sum);
        for (int i = 0; i < n; i++) {
            if (num < sums[i]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,8};
        System.out.println(rand(nums));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++)
            list.add(rand(nums));
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            double count = 0;
            for (int j = 0; j < 10000000; j++) {
                if (list.get(j) == nums[i])
                    count++;
            }
            res.add(count / 10000000);
        }
        System.out.println(res);
    }
}
