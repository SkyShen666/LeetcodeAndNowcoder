package 每日一题;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/integer-break/solution/tan-xin-xuan-ze-xing-zhi-de-jian-dan-zheng-ming-py/
 */
public class 剪绳子 {
    public int cuttingRope(int n) {
        /*
            dp[i] 表示 i 的 最大加数和：
                对于任意一个数来讲，dp[i] 最大的可能为如下两点：
                    1、其中一个加数 * 对应的加数(i - j)
                    2、其中一个加数 * 对应的加数拆分后的最大乘积(dp[i - j])
         */
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
