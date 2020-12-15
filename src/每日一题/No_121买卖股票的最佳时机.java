package 每日一题;

public class No_121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int minPrice = prices[0];
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                max = Math.max(max, prices[i] - minPrice);
            }
        }

        return max;
    }
}
