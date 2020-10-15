package 滑动窗口;

public class No_最长连续递增子序列 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int p = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                max = Math.max(max, i - p);
                p = i;
            }
        }
        // 整个序列都是递增的
        max = Math.max(max, n - p);
        return max;
    }
}
