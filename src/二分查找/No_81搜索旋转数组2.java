package 二分查找;

public class No_81搜索旋转数组2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }

        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 先排除nums[mid]和nums[low]相等情况，向前缩小区间
            if (nums[mid] == nums[low]) {
                low++;
            } else if (nums[mid] > nums[low]) { // mid在左边
                // target在mid左边
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    // target在mid右边
                    low = mid + 1;
                }
            } else { // mid在右边
                // target在mid右边
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? true : false;
    }
}
