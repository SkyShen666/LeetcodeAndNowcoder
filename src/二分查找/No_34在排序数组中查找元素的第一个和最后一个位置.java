package 二分查找;

public class No_34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) -1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, last};
        }
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
