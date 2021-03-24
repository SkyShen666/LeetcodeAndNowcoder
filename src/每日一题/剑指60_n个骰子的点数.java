package 每日一题;
import java.util.Arrays;

// 参考题解：
// https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
public class 剑指60_n个骰子的点数 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1 / 6d);

        for (int k = 2; k <= n; k++) {
            // n个骰子的值分布在 [n, 6n]中， 区间长度为 6n - n + 1 ==> 5 * k + 1
            // tmp[i]表示n-1个骰子，掷出的结果中，在下标为 i 处(点数和为i)的概率。
            double[] tmp = new double[5 * k + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < 6; j++) {
                    tmp[i + j] += dp[i] / 6.0;
                }
            }
            dp = tmp;
        }

        return dp;
    }
}
