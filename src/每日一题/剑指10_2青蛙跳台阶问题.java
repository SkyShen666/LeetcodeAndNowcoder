package 每日一题;

/**
 * 动态规划
 */
public class 剑指10_2青蛙跳台阶问题 {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        int a = 1, b = 1;
        int sum;

        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return b;
    }
}

//    空间优化前
//    public int numWays(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n == 1) {
//            return 1;
//        }
//
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//        }
//
//        return dp[n];
//    }