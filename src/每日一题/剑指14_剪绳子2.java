package 每日一题;

/**
 * 此题用动态规划不太方便，因为中间的计算过程会溢出
 * 使用int会溢出, 用long也会溢出，需要使用BigInteger太麻烦了。
 * 所以用贪心
 *
 * 思路：
 * 当绳子长度大于4时，尽可能多的分成长度为3的小段，这样乘积是最大的。（数学证明自行查找）
 *
 * 注意此题比剪绳子第一题还多了个条件：m > 1 && n > 1
 * 参考题解：
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/yi-kan-jiu-dong-de-chao-zan-si-lu-bu-dian-zan-bu-g/
 * https://leetcode-cn.com/problems/integer-break/solution/tan-xin-xuan-ze-xing-zhi-de-jian-dan-zheng-ming-py/
 */
public class 剑指14_剪绳子2 {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        // 计算过程中可能会超出int取值范围：ret = ret * 3;
        long ret = 1;
        while (n > 4) {
            ret = ret * 3;
            ret = ret % 1000000007;
            n = n - 3;
        }
        ret = ret * n % 1000000007;

        return (int)ret;
    }
}
