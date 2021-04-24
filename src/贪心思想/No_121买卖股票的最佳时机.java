package 贪心思想;

public class No_121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (minPrice < prices[i]) {
                max = Math.max(max, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return max;
    }
/*
    public static int maxProfit(int[] prices){
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] - prices[i] > profit){
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }
*/
}
