package 二分查找;

public class No_33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // mid在左边
            if (nums[mid] >= nums[left]) {
                // target在左边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else { // target在右边
                    left = mid + 1;
                }
            } else { // mid在右边
                // target在右边
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}

