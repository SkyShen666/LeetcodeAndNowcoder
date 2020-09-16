package 动态规划;


public class No_518零钱兑换2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        if (n == 0) {
            return amount == 0 ? 1 : 0;
        }

        int[][] dp = new int[n][amount + 1];
        // base case
        // 总金额 = 0，方案只有一个：所有硬币拿0个
        dp[0][0] = 1;
        // 初始化第一行,只考虑用第一种硬币。（为了下面计算数组不越界）
        for (int i = coins[0]; i <= amount; i += coins[0])
            dp[0][i] = 1;

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        return dp[n - 1][amount];
    }
}

/**
 public int change(int amount, int[] coins) {
 int n = coins.length;
 if (n == 0) {
 return amount == 0 ? 1 : 0;
 }

 int[] dp = new int[amount + 1];
 // base case
 dp[0] = 1;

 for (int i = 0; i < n; i++)
 for (int j = 0; j <= amount; j++) {
 // dp[i][j] = dp[i - 1][j];
 dp[j] = dp[j];
 if (j >= coins[i]) {
 // dp[i][j] += dp[i][j - coins[i]];
 dp[j] = dp[j] + dp[j - coins[i]];
 }
 }
 return dp[amount];
 }
 */