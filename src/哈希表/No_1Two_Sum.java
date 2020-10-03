package 哈希表;

import java.util.*;

public class No_1Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) {
            throw new IllegalArgumentException("数组长度小于2，非法输入！");
        }
        Map<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]), i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }

    // 暴力枚举
//    public int[] twoSum(int[] nums, int target) {
//        int n = nums.length;
//        if (n < 2) {
//            throw new IllegalArgumentException("数组长度小于2，非法输入！");
//        }
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{-1, -1};
//    }
}
