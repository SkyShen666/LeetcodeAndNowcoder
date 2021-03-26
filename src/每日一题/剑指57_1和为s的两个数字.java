package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 双指针
 */
public class 剑指57_1和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{nums[low], nums[high]};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[0];
    }
}
