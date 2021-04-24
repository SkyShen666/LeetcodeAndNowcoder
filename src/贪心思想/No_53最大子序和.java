package 贪心思想;

public class No_53最大子序和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int tmpMax = nums[0];
        int maxSum = tmpMax;

        for (int i = 1; i < n; i++) {
            tmpMax = tmpMax > 0 ? tmpMax + nums[i] : nums[i];
            maxSum = Math.max(maxSum, tmpMax);
        }

        return maxSum;
    }
}
