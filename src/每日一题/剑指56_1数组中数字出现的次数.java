package 每日一题;


/**
 * 此题 通过异或操作(^) 将出现两次的数计算为0， 而两个只出现一次的数，在异或操作之后，二进制位上不同位的值均为 1
 * 只需要取出最后一个位上的1，以此为标记 即可判断两个只出现一次的数
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/c-0ms-chao-ji-xiang-xi-jie-shi-kan-bu-dong-de-ji-2/
 */

public class 剑指56_1数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int diff = 0;
        /**
         * 任何一个数字异或它自己都为0
         * diff: 是只出现一次的2个数字 (a,b) 的 ^, 即 diff = a ^ b。
         * 既然 a,b 不相等，那么 diff 肯定不是0，那么 diff 的二进制肯定至少有 1 位是 1 (假设在第 n 位)，只有 0^1 才等于 1
         * 所以 a,b 在第n位，要么 a 是 0，b 是 1 ，要么 b 是 0，a 是 1
         */
        for (int num : nums) {
            diff ^= num;
        }

        /**
         * num = 3 ^ 5; 即 0011 ^ 0101 = 0110 = 6
         * 假设int是8位
         * -6  原码1000 0110
         *     反码1111 1001
         *     补码1111 1010
         * 设 diff = 6
         * diff & -diff ： 取出diff位上最后一个1，其余位置为0
         *      0000 0110
         * &    1111 1010
         *      0000 0010
         * 所以 diff = diff & (-diff) 就是保留 diff 二进制位上的的最后一个 1 ，并且将其他位变为0  也就是 diff = 6 最后一个 1 是倒数第二位
         * 需要把其它二进制位上的值置为0，避免影响计算结果，只取最后一个位上为1的值即可，标记两个只出现一次的不同值(a,b)
         * 由于diff & (-diff) 很方便找到一个1 所以用他了，其实找到任何一个1都可以
         */
        diff = diff & -diff;
        int[] ret = new int[2];
        for (int num : nums) {
            if ((diff & num) == 0) { // 找到对应位(设diff=6，即倒数第二位为 0 的只出现一次的数 a(假设为a))
                ret[0] ^= num; // 出现两次的数字 x ^ x = 0
            } else {
                ret[1] ^= num;
            }
        }

        return ret;
    }
}
