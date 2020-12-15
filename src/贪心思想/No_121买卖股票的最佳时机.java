package 贪心思想;

public class No_121买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        int profit = maxProfit(prices);
        System.out.println(profit);//profit = 6 - 1 = 5
    }

    private static int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i] - minPrice);
            }
        }
        return maxProfit;
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
