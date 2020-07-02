package 二分查找;

public class No_153寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    /**
     public int findMin(int[] nums) {
     int res = nums[0];
     for (int i = 0; i < nums.length - 1; i++) {
     if (nums[i] > nums[i + 1]) {
     res = nums[i + 1];
     break;
     }
     }
     return res;
     }
     */
}
