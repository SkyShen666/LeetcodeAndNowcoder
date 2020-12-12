package 数学;

import java.util.Arrays;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
 * Factorial阶乘
 */
public class No_172阶乘后的零 {
    public int trailingZeroes(int n) {
        int cnt = 0;

        while (n > 0) {
            cnt += n / 5;
            n = n / 5;
        }

        return cnt;
    }
}
