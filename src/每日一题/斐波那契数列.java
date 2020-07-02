package 每日一题;


/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * f(0) = 0                 n = 0
 * f(1) = 1                 n = 1
 * f(n) = f(n-1) + f(n-2)   n > 1
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 0, pre2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
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