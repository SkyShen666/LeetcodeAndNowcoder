package 动态规划;

// 参考题解：
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/jian-dan-dpmiao-dong-gu-piao-mai-mai-by-tejdo/
public class No_714买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp[i][0/1] 优化为 dp[0/1]
        // dp[0]:第i天不持有股票的最大利润
        // dp[1]:第i天持有股票的最大利润
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int tmp = dp[0];
            // 对于今天不持有，可以从两个状态转移过来：1. 昨天也不持有；2. 昨天持有，今天卖出。两者取较大值。
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            // 对于今天持有，可以从两个状态转移过来：1. 昨天也持有；2. 昨天不持有，今天买入。两者取较大值。
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }

        return dp[0];
    }
}
