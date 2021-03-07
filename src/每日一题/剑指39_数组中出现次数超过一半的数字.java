package 每日一题;

/**
 * 同leetcode169、
 *
 * 解法1： 快排
 *
 * 解法2： 投票法
 *  1、遇到相同的就投一票，不同的就减一票
 *  2、当票数为0，就更新 “众数”
 */
public class 剑指39_数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                majority = nums[i];
            }
            cnt += nums[i] == majority ? 1 : -1;
        }

        return majority;
    }
}
