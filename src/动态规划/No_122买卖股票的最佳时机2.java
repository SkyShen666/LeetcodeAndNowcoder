package 动态规划;

// 参考题解：
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/jian-dan-dpmiao-dong-gu-piao-mai-mai-by-uc68p/
public class No_122买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }

        return dp[0];
    }
}

/**
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
 * 而 d - a = (d - c) + (c - b) + (b - a) （重点这一步！！！）
 * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
//    贪心算法：
//
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//
//        int n = prices.length;
//        int max = 0;
//
//        for (int i = 1; i < n; i++) {
//            if (prices[i] > prices[i - 1]) {
//                max += prices[i] - prices[i - 1];
//            }
//        }
//
//        return max;
//    }
