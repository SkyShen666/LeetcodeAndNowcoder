package 数学;


/**
 * 质数(又称素数)是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。2、3、5、7
 */
public class No_204Count_Primes {
    public static void main(String[] args) {
        int count = countPrimes(10);
        System.out.println(count);
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
    private static int countPrimes(int n) {
        int count = 0;
        if (n < 3) {
            return 0;
        } else {
            for (int i = 2; i < n; i++) {
                int flag = 1;
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
