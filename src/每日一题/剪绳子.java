package 每日一题;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * f(2) = 1;
 * f(3) = 2;
 * f(4) = Max( f(3) * f(1) , f(2) * f(2) )
 */
public class 剪绳子 {
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] dp = new int[target + 1];
        //每段长度
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], max);
                max = dp[i];
            }
        }
        return max;
    }
}
