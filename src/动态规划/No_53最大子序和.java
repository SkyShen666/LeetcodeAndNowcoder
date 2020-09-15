package 动态规划;

public class No_53最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int n = nums.length;
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(dp_0 + nums[i], nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }
        return res;
    }
}
/**
 public int maxSubArray(int[] nums) {
    if (nums.length == 0 || nums == null)
        return 0;
    int n = nums.length;
    int[] dp = new int[n];
    // base case
    dp[0] = nums[0];
    // 状态转移方程
    for (int i = 1; i < n; i++) {
        dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    }
    // 得到nums的最大子数组
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
 }
 */