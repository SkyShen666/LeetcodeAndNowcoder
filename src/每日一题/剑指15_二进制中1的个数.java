package 每日一题;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
 * n & (n - 1) ：去除n的位级表示中最低的一位
 * n :       10110100
 * n-1 :     10110011
 * n&(n-1) : 10110000
 */
public class 剑指15_二进制中1的个数 {
    public int hammingWeight(int n) {
        int cnt = 0;

        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }

        return cnt;
    }
}

//    时间复杂度O(n)
//
//    public int hammingWeight(int n) {
//        int cnt = 0;
//
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                cnt++;
//            }
//            n >>>= 1;
//        }
//
//        return cnt;
//    }