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
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) { // 当前股票价格更低，不适合卖出，更新最低价格
                minPrice = prices[i];
            } else { // 当前股票价格更高，可以考虑卖出，记录此时卖出的利润
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
