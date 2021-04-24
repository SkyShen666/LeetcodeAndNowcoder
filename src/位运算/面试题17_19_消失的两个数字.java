package 位运算;

public class 面试题17_19_消失的两个数字 {
    public int[] missingTwo(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length + 2;
        int sumOfTwo = (n * (n + 1) / 2) - sum;
        int threshold = sumOfTwo / 2; // 一个小于等于threshold，一个大于threshold

        sum = 0;
        for (int num : nums) {
            if (num <= threshold) {
                sum += num;
            }
        }
        int[] ret = new int[2];
        ret[0] = (threshold) * (threshold + 1) / 2 - sum;
        ret[1] = sumOfTwo - ret[0];

        return ret;
    }
}
