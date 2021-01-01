package 每日一题;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class 剑指53_在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left, right;

        // 找第一个位置
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] != target) {
            return 0;
        }
        left = low;

        // 找第二个位置
        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] == target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        right = low;

        return right - left + 1;
    }
}
