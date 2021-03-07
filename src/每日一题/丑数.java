package 每日一题;

/**
 * 动态规划
 * 满足 (n % 2 == 0) || (n % 3 == 0) || (n % 5 == 0)
 * 参考题解：
 * https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] dp = new int[index];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < index; i++) {
            // next2：下一个含因子2的丑数，dp[i2]是可能含因子2、3、5（其中一个或两个或全部）的丑数
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i2++;   //换下一个丑数，乘2
            if (dp[i] == next3)
                i3++;   //换下一个丑数，乘3
            if (dp[i] == next5)
                i5++;   //换下一个丑数，乘5
        }

        return dp[index - 1];
    }
}
