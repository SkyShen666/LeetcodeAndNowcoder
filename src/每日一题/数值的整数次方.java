package 每日一题;

/**
 * 分治思想
 * 参考题解：
 * https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
 */
public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long b = n;
        double ret = 1;

        // Java 代码中 int32 变量 n∈[−2147483648,2147483647]。
        // 因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 b，后面用 b 操作即可。
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                ret *= x;
            }
            x *= x;
            b >>= 1;
        }

        return ret;
    }
}
