package 贪心思想;

/**
 * 和剑指offer 剪绳子是一道题
 */
public class No_343整数拆分 {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        int ret = 1;
        while (n > 4) {
            ret = ret * 3;
            n = n - 3;
        }
        ret = ret * n;

        return ret;
    }
}

//    动态规划解法：
//    public int integerBreak(int n) {
//        if (n <= 2) {
//            return 1;
//        }
//
//        int[] dp = new int[n + 1];
//
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j <= i - 1; j++) {
//                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
//            }
//        }
//
//        return dp[n];
//    }