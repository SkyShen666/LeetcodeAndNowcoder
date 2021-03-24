package 二分查找;

/**
 * 方法：二分查找(迭代法)
 * 为什么二分查找大的那一半一定会有峰值呢？（即 nums[mid] < nums[mid+1] 时，[mid + 1, n - 1]一定存在峰值）
 * 我的理解是，首先已知 nums[mid] < nums[mid + 1]，那么 mid+2 只有两种可能，一个是大于mid+1，一个是小于mid+1，
 * 小于 mid+1 的情况，那么 mid+1 就是峰值，
 * 大于 mid+1 的情况，继续向右推，如果一直到数组的末尾都是大于的，
 * 那么可以肯定最后一个元素是峰值，因为nums[nums.length]=负无穷
 *
 * 2） nums[mid] > nums[mid + 1] 时， [low, mid] 一定会存在峰值
 *     1. 若 (nums[mid - 1] < nums[mid]) 则  nums[mid] 就是峰值
 *     2. 若 (nums[mid - 1] > nums[mid]) 则  继续向左推....
 * 注意：题干已经说明 nums[i] != nums[i + 1]
 * 核心思想：答案就在[low, high]区间内,若 nums[mid] < nums[mid + 1] ==> 答案在 [mid + 1, high] 中 ==> low = mid + 1
 *                                   若 nums[mid] > nums[mid + 1] ==> 答案在 [low, mid] 中 ==> high = mid
 */
public class No_162寻找峰值 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
