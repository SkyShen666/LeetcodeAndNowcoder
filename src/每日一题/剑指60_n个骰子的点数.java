package 每日一题;
import java.util.Arrays;

// 参考题解：
// https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/java-dong-tai-gui-hua-by-zhi-xiong/
// n个骰子的值分布在 [n, 6n]中， 区间长度为 6n - n + 1 ==> 5 * k + 1
// dp[i]表示n-1个骰子，掷出的结果中，在下标为i处的概率。
public class 剑指60_n个骰子的点数 {
    public double[] dicesProbability(int n) {
        double[] pre = new double[6];
        Arrays.fill(pre, 1 / 6d);

        for (int k = 2; k <= n; k++) {
            double[] dp = new double[5 * k + 1];
            for (int i = 0; i < pre.length; i++) {
                for (int j = 0; j < 6; j++) {
                    dp[i + j] = dp[i + j] + pre[i] / 6;
                }
            }
            pre = dp;
        }

        return pre;
    }
}
