package 二分查找;

public class No_154寻找旋转数组中的最小值2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组为空！");
        }

        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // 警惕{1,3,3} 没旋转
            // {3,3,1,3}
            // 防止没有旋转和最右侧元素与左侧元素重复
            if (nums[mid] == nums[high]) {
                high--;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
