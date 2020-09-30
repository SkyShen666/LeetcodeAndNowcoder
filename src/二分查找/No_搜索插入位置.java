package 二分查找;

public class No_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
