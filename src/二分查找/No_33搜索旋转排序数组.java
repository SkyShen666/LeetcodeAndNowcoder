package 二分查找;

public class No_33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // mid 在左半段
            if (nums[mid] >= nums[low]) {
                // target 在左半段且在 mid 左边
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // mid 在右半段
                // target 在右半段且在 mid 右边
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return nums[low] == target ? low : -1;
    }
}
