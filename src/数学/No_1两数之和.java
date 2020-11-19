package 数学;
import java.util.*;
public class No_1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) {
            throw new IllegalArgumentException("数组长度小于2,请重新输入!");
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
}
