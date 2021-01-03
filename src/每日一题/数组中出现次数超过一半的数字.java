package 每日一题;

/**
 * 同leetcode169
 * 投票法：
 *  1、遇到相同的就投一票，不同的就减一票
 *  2、当票数为0，就更新 “众数”
 */
public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int majority = nums[0];

        for (int num : nums) {
            if (cnt == 0) {
                majority = num;
            }
            cnt += (num == majority) ? 1 : -1;
        }

        return majority;
    }
}
