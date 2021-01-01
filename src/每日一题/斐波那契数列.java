package 每日一题;


/**
 * 动态规划
 *
 */
public class 斐波那契数列 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum;

        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return b;
    }

//    优化空间前
//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//        }
//
//        return dp[n];
//    }
}
/**
 * 解法一：递归求解。缺点:会进行大量的重复计算 -->解决方法：动态规划
 public int Fibonacci(int n) {
    if (n == 0) {
        return 0;
    }else if (n == 1) {
        return 1;
    }else {
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
 }
 */