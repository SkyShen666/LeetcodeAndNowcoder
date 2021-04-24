package A剑指Offer;

/**
 * 双指针
 */
public class 剑指21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] % 2 == 1) low++;
            while (low < high && nums[high] % 2 == 0) high--;
            swap(nums, low, high);
            low++;
            high--;
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}