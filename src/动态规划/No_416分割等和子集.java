package 动态规划;

public class No_416分割等和子集 {
    // 优化，状态压缩
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总和为奇数，不可能能划分成两个子集
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        // 所有只考虑从前i个数中选，是否有一个选法使总和等于j的集合。
        boolean[] dp = new boolean[sum + 1];

        //base case
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[sum];
    }

    // 优化空间前
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总和为奇数，不可能能划分成两个子集
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        // 所有只考虑从前i个数中选，是否有一个选法使总和等于j的集合。
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case
        // j = 0，一个都不选
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i])
                    dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i]];
            }
        }
        return dp[n - 1][sum];
    }
}



