package A剑指Offer;

/**
 * 动态规划
 * 满足 (n % 2 == 0) || (n % 3 == 0) || (n % 5 == 0)
 *
 * 丑数的递推性质： 丑数只包含因子 2, 3, 5 ，因此有 “丑数 == 某较小丑数 * 某因子” （例如：10 = 5 * 2）。
 *
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。(注意：包含 1)
 * 参考题解：
 * https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
 */
public class 剑指49_丑数 {
    public int GetUglyNumber_Solution(int n) {
        if (n <= 0) {
            return 0;
        }

        // dp[i]: 第(i + 1)个丑数
        int[] dp = new int[n];
        dp[0] = 1; //  第一个丑数
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            // next2：下一个含因子2的丑数，dp[i2]是可能含因子2、3、5（其中一个或两个或全部）的丑数
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) // 注意：这三个条件应该都判断一遍（dp[i]可同时包含：2或3或5）
                i2++;   //换下一个丑数，乘2
            if (dp[i] == next3)
                i3++;   //换下一个丑数，乘3
            if (dp[i] == next5)
                i5++;   //换下一个丑数，乘5
        }

        return dp[n - 1];
    }
}
