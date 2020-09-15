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
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
