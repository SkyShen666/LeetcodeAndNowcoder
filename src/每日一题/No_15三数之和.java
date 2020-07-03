package 每日一题;
import java.util.*;

/**
 * 暴力法的时间复杂度是 O(n^3)。可以先固定一个值，然后寻找后两个值时可采取双指针的方法，将总的时间复杂度优化到 O(n^2)。
 *
 * 实现的过程中，要注意优化以及去重。
 *
 * 首先我们先对原数组进行排序，这样可以把重复的值集中到一起，便于去重。
 *
 * 确定第一个元素时，如果它已经比 0 大了，那么可以直接跳出循环，因为后面的数字都比它大。如 [1, 2, 3, 4], i = 0, nums[i] > 0, 这样是不可能产生合法的情况的，直接 break。
 *
 * 确定第一个元素时，如果发现它与它前面的值一样，那么跳过本轮。如 [-1, -1, 0, 1], 在第一轮后，已经选出了 {-1, 0, 1}, 现在 i = 1，nums[i] == nums[i - 1], 为了避免重复，直接 continue。
 *
 * 接下来利用双指针，left 指向 i + 1, right 指向 nums.length - 1。逐个进行判断，并注意去重。
 * ————————————————
 * 原文链接：https://blog.csdn.net/starflyyy/article/details/106955473
 */
public class No_15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 此次循环的第一个元素大于0(不能加上等于零的条件，需考虑0,0,0)
            if (nums[i] < 0)
                break;
            // 避免与上次循环的结果重复,注意防止溢出
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) { // 第二层循环
                if (target == nums[left] + nums[right]) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    res.add(list);
                    // 防止重复，考虑如 -2,-1,-1,-1,3,3,3
                    left++; right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (target > nums[left] + nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
