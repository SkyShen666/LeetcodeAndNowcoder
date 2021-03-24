package 位运算;

// 参考题解：
// https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/solution/qing-xi-jian-dan-you-qu-de-tui-li-yan-suan-by-hlxi/
public class No_1318或运算的最小翻转次数 {
    public int minFlips(int a, int b, int c) {
        int ret = 0;
        while (a != 0 || b != 0 || c != 0) {
            int pA = a & 1, pB = b & 1, pC = c & 1;
            a >>= 1;
            b >>= 1;
            c >>= 1;
            // 不需要进行翻转
            if ((pA | pB) == pC) {
                continue;
            }
            // 需要进行翻转
            if (pC == 1) {
                ret++;
            } else {
                if (pA == 1) {
                    ret++;
                }
                if (pB == 1) {
                    ret++;
                }
            }
        }

        return ret;
    }
}


