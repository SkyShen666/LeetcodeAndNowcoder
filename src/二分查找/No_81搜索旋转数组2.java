package 二分查找;

public class No_81搜索旋转数组2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 排除mid和left一样的情况，将区间向前搜索，[left + 1, right]
            if (nums[mid] == nums[left]) {
                left = left + 1;
            } else if (nums[mid] > nums[left]) { // mid在左侧
                // target在mid左侧
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // mid在右侧
                // target在mid右侧
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? true : false;
    }
}
