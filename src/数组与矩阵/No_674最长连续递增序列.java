package 数组与矩阵;

public class No_674最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int n = nums.length;
        int begin = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                max = Math.max(max, i - begin);
                begin = i;
            }
        }
        // 若整个数组都是递增的
        max = Math.max(max, n - begin);

        return max;
    }
}
