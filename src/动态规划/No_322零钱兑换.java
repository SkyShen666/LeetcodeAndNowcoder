package 动态规划;

import java.util.*;

/**
 * LeetCode 322
 * 动态规划，自底向上 （官方题解，方法三）
 * 我们采用自下而上的方式进行思考。
 * 仍定义 F(i) 为组成金额 i 所需最少的硬币数量，假设在计算 F(i)之前，
 * 我们已经计算出 F(0)--F(i-1)的答案。 则 F(i)对应的转移方程应为
 * F(i) = Min(F(i - coins[j]) + 1)   (j = 0 ... n-1)
 */
public class No_322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
