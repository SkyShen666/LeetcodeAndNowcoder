package 每日一题;

// 参考题解：
// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/javashi-xian-jian-zhi-si-lu-wei-yun-suan-zhu-wei-t/

/**
 * 如果一个数字出现三次,那么它的二进制表示的每一位(0或者1)也出现三次。
 * 如果把所有出现三次的数字的二进制表示的每一位都分别加起来,那么每一位的和都能被3整除。
 * 如果某一位的和能被3整除,那么那个只出现一次的数字二进制表示中对应的那一位是0; 否则就是1;
 */
public class 剑指56_2数组中数字出现的次数 {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32]; // bitSum[0]为符号位
        for (int num : nums) {
            int bit = 1;
            for (int i = 31; i >= 0; i--) { // 判断当前遍历到的二进制位上的值是否为 1
                if ((num & bit) != 0) {
                    bitSum[i]++;
                }
                bit = bit << 1;
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) { // 这种做法使得本算法同样适用于负数的情况
            ret = ret << 1;
            ret = ret + bitSum[i] % 3; // 这两步顺序不能变，否则最后一步会多左移一次
        }

        return ret;
    }
}
