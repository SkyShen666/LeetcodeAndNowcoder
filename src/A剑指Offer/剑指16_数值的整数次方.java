package A剑指Offer;

/**
 * 快速幂实际上是分治思想的一种应用。
 * 分治思想
 * 参考题解：
 * https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
 *
 * n&1（与操作）： 判断 n 二进制最右一位是否为 1；
 * n>>1（移位操作）： n 右移一位（可理解为删除最后一位）。
 */
public class 剑指16_数值的整数次方 {
    public double myPow(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }

        // Java 代码中 int32 变量 n∈[−2147483648, 2147483647]。
        // 因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 b，后面用 b 操作即可。
        long b = n;
        double ret = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            // 如果是奇数次幂，会在开始时多计算一次 ret *= x
            // 如果是偶数次幂，仅会在最后一次 b = 1 时计算一次 ret *= x
            if ((b & 1) == 1) { // (b & 1) == 1 相当于 b % 2 == 1
                ret *= x;
            }
            x *= x; // 这样省去一半的计算过程
            b >>= 1;  // 相当于 b /= 2;
        }

        return ret;
    }
}
