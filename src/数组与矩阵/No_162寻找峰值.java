package 数组与矩阵;

/**
 * 题目描述：
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 方法：二分查找(迭代法)
 * 为什么二分查找大的那一半一定会有峰值呢？（即nums[mid]<nums[mid+1]时，mid+1~N一定存在峰值）
 * 我的理解是，首先已知 nums[mid+1]>nums[mid]，那么mid+2只有两种可能，一个是大于mid+1，一个是小于mid+1，
 * 小于mid+1的情况，那么mid+1就是峰值，
 * 大于mid+1的情况，继续向右推，如果一直到数组的末尾都是大于的，
 * 那么可以肯定最后一个元素是峰值，因为nums[nums.length]=负无穷
 */
public class No_162寻找峰值 {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
