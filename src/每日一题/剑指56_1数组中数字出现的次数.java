package 每日一题;


/**
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/c-0ms-chao-ji-xiang-xi-jie-shi-kan-bu-dong-de-ji-2/
 */

public class 剑指56_1数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int diff = 0;
        //任何一个数字异或它自己都为0
        /**
         * diff: 是只出现一次的2个数字（a,b）的^,即 a ^ b。
         * 既然a,b 不一样，那么s肯定不是0，那么s的二进制肯定至少有1位是1(第n位)，只有0^1才等于1
         * 所以a,b 在第n位，要么a是0，b是1 ，要么b是0，a是1    ---->A
         */
        for (int num : nums) {
            diff ^= num;
        }

        /**
         * num = 3 ^ 5; 0011 ^ 0101 = 0110 = 6
         * 假设int是8位
         * -6  原码1000 0110
         *     反码1111 1001
         *     补码1111 1010
         * diff & -diff
         *      0000 0110
         * &    1111 1010
         *      0000 0010
         * 所以 k = diff & (-diff) 就是保留diff的最后一个1，并且将其他位变为0  也就是diff最后一个1是倒数第二位   --->B
         * 由于diff & (-diff)很方便找到一个1 所以用他了，其实找到任何一个1都可以
         */
        diff = diff & -diff;
        int[] ret = new int[2];
        for (int num : nums) {
            if ((diff & num) == 0) {
                ret[0] ^= num; // 出现两次的数字 x ^ x = 0
            } else {
                ret[1] ^= num;
            }
        }

        return ret;
    }
}
