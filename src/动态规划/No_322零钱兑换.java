package 动态规划;

import java.util.*;

/**
 * LeetCode 322
 * 动态规划，自底向上
 * f(i) = Min(f(i - coins[j]) + 1)
 */
public class No_322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        // 初始化
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] < max ? dp[amount] : -1;
    }
}
