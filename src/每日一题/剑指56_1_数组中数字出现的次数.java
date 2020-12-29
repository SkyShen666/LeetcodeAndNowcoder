package 每日一题;


/**
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/c-0ms-chao-ji-xiang-xi-jie-shi-kan-bu-dong-de-ji-2/
 */

public class 剑指56_1_数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int diff = 0;
        //任何一个数字异或它自己都为0
        for (int num : nums) {
            diff ^= num;
        }

        /**
         * diff & -diff
         * 得到两个不同数字,按位异或运算的二进制表示中,最右侧第一个为 1 的位置
         * 并且此 diff 其余位上皆为 0
         * 两个不同数字在 diff 的 1 那个位上是不同的，一个为 1，一个为 0
         * 以此就可以利用 & (按位与运算)
         */
        diff = diff & -diff;
        int[] ret = new int[2];
        for (int num : nums) {
            if ((diff & num) == 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }

        return ret;
    }
}
