package 动态规划;

import java.util.*;

/**
 * LeetCode 322
 * 闫氏DP分析法
 */
public class No_322零钱兑换 {
    // 优化前
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0)
            return amount == 0 ? 1 : -1;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= amount; j++)
                dp[i][j] = amount + 1;
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        int temp = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = temp;
            temp++;
        }

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i])
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
            }
        return dp[n - 1][amount] > amount ? -1 : dp[n - 1][amount];
    }

    // 优化后：
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        if (coins.length == 0) {
            return amount == 0 ? 1 : -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
