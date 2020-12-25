package 每日一题;
// 贪心法
// 参考题解：
// https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/yi-kan-jiu-dong-de-chao-zan-si-lu-bu-dian-zan-bu-g/
// https://leetcode-cn.com/problems/integer-break/solution/tan-xin-xuan-ze-xing-zhi-de-jian-dan-zheng-ming-py/
public class 剑指14_剪绳子2 {
    public int cuttingRope(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

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
