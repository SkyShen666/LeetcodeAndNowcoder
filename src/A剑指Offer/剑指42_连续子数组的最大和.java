package A剑指Offer;

/**
 * 同 leetcode53题：连续子序和
 * 贪心思想
 */
public class 剑指42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int tmpMax = nums[0];
        int max = tmpMax;

        for (int i = 1; i < nums.length; i++) {
            tmpMax = tmpMax > 0 ? tmpMax + nums[i] : nums[i];
            max = Math.max(max, tmpMax);
        }

        return max;
    }
}
