package 二分查找;

/**
 * 为什么比较 mid 与 high 而不比较 mid 与 low ?
 * 简单讲就是因为我们找最小值，要偏向左找，目标值右边的情况会比较简单，容易区分，
 * 所以比较 mid与 high 而不比较 mid 与 low。
 */
public class No_153寻找旋转排序数组中的最小值 {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
