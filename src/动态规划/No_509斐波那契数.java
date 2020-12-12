package 动态规划;

// 动态规划（空间优化后）
public class No_509斐波那契数 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        int pre = 0;
        int curr = 1;

        for (int i = 2; i <= N; i++) {
            int next = curr + pre;
            pre = curr;
            curr = next;
        }

        return curr;
    }
}

// 动态规划
//
//    public int fib(int N) {
//        if (N == 0) {
//            return 0;
//        }
//        if (N == 1) {
//            return 1;
//        }
//
//        int[] dp = new int[N + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i <= N; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[N];
//    }
//

// 递归
//
//    public int fib(int N) {
//        if (N == 0) {
//            return 0;
//        }
//        if (N == 1) {
//            return 1;
//        }
//
//        return fib(N - 1) + fib(N - 2);
//    }