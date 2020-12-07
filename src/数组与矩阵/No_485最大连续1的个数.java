package 数组与矩阵;

public class No_485最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int cnt = 0;

        for (int num : nums) {
            if (num == 0) {
                cnt = 0;
            } else {
                cnt++;
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
