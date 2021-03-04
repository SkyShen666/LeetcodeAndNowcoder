package 每日一题;

/**
 * 贪心思想
 */
public class 剑指63_股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                max = Math.max(max, prices[i] - minPrice);
            }
        }

        return max;
    }
}
