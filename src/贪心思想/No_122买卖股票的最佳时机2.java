package 贪心思想;

/**
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
 * 而 d - a = (d - c) + (c - b) + (b - a) （重点这一步！！！）
 * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
public class No_122买卖股票的最佳时机2 {
    public int maxProfit(int[] prices){
        int sumProfit = 0;

        for (int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i-1] > 0){
                sumProfit += prices[i] - prices[i-1];
            }
        }

        return sumProfit;
    }
}
