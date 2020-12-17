package 数组与矩阵;

import java.util.*;

// 15.三数之和 进阶版
// 在三数之和题解基础上再加一层循环
// 排序 + 双指针
public class No_18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int p = 0; p < n - 3; p++) {
            if (p > 0 && nums[p] == nums[p - 1]) {
                continue;
            }
            if (nums[p] + nums[p + 1] + nums[p + 2] + nums[p + 3] > target) {
                break;
            }
            if (nums[p] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }

            // 三数之和
            for (int q = p + 1; q < n - 2; q++) {
                if (q > p + 1 && nums[q] == nums[q - 1]) {
                    continue;
                }
                if (nums[p] + nums[q] + nums[q + 1] + nums[q + 2] > target) {
                    break;
                }
                if (nums[p] + nums[q] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                int i = q + 1, j = n - 1;
                while (i < j) {
                    int sum = nums[p] + nums[q] + nums[i] + nums[j];
                    if (sum == target) {
                        list.add(new ArrayList<>(Arrays.asList(nums[p], nums[q], nums[i], nums[j])));
                        i++;
                        j--;
                        while (i < j && nums[i] == nums[i - 1]) i++;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    } else if (sum < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }

        return list;
    }
}
