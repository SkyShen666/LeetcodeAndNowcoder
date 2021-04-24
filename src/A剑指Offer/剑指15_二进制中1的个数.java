package A剑指Offer;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
 * (n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
 * n & (n - 1) ：二进制数字 n 最右边的 1 变成 0 ，其余不变。
 * n :       10110100
 * n-1 :     10110011
 * n&(n-1) : 10110000
 */
public class 剑指15_二进制中1的个数 {
    public int hammingWeight(int n) {
        int cnt = 0;

        // 注意需要 n != 0, 而不能是 n > 0 ，n可能为负数
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