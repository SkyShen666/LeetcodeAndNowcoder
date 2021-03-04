package 每日一题;

// 参考题解：
// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/javashi-xian-jian-zhi-si-lu-wei-yun-suan-zhu-wei-t/
public class 剑指56_2_数组中数字出现的次数 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] bitSum = new int[32];
        for (int num : nums) {
            int bit = 1;
            for (int i = 31; i >= 0; i--) {
                if ((num & bit) != 0) {
                    bitSum[i]++;
                }
                bit = bit << 1;
            }
        }

        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = ret << 1;
            ret = ret + bitSum[i] % 3;
        }

        return ret;
    }
}
