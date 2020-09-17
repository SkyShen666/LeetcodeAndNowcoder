package 动态规划;

public class No494_目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        if (n == 0) {
            return S == 0 ? 1 : 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((S + sum) % 2 == 1) {
            return 0;
        }

        if (sum < S)
            return 0;
        int target = (S + sum) / 2;

        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
