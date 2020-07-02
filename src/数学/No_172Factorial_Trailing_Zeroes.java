package 数学;

import java.util.Arrays;

/**
 * Factorial阶乘
 * 阶乘后的零
 * 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
 * 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，即5的2次方
 * 其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
 */
public class No_172Factorial_Trailing_Zeroes {
    public static void main(String[] args) {
        int n = trailingZeroes(11);
        System.out.println(n);
    }

    private static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0){
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
    //return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);可直接用这一行代替，但可读性差
}
