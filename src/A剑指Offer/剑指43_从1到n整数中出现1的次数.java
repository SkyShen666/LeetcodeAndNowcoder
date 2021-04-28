package A剑指Offer;

/**
 * 参考题解
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
 * 主要思路：
 *  将整数N，从1到n位开始计算，计算每个位即相当于固定此位。
 *  可联想生活中的滚轮密码锁，固定其中的一位密码（设为1），拨动其余位置的密码有多少组合。
 */
public class 剑指43_从1到n整数中出现1的次数 {
    public int countDigitOne(int n) {
        int cnt = 0; // 返回的结果
        int digit = 1; // 从1到n位开始计算
        int high = n / 10, cur = n % 10, low = 0; // 整数n分为3部分

        while (high != 0 || cur != 0) {
            if (cur == 0) {
                cnt += high * digit;
            } else if (cur == 1) {
                cnt += high * digit + low + 1;
            } else {
                cnt += (high + 1) * digit;
            }
            low = cur * digit + low;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }

        return cnt;
    }
}
