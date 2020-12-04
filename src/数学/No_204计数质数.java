package 数学;


import java.util.Arrays;

/**
 * 质数(又称素数)是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。2、3、5、7
 * 参考题解：
 * https://leetcode-cn.com/problems/count-primes/solution/kuai-lai-miao-dong-shai-zhi-shu-by-sweetiee/
 */
public class No_204计数质数 {
    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 注意每次找当前素数 x 的倍数时，是从 x^2开始的。
                // 因为如果 x > 2，那么 2 * x 肯定被素数 2 给过滤了，最小未被过滤的肯定是 x^2.
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}


    /**
     * 解法一：暴力法
     * 将isPrime那层循环的判定条件改为（由int j = 2; j < i; j++）
     * int j = 2; j * j <= i; j++
     * 理由如下：
     * 12 = 2 × 6
     * 12 = 3 × 4
     * * 12 = sqrt(12) × sqrt(12)  注意此行为分界
     * 12 = 4 × 3
     * 12 = 6 × 2
     *
     * @param n
     * @return
     */
//    public int countPrimes(int n) {
//        int cnt = 0;
//        for (int i = 2; i < n; i++) {
//            if (isPrime(i)) {
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//
//    private boolean isPrime(int n) {
//        int max = (int) Math.sqrt(n);
//        for (int i = 2; i <= max; i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
