package 二分查找;

/**
 * 为什么比较mid与right而不比较mid与left？
 * 具体原因前面已经分析过了，简单讲就是因为我们找最小值，要偏向左找，目标值右边的情况会比较简单，容易区分，
 * 所以比较mid与right而不比较mid与left。
 */
public class No_153寻找旋转排序数组中的最小值 {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 注意比较中间数与最右边的数
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
