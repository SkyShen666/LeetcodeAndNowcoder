package 动态规划;

/**
 * 经典背包问题：参考的官方题解
 */
public class No_518零钱兑换2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 这步很关键，凑零元，一个硬币都不需要，此方案唯一，方案数量为1
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
