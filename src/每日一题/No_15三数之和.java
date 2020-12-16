package 每日一题;
import java.util.*;

/**
 * 排序 + 双指针
 * 参考题解：
 * https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 */
public class No_15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int k = 0; k < n - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = n - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if (sum > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return list;
    }
}
